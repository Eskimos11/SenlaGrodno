CREATE TABLE orders (
  id int NOT NULL,
  sum int,
  discount_card_id int,
  FOREIGN KEY (discount_card_id) REFERENCES discount_cards(id),
  PRIMARY KEY (id)
) ;

CREATE SEQUENCE orders_seq
    INCREMENT 1
    START 10
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
