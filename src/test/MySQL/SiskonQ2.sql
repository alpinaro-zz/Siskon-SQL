-- Create database

CREATE DATABASE siskon;
USE siskon;

-- ############### Question 2 ###############

-- Create customer table

CREATE TABLE customer
(
CustomerID INT AUTO_INCREMENT PRIMARY KEY,
CustomerName VARCHAR(100)
);

-- Add customer data

INSERT INTO customer (CustomerName) VALUES('Customer A');
INSERT INTO customer (CustomerName) VALUES('Customer B');
INSERT INTO customer (CustomerName) VALUES('Customer C');

-- Read customer data

SELECT * FROM customer;

-- Create customer_operation table

CREATE TABLE customer_operation
(
OrderID INT AUTO_INCREMENT PRIMARY KEY,
CustomerID INT,
TotalAmount INT,
EventDate DATETIME
);

-- Add customer_operation data

INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(1, 1000, '2010-01-24');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(1, 2300, '2010-03-26');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(1, 300, '2010-05-18');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(1, 12000, '2011-03-28');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(1, 4000, '2011-07-05');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(1, 7500, '2012-01-03');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(2, 4000, '2010-01-24');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(2, 5000, '2010-03-26');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(2, 1000, '2010-05-18');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(2, 2400, '2011-03-28');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(2, 500, '2011-07-05');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(2, 3000, '2012-01-03');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(3, 3200, '2010-01-24');
INSERT INTO customer_operation (CustomerID, TotalAmount, EventDate) VALUES(3, 300, '2012-05-03');

-- Read customer_operation data

SELECT * FROM customer_operation;

-- Task: Find the avarage TotalAmount for last 3 values for each customer. 
-- Todo: If a customer does not have 3 operation, then result should be null.

WITH customer_operation AS (SELECT CustomerID, TotalAmount, ROW_NUMBER() OVER (PARTITION BY CustomerID ORDER BY EventDate DESC) rn FROM customer_operation) 
SELECT CustomerID, AVG (TotalAmount) FROM customer_operation WHERE rn <= 3 GROUP BY CustomerID;