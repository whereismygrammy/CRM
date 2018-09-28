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