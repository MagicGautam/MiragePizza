use MiragePizza;
CREATE TABLE Customers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  CustomerName VARCHAR(255) NOT NULL,
  CustomerPhone VARCHAR(20) NOT NULL,
  CustomerEmail VARCHAR(255) NOT NULL,
  CustomerAddress VARCHAR(255) NOT NULL
);
SELECT Orders.OrderID, Customers.CustomerName, Customers.CustomerPhone, Customers.CustomerEmail, Customers.CustomerAddress
FROM Orders
INNER JOIN Customers ON Orders.CustomerName = Customers.CustomerName;

SELECT * FROM CUSTOMERS