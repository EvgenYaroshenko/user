ALTER TABLE user_info
    ADD COLUMN user_name varchar(255) not null;

ALTER TABLE user_info ADD CONSTRAINT user_name__unique UNIQUE (user_name);

ALTER TABLE user_info
    ADD COLUMN password_hash varchar(255) not null;

CREATE TABLE role(
     role_id serial PRIMARY KEY,
     role_name VARCHAR (255) UNIQUE NOT NULL
);

INSERT INTO role(role_id, role_name)
VALUES (0, 'ADMIN'), (1, 'USER');

ALTER TABLE user_info
    ADD COLUMN role_id integer not null;

ALTER TABLE user_info
    ADD CONSTRAINT fk_role_id
        FOREIGN KEY (role_id)
            REFERENCES role(role_id);