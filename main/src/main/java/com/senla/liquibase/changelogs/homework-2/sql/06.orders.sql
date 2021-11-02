CREATE TABLE orders (
  idorders int NOT NULL,
  products_idproducts int NOT NULL,
   customers_idcustomers int NOT NULL,
  customers_discount_cards_iddiscount_cards int ,
  PRIMARY KEY (idorders, products_idproducts,customers_idcustomers,customers_discount_cards_iddiscount_cards),

  CONSTRAINT fk_orders_customers1 FOREIGN KEY (customers_idcustomers, customers_discount_cards_iddiscount_cards) REFERENCES customers (idcustomers, discount_cards_iddiscount_cards),
  CONSTRAINT fk_orders_products1 FOREIGN KEY (products_idproducts) REFERENCES products (idproducts)
) ;
