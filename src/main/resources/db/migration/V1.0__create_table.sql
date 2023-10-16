DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id bigint NOT NULL,
    email VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255),
    status VARCHAR(255),
    PRIMARY KEY (id)
);