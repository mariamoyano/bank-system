DROP SCHEMA IF EXISTS midterm;
CREATE SCHEMA midterm;
USE midterm;

--DROP TABLE IF EXISTS student_checking;
--DROP TABLE IF EXISTS checking;
--DROP TABLE IF EXISTS savings;
--DROP TABLE IF EXISTS credit_card;


CREATE TABLE account (
id BIGINT NOT NULL AUTO_INCREMENT,
balance DECIMAL,
primary_owner VARCHAR (255),
secondary_owner VARCHAR (255),
penalty_fee DECIMAL,
PRIMARY KEY (id)
);
CREATE TABLE checking (
id BIGINT NOT NULL,
balance DECIMAL,
secret_key VARCHAR (255),
primary_owner VARCHAR (255),
secondary_owner VARCHAR (255),
minimum_balance DECIMAL,
penalty_fee DECIMAL,
monthly_maintenance_fee DECIMAL,
creation_date DATE,

monthly_maintenance_Fee_amount DECIMAL,
monthly_maintenance_Fee_currency VARCHAR (255),
minimum_balance_amount DECIMAL,
minimum_balance_currency VARCHAR (255),
status VARCHAR(6),
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES account (id)
);

CREATE TABLE student_checking (
id BIGINT NOT NULL ,
balance DECIMAL,
secret_key VARCHAR (255),
primary_owner VARCHAR (255),
secondary_owner VARCHAR (255),
penalty_fee DECIMAL,
creation_date DATE,
status VARCHAR(6),
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES account (id)
);


CREATE TABLE savings (
id BIGINT NOT NULL,
balance DECIMAL,
secret_key VARCHAR (255),
primary_owner VARCHAR (255),
secondary_owner VARCHAR (255),
minimum_balance DECIMAL,
minimum_balance_amount DECIMAL,
minimum_balance_currency VARCHAR (255),
penalty_fee DECIMAL,
creation_date DATE,
interest_rate DECIMAL,
status VARCHAR(6),
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES account (id)
);

CREATE TABLE credit_card (
id BIGINT NOT NULL,
balance DECIMAL,
primary_owner VARCHAR (255),
secondary_owner VARCHAR (255),
credit_limit DECIMAL,
interest_rate DECIMAL,
penalty_fee DECIMAL,
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES account (id)
);


-- USUARIOS

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);
CREATE TABLE role (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE account_holders(
	id BIGINT NOT NULL,
	name VARCHAR(255),
    date_of_birth DATE,
--  --    primary_address VARCHAR(255),
-- --     mailing_address VARCHAR(255),
    primary_city VARCHAR(255),
    primary_street VARCHAR (255),
    primary_postal_code INT,
    mailing_city VARCHAR(255),
    mailing_street VARCHAR (255),
	mailing_postal_code INT,
	user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id)

);
CREATE TABLE admin(
	id BIGINT NOT NULL,
	name VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id)
);
CREATE TABLE third_party(
	id BIGINT NOT NULL,
	name VARCHAR(255),
    hashed_key VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id)
   );





