CREATE TABLE customers (
  idcustomers int NOT NULL,
  name varchar(45) NOT NULL,
  discount_cards_iddiscount_cards int ,
  PRIMARY KEY (idcustomers,discount_cards_iddiscount_cards),
  CONSTRAINT fk_customers_discount_cards FOREIGN KEY (discount_cards_iddiscount_cards) REFERENCES discount_cards (iddiscount_cards)
) ;
