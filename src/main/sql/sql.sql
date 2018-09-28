create database CRM;

CREATE TABLE customer(
id int AUTO_INCREMENT,
name varchar(60),
surname varchar(60),
birthday DATE,
PRIMARY KEY(id));