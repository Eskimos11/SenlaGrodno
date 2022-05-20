delete from USERS;
-- delete from ROLE;
delete from orders_products;
delete from product_amount;
delete from orders;
delete from products;
delete from discount_cards;
select setval('products_seq', 1);
select setval('productamount_seq', 1);
select setval('orders_seq', 1);
select setval('discountcard_seq', 1);
select setval('details_seq', 1);

-- -- --DETAILS
-- INSERT INTO details(id, first_name, last_name, city, phone_number)VALUES (1,'Pavel','Kurilo', 'Grodno', '+375297279574');
-- INSERT INTO details(id, first_name, last_name, city, phone_number)VALUES (2,'Anna','Lalal', 'Grodno', '+375291231231');
-- --USERS
-- INSERT INTO users(id, username, password, role_id, details_id)VALUES (1,'pavel','123',1,1);
-- --PRODUCTS
-- INSERT INTO products(id, title, price, amount) VALUES (1, 'Kvas', 10, 100);
-- INSERT INTO products(id, title, price, amount) VALUES (2, 'Moloko', 12, 100);
-- INSERT INTO products(id, title, price, amount) VALUES (3, 'xleb', 13, 100);
-- INSERT INTO products(id, title, price, amount) VALUES (4, 'Kefir', 14, 100);
-- --CARD
-- INSERT INTO discount_cards(id, "number", status, balance) VALUES (1, '123', 'BRONZE', 0);