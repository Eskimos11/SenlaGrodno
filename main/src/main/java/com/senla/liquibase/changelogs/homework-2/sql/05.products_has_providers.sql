CREATE TABLE products_has_providers (
  products_idproducts int NOT NULL,
  providers_idproviders int NOT NULL,
  PRIMARY KEY (products_idproducts,providers_idproviders),
  CONSTRAINT fk_products_has_providers_products1 FOREIGN KEY (products_idproducts) REFERENCES products (idproducts),
  CONSTRAINT fk_products_has_providers_providers1 FOREIGN KEY (providers_idproviders) REFERENCES providers (idproviders)
);
