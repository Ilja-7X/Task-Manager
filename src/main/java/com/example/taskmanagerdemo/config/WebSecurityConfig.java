package com.example.taskmanagerdemo.config;

import com.example.taskmanagerdemo.model.Permission;
import com.example.taskmanagerdemo.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

@Controller
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.GET,"/").permitAll();
                    auth.requestMatchers(HttpMethod.GET,"/user/**").hasAuthority(Permission.DEVELOPERS_READ.getPermission());
                    auth.requestMatchers(HttpMethod.GET,"/users").hasAuthority(Permission.DEVELOPERS_READ.getPermission());
                    auth.requestMatchers(HttpMethod.POST,"/new-user/**").hasAuthority(Permission.DEVELOPERS_WRITE.getPermission());
                    auth.requestMatchers(HttpMethod.DELETE, "/delete-user/**").hasAuthority(Permission.DEVELOPERS_WRITE.getPermission());
                    auth.requestMatchers(HttpMethod.GET,"/auth/**").hasAuthority(Permission.DEVELOPERS_READ.getPermission());

                })
                .formLogin(formLogin -> formLogin.loginPage("/auth/login").permitAll()
                                .defaultSuccessUrl("/auth/success")
                                .permitAll()
                ).build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .authorities(Role.USER.getAuthorities())
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities(Role.ADMIN.getAuthorities())
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
