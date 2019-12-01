--CREATE DATABASE organizational_api;
--
--\c organizational_api
--
--CREATE TABLE users (id SERIAL PRIMARY KEY,name varchar,companyposition varchar,role varchar,departmentid INTEGER);
--
--CREATE TABLE departments(id SERIAL PRIMARY KEY,name varchar,description varchar);
--
--CREATE TABLE news(id SERIAL PRIMARY KEY,content varchar,userid INTERGER,type varchar);
--
--CREATE DATABASE organizational_api_test WITH TEMPLATE organizational_api;

SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS users (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 companyposition VARCHAR,
 role VARCHAR,
 departmentid VARCHAR
);

CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
);

CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 content VARCHAR,
 userid INTEGER,
 type VARCHAR
);