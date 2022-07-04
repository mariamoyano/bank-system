DROP SCHEMA IF EXISTS midterm;
CREATE SCHEMA midterm;
USE midterm;

-- DROP TABLE IF EXISTS student_checking;
-- DROP TABLE IF EXISTS checking;
-- DROP TABLE IF EXISTS savings;
-- DROP TABLE IF EXISTS credit_card;

-- -- -- USUARIOS

CREATE TABLE user (
	 id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
     username VARCHAR(255),
     password VARCHAR(255),
	 name VARCHAR(255)
  );
  CREATE TABLE role (
      id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
      name VARCHAR(255),
      user_id BIGINT,
      FOREIGN KEY (user_id) REFERENCES user (id)
  );

 CREATE TABLE account_holder(
 	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     date_of_birth DATE,
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

     user_id BIGINT,
     FOREIGN KEY (user_id) REFERENCES user (id)
 );

-- -- THIRD-PARTY
CREATE TABLE third_party(
 	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
 	name VARCHAR(255),
     hashed_key VARCHAR(255),
     user_id BIGINT

    );
--  ADDRESS
CREATE TABLE address(
	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    street VARCHAR (255),
    city VARCHAR (255),
    postalCode INT
);

--  ACCOUNTS
CREATE TABLE accounts (
id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
balance_amount DECIMAL,
balance_currency VARCHAR (255),
secret_key VARCHAR(255),
primary_owner_id BIGINT,
secondary_owner_id BIGINT,
penalty_fee_amount DECIMAL,
penalty_fee_currency VARCHAR (255),
FOREIGN KEY (primary_owner_id) REFERENCES account_holder (id),
FOREIGN KEY (secondary_owner_id) REFERENCES account_holder (id)
);
CREATE TABLE checking (
id BIGINT  AUTO_INCREMENT NOT NULL PRIMARY KEY,
monthly_maintenance_Fee_amount DECIMAL,
monthly_maintenance_Fee_currency VARCHAR (255),
minimum_balance_amount DECIMAL,
minimum_balance_currency VARCHAR (255),
creation_date DATE,
account_status VARCHAR(6),
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES accounts (id)
);

CREATE TABLE student_checking (
id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
creation_date DATE,
account_status VARCHAR(6),
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES accounts (id)
);


CREATE TABLE savings (
id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
minimum_balance_amount DECIMAL,
minimum_balance_currency VARCHAR (255),
creation_date DATE,
interest_rate DECIMAL,
account_status VARCHAR(6),
last_update_date DATE,
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES accounts (id)
);

CREATE TABLE credit_card (
id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
credit_limit_amount DECIMAL,
credit_limit_currency VARCHAR (255),
interest_rate DECIMAL,
last_update_date DATE,
account_id BIGINT,
FOREIGN KEY (account_id) REFERENCES accounts (id)
);




