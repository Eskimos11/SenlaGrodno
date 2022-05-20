CREATE TABLE users (
    id bigint NOT NULL,
    username varchar(20),
    password varchar(100),
    role_id bigint,
    details_id bigint,
    FOREIGN KEY (role_id) REFERENCES role(id),
    FOREIGN KEY (details_id) REFERENCES details(id),
    PRIMARY KEY (id));


CREATE SEQUENCE users_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

