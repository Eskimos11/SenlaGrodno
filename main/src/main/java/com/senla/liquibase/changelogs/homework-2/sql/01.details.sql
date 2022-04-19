CREATE TABLE details (
	id bigint,
	first_name varchar(20),
	last_name varchar(20),
	city varchar(15),
	phone_number varchar(25),
 PRIMARY KEY (id)
);

CREATE SEQUENCE details_seq
    INCREMENT 1
    START 10
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


