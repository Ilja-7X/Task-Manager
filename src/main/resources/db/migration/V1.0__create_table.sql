DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tasks;

CREATE TABLE users
(
    id bigserial NOT NULL,
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
    description TEXT,
    user_id INTEGER references users(id),
    PRIMARY KEY (id)
);