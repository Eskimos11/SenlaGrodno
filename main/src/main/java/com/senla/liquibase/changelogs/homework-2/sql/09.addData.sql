--ROLE
INSERT INTO role(id, name) VALUES (1, 'ADMIN');
INSERT INTO role(id, name) VALUES (2, 'USER');
--DETAILS
INSERT INTO details(id, first_name, last_name, city, phone_number)VALUES (1,'Pavel','Kurilo', 'Grodno', '+375297279574');
INSERT INTO details(id, first_name, last_name, city, phone_number)VALUES (2,'Anna','Lalal', 'Grodno', '+375291231231');
--USERS
INSERT INTO users(id, username, password, role_id, details_id)VALUES (1,'pavel','123',1,1);
--PRODUCTS
INSERT INTO products(id, title, price, amount) VALUES (1124, 'Kvas', 10, 100);
INSERT INTO products(id, title, price, amount) VALUES (2214, 'Moloko', 12, 100);
INSERT INTO products(id, title, price, amount) VALUES (3241, 'xleb', 13, 100);
INSERT INTO products(id, title, price, amount) VALUES (4124, 'Kefir', 14, 100);
--CARD
INSERT INTO discount_cards(id, "number", status, balance) VALUES (1, '123', 'BRONZE', 0);

--