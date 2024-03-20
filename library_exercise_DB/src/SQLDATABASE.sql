CREATE DATABASE library;
USE library;

CREATE TABLE author(
id int auto_increment primary key,
name varchar(40) not null,
nationality varchar(40) not null
);

CREATE TABLE book(
id int auto_increment primary key,
title varchar(40) not null,
publication_date date not null,
price double not null,
author_id int not null,
foreign key (author_id) references author (id)
);
