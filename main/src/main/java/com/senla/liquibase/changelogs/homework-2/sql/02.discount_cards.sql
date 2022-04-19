CREATE TABLE discount_cards (
  id bigint NOT NULL,
  number varchar(45) NOT NULL,
  status varchar(45) NOT NULL,
  balance int,
  details_id bigint,
  PRIMARY KEY (id),
  FOREIGN KEY (details_id) REFERENCES details(id)
) ;
    CREATE SEQUENCE discountcard_seq
        INCREMENT 1
        START 10
        MINVALUE 1
        MAXVALUE 9223372036854775807
        CACHE 1;