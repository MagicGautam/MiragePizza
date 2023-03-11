USE MiragePizza;
CREATE TABLE Orders (
  OrderID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(50) NOT NULL,
    CustomerPhone VARCHAR(20) NOT NULL,
    CustomerEmail VARCHAR(50) NOT NULL,
    CustomerAddress VARCHAR(100) NOT NULL,
    PizzaID INT NOT NULL,
    OrderTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    TotalPrice int NOT NULL,
    FOREIGN KEY (PizzaID) REFERENCES Pizza(id)
);
ALTER TABLE orders ADD PizzaName VARCHAR(50);
ALTER TABLE orders MODIFY COLUMN pizzaname VARCHAR(50) AFTER pizzaid;
Select * From Orders;