ALTER TABLE user_info
    ADD COLUMN email varchar not null;

ALTER TABLE user_info
    ADD COLUMN locked Boolean not null;

ALTER TABLE user_info
    ADD COLUMN enabled Boolean not null;

ALTER TABLE user_info
    ADD COLUMN account_expired Boolean not null;

ALTER TABLE user_info
    ADD COLUMN credentials_expired Boolean not null;