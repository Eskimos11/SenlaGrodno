CREATE TABLE orders (
  id int NOT NULL,
  products_id int NOT NULL,
  customers_id int NOT NULL,
  customers_discount_cards_id int ,
  PRIMARY KEY (id, products_id,customers_id,customers_discount_cards_id),

  CONSTRAINT fk_orders_customers1 FOREIGN KEY (customers_id, customers_discount_cards_id) REFERENCES customers (id, discount_cards_id),
  CONSTRAINT fk_orders_products1 FOREIGN KEY (products_id) REFERENCES products (id)
) ;
