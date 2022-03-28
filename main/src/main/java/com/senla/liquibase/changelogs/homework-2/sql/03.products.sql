CREATE TABLE products(
  id bigint NOT NULL,
  title varchar(45) NOT NULL,
  price int NOT NULL,
  amount int NOT NULL,
  purchase_quantity int,
  PRIMARY KEY (id)
) ;
CREATE SEQUENCE products_seq
    INCREMENT 1
    START 10
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;