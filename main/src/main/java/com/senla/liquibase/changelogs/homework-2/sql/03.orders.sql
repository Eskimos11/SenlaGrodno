CREATE TABLE orders (
  id int NOT NULL,
  sum int,
  discountCard_id int,
  FOREIGN KEY (discountCard_id) REFERENCES discountCard(id),
  PRIMARY KEY (id)
) ;

CREATE SEQUENCE orders_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
