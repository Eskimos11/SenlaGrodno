CREATE TABLE users (
    id int NOT NULL AUTO_INCREMENT,
    username varchar(20),
    password varchar(100),
    role int,
    FOREIGN KEY (role) REFERENCES role(id));
    PRIMARY KEY (id)
);


