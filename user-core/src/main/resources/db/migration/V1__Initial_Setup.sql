CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
create table if not exists user_info
(
    uuid uuid default uuid_generate_v4() not null
        constraint user_pk
            primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null

);