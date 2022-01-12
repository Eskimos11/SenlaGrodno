--ROLE
INSERT INTO role(id, name) VALUES (1, 'ADMIN');
INSERT INTO role(id, name) VALUES (2, 'USER');
--DETAILS
INSERT INTO details(id, name, lastname, city, phone_number)VALUES (1,'Pavel','Kurilo', 'Grodno', '+375297279574');
--USERS
INSERT INTO users(id, username, password, role_id, details_id)VALUES (1,'pavel','123',1,1);
--PRODUCTS
INSERT INTO products(id, title, price, amount) VALUES (1, 'Kvas', 10, 100);
INSERT INTO products(id, title, price, amount) VALUES (2, 'Moloko', 12, 100);
INSERT INTO products(id, title, price, amount) VALUES (3, 'xleb', 13, 100);
INSERT INTO products(id, title, price, amount) VALUES (4, 'Kefir', 14, 100);

--