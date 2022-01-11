CREATE TABLE users (
    id int NOT NULL,
    username varchar(20),
    password varchar(100),
    role int,
    details_id int,
    FOREIGN KEY (role) REFERENCES role(id),
    FOREIGN KEY (details_id) REFERENCES details(id),
    PRIMARY KEY (id));


CREATE SEQUENCE users_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

