CREATE TABLE product_amount (
    id bigint NOT NULL,
    orders_id bigint NOT NULL,
    product_id bigint NOT NULL,
    product_amount int,
    FOREIGN KEY (orders_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    PRIMARY KEY (id));


CREATE SEQUENCE productAmount_seq
    INCREMENT 1
    START 10
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

