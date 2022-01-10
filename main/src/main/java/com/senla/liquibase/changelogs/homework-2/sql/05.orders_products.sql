CREATE TABLE orders_products
(
    orders_id integer NOT NULL,
    products_id integer NOT NULL,
    amount integer,
    CONSTRAINT orders_products_pkey PRIMARY KEY (orders_id, products_id),
    CONSTRAINT orders_products FOREIGN KEY (products_id)
        REFERENCES public.products (id)
    CONSTRAINT products_orders FOREIGN KEY (orders_id)
        REFERENCES public.orders (id)

)