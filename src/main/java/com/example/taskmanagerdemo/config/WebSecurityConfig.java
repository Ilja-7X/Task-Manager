package com.example.taskmanagerdemo.config;

import com.example.taskmanagerdemo.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "security")
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.GET,"/").permitAll();
                    auth.requestMatchers(HttpMethod.GET,"/user/**").hasAuthority(Permission.DEVELOPERS_READ.getPermission());
                    auth.requestMatchers(HttpMethod.GET,"/users").hasAuthority(Permission.DEVELOPERS_READ.getPermission());
                    auth.requestMatchers(HttpMethod.POST,"/new-user/**").hasAuthority(Permission.DEVELOPERS_READ.getPermission());
                    auth.requestMatchers(HttpMethod.DELETE, "/delete-user/**").hasAuthority(Permission.DEVELOPERS_WRITE.getPermission());
                    auth.requestMatchers(HttpMethod.GET,"/auth/**").hasAuthority(Permission.DEVELOPERS_READ.getPermission());

                })
                .formLogin(formLogin -> formLogin.loginPage("/auth/login").permitAll()
                                .defaultSuccessUrl("/auth/success")
                                .permitAll()
                ).build();
    }

    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
