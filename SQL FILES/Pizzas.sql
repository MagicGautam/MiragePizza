CREATE DATABASE MiragePizza;
USE MiragePizza;
Create table pizza (id int NOT NULL AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
description text,
price int not null,
PRIMARY KEY (id)
);

INSERT INTO pizza (name, description, price)
VALUES ('The Freedom Special', 'Straight out from Uncle Sam''s Kitchen, This pizza serves Freedom, one muslim country at a time', 3100);
INSERT INTO pizza (name, description, price)
VALUES ('Kalashnikov', 'Mirage Speical Kalashnikov Pizza served with the toppings of 7.62mm SOVIET', 2700);
INSERT INTO pizza (name, description, price)
VALUES ('AUGBURST', 'The Austrains are know for a lot of things and AUG Pizza is certainly one of them', 3300);
INSERT INTO pizza (name, description, price)
VALUES ('AWPPERONOI', 'The Arctic Warfare Pizza', 4750);
INSERT INTO pizza (name, description, price)
VALUES ('DEagle Cheese Burst', 'Israeli styled pizza, Hated by most, loved by many', 700);
INSERT INTO pizza (name, description, price)
VALUES ('P90 grilled', 'Hated by Pro pizza lovers, loved by Every Newbie', 2250);
INSERT INTO pizza (name, description, price)
VALUES ('SneakyBeaky Delight', 'Pizza coming from the germans, known for its silent but strong flavours', 300);
INSERT INTO pizza (name, description, price)
VALUES ('GlockaMania', 'Cheap, Reliable, Tasty', 200);
INSERT INTO pizza (name, description, price)
VALUES ('ZEUSPIZZA', 'Shockingly Good', 300);
INSERT INTO pizza (name, description, price)
VALUES ('Five seveN', '7 Inch pizza with 5 inches of Toppings', 500);
