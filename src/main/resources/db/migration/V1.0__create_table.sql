DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tasks;

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

CREATE TABLE tasks
(
    id bigserial NOT NULL,
    title VARCHAR(100),
    description VARCHAR(255),
    user_id INTEGER,
    PRIMARY KEY (id)
);

ALTER TABLE tasks ADD FOREIGN KEY (user_id) REFERENCES users;