CREATE TABLE role (
    id int,
    name varchar(15),
    PRIMARY KEY (id));

    CREATE SEQUENCE role_seq
        INCREMENT 1
        START 10
        MINVALUE 1
        MAXVALUE 9223372036854775807
        CACHE 1;