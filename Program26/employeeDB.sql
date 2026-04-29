CREATE DATABASE employeeDB;

USE employeeDB;

CREATE TABLE employee (
    name VARCHAR(50),
    code INT PRIMARY KEY,
    designation VARCHAR(50),
    salary DOUBLE
);