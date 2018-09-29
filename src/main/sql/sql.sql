create database CRM;

CREATE TABLE customer(
id int AUTO_INCREMENT,
name varchar(60),
surname varchar(60),
birthday DATE,
PRIMARY KEY(id));

CREATE TABLE employee(
id int AUTO_INCREMENT,
name varchar(60),
surname varchar(60),
address varchar (255),
phone varchar (10),
note varchar (255),
costPerHour double,
PRIMARY KEY(id));

CREATE TABLE vehicle(
id int AUTO_INCREMENT,
customer_id int,
model varchar(60),
brand varchar(60),
productionYear varchar(4),
licensePlate varchar(10),
nextTechnicalInspection date,
PRIMARY KEY(id),
FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE orders(
id int AUTO_INCREMENT,
employee_id int,
vehicle_id int not null,
dateOfAcceptance date,
dateOfPlanedStart date,
dateOfStart date,
problemDescription varchar(255),
repairDescription varchar(255),
stat varchar(12),
costForClient double,
partsCost double,
workCost double,
numberOfHours int,
PRIMARY KEY(id),
FOREIGN KEY (employee_id) REFERENCES employee(id),
FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);