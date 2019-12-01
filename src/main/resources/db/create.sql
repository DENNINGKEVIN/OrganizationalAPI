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
 author VARCHAR,
 content VARCHAR,
 userid INTEGER,
 type VARCHAR
 createdate BIGINT
);