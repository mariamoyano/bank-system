DROP SCHEMA IF EXISTS midterm;
CREATE SCHEMA midterm;
USE midterm;

DROP TABLE IF EXISTS student_checking;
DROP TABLE IF EXISTS checking;
DROP TABLE IF EXISTS savings;
DROP TABLE IF EXISTS credit_card;

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

CREATE TABLE account_holder(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
	id BIGINT NOT NULL ,
	name VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id)
);

-- THIRD-PARTY
CREATE TABLE third_party(
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	name VARCHAR(255),
    hashed_key VARCHAR(255),
    user_id BIGINT

-- ADDRESS
CREATE TABLE address(
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    street VARCHAR (255),
    city VARCHAR (255),
    postalCode INT
);

   );
CREATE TABLE account (
id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
-- balance DECIMAL,
balance_amount DECIMAL,
balance_currency VARCHAR (255),
primary_owner_id BIGINT,
secondary_owner_id BIGINT,
-- penalty_fee DECIMAL,
penalty_fee_amount DECIMAL,
penalty_fee_currency VARCHAR (255),
FOREIGN KEY (primary_owner_id) REFERENCES account_holder (id),
FOREIGN KEY (secondary_owner_id) REFERENCES account_holder (id)
);
CREATE TABLE checking (
id BIGINT NOT NULL,
secret_key VARCHAR(255),
-- minimum_balance DECIMAL,
-- monthly_maintenance_fee DECIMAL,
monthly_maintenance_Fee_amount DECIMAL,
monthly_maintenance_Fee_currency VARCHAR (255),
minimum_balance_amount DECIMAL,
minimum_balance_currency VARCHAR (255),
creation_date DATE,
status VARCHAR(6),
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES account (id)
);

CREATE TABLE student_checking (
id BIGINT NOT NULL ,
secret_key VARCHAR (255),
creation_date DATE,
status VARCHAR(6),
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES account (id)
);


CREATE TABLE savings (
id BIGINT NOT NULL,
secret_key VARCHAR (255),
-- minimum_balance DECIMAL,
minimum_balance_amount DECIMAL,
minimum_balance_currency VARCHAR (255),
creation_date DATE,
interest_rate DECIMAL,
status VARCHAR(6),
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES account (id)
);

CREATE TABLE credit_card (
id BIGINT NOT NULL,
-- credit_limit DECIMAL,
credit_limit_amount DECIMAL,
credit_limit_currency VARCHAR (255),
interest_rate DECIMAL,
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES account (id)
);







