CREATE TABLE discount_cards (
  id int NOT NULL,
  number varchar(45) NOT NULL,
  balance int,
  details_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (details_id) REFERENCES details(id),
) ;
    CREATE SEQUENCE discountcard_seq
        INCREMENT 1
        START 1
        MINVALUE 1
        MAXVALUE 9223372036854775807
        CACHE 1;