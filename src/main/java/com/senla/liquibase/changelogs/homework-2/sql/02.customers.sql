CREATE TABLE customers (
  id int NOT NULL,
  name varchar(45) NOT NULL,
  discount_cards_id int ,
  PRIMARY KEY (id,discount_cards_id),
  CONSTRAINT fk_customers_discount_cards1
  FOREIGN KEY (discount_cards_id)
  REFERENCES discount_cards (id)
) ;
