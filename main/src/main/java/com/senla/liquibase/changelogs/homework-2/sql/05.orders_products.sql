CREATE TABLE orders_products (
  orders_id bigint NOT NULL,
  products_id bigint NOT NULL,
  PRIMARY KEY (orders_id, products_id),
  FOREIGN KEY (orders_id) REFERENCES orders(id),
  FOREIGN KEY (products_id) REFERENCES products(id));