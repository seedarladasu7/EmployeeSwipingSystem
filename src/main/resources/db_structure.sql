CREATE TABLE EmployeeTimeTracking (
    TrackingID int NOT NULL AUTO INCREMENT,
    SwipeIn DATETIME,
    SwipeOut DATETIME,
	LocationName varchar(255),
	SwipingType varchar(10),
    EmpID int NOT NULL,
	PRIMARY KEY (TrackingID),
    FOREIGN KEY (EmpID) REFERENCES Employee(EmpID)
);



CREATE TABLE Employee (
    EmpID int NOT AUTO INCREMENT,
    EmpName varchar(255),
    CurrDate DATE,
    PRIMARY KEY (EmpID)
);


