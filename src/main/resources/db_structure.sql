CREATE TABLE employee (
    id int NOT AUTO_INCREMENT,
    empname varchar(255),
    currdate DATE,
    PRIMARY KEY (id)
);

CREATE TABLE employeetimetracking (
    id int NOT NULL AUTO_INCREMENT,
    swipein DATETIME,
    swipeout DATETIME,
	locationname varchar(255),
	swipingtype varchar(10),
    empid int NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (empid) REFERENCES employee(id)
);