CREATE TABLE products_providers (
  providers_id INT NOT NULL,
  products_id INT NOT NULL,
  PRIMARY KEY (providers_id, products_id),
  CONSTRAINT fk_products_has_providers_products1 FOREIGN KEY (products_id) REFERENCES products (id),
  CONSTRAINT fk_products_has_providers_providers1 FOREIGN KEY (providers_id) REFERENCES providers (id)
);
