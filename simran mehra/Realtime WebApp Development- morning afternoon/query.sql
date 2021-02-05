create database banking;
use banking;
create table employee(id int primary key auto_increment, email varchar(20), name varchar(20), password varchar(30));
create table currency(id int primary key auto_increment, email varchar(20), curr_id varchar(15), isCurrFake boolean, amount int, timestamp date);
