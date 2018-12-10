Create DATABASE carOrders;
use carOrders;

CREATE TABLE IF NOT EXISTS Customers (
    CustID int NOT NULL,
    FirstName VARCHAR(255) NOT NULL,
	LastName VARCHAR(255) NOT NULL,
	Email VARCHAR(255),
    PRIMARY KEY (CustID)
);

CREATE TABLE IF NOT EXISTS CAR(
	CarID int NOT NULL,
	Colour VARCHAR(255) NOT NULL,
	Brand VARCHAR(255) NOT NULL,
	Model VARCHAR(255) NOT NULL,
	PRIMARY KEY (CarID)
);

CREATE TABLE IF NOT EXISTS Orders (
    OrderID int NOT NULL AUTO_INCREMENT,
	Date DATE Not Null,
    CustID int Not Null,
	CarID int Not Null,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (CustID) REFERENCES Customers(CustID),
	FOREIGN KEY (CarID) REFERENCES CAR(CarID)
);


INSERT INTO Customers (CustID, FirstName, LastName, Email)
VALUES (1,'Harry','McGinley','HarryMcGinley@gmail.com'),
	   (2,'Martin','McDonagh','MartinMcDonagh@gmail.com'),
	   (3,'Donal','Hynes','DonalHynes@gmail.com');

	   
	
INSERT INTO CAR (CarID, Colour, Brand, Model)
VALUES (1,'Navy','Audi A6','A6'),
	   (2,'Black','BMW I8','I8'),
	   (3,'Red','Honda Civic','Civic');
	   


INSERT INTO Orders (OrderID, Date, CustID, CarID)
VALUES (1234,CURDATE(),1,1),
	   (5678,CURDATE(),2,2),
	   (9101,CURDATE(),3,3);

	   
DELETE FROM Orders WHERE OrderID=1;


