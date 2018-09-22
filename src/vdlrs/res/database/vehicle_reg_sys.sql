
DROP SCHEMA IF EXISTS vehicle_reg;
CREATE SCHEMA vehicle_reg;
USE vehicle_reg;

CREATE TABLE register 
(
	_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	name_of_applicant VARCHAR(150) NOT NULL,
    state_of_operation VARCHAR(150),
    year_of_manufacturer VARCHAR(10) NOT NULL,
    net_weight DOUBLE,
    horse_power INT(20),
    price DECIMAL(30) NOT NULL,
    applicant_sex VARCHAR(10) DEFAULT "unknown",
    reg_no varchar(30) NOT NULL UNIQUE,
    date_of_purchase DATE NOT NULL,
    model_number VARCHAR(30) NOT NULL,
    number_of_cylinder INT(30),
    applicant_address VARCHAR(30),
    body_type VARCHAR(15),
    date_of_reg DATE NOT NULL,
    chassis_number VARCHAR(30) NOT NULL,
    engine_number VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE transact
(
_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
old_owners_name VARCHAR(150) NOT NULL,
old_owners_address VARCHAR(50) NOT NULL,
registration_no VARCHAR(50) NOT NULL,
new_owners_name VARCHAR(30) NOT NULL,
new_owners_address VARCHAR(50) NOT NULL,
receipt_no VARCHAR(40) NOT NULL,
date_of_reg DATE NOT NULL,
date_of_change DATE NOT NULL
);

CREATE TABLE license
(
_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
reg_number VARCHAR (50) NOT NULL,
exp_date DATE NOT NULL,
applicant_name VARCHAR (50) DEFAULT "UNKNOWN",
date_issued DATE NOT NULL
);

