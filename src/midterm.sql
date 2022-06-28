DROP SCHEMA IF EXISTS crm;
CREATE SCHEMA crm;

USE crm;

DROP TABLE IF EXISTS student_checking;
DROP TABLE IF EXISTS checking;
DROP TABLE IF EXISTS savings;
DROP TABLE IF EXISTS credit_card;

CREATE TABLE checking (
id int NOT NULL AUTO_INCREMENT,
balance BIGINT,
secretKey VARCHAR (255),
primary_owner VARCHAR (255),
secundary_owner VARCHAR (255),
minimum_balance BIGINT,
penalty_fee BIGINT,
monthly_maintenance_fee BIGINT,
creation_date DATE,
status VARCHAR(6),
PRIMARY KEY (id)
);

CREATE TABLE student_checking (
id int NOT NULL AUTO_INCREMENT,
balance BIGINT,
secretKey VARCHAR (255),
primary_owner VARCHAR (255),
secundary_owner VARCHAR (255),
penalty_fee BIGINT,
creation_date DATE,
status VARCHAR(6),
PRIMARY KEY (id)
);


CREATE TABLE savings (
id int NOT NULL AUTO_INCREMENT,
balance BIGINT,
secretKey VARCHAR (255),
primary_owner VARCHAR (255),
secundary_owner VARCHAR (255),
minimum_balance BIGINT,
penalty_fee BIGINT,
creation_date DATE,
interest_rate BIGINT,
status VARCHAR(6),
PRIMARY KEY (id)
);

CREATE TABLE credit_card (
id int NOT NULL AUTO_INCREMENT,
balance BIGINT,
primary_owner VARCHAR (255),
secundary_owner VARCHAR (255),
credit_limit BIGINT,
penalty_fee BIGINT,
PRIMARY KEY (id)
);

