/*
Server: sql7.freemysqlhosting.net
Name: sql7145733
Username: sql7145733
Password: WSeC627snV
Port number: 3306
*/

DROP SCHEMA IF EXISTS `sql7145733`;
CREATE SCHEMA IF NOT EXISTS `sql7145733` DEFAULT CHARACTER SET utf8 ;
USE `sql7145733` ;
-- -----------------------------------------------------
-- Table `sql7145733`.`devicelogins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sql7145733`.`devicelogins` ;

CREATE TABLE IF NOT EXISTS `sql7145733`.`devicelogins` (
  `email` VARCHAR(30) NOT NULL,
  `password` VARCHAR(20) NULL,
  PRIMARY KEY (`email`)
);

-- -----------------------------------------------------
-- Table `sql7145733`.`devices`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sql7145733`.`devices` ;

CREATE TABLE IF NOT EXISTS `sql7145733`.`devices` (
  `serialnumber` VARCHAR(30) NOT NULL,
  `type` VARCHAR(20) NULL,
  PRIMARY KEY (`serialnumber`)
);


-- -----------------------------------------------------
-- Table `sql7145733`.`classes`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `sql7145733`.`classes` ;

CREATE TABLE IF NOT EXISTS `sql7145733`.`classes` (
  `class` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`class`)
);



-- -----------------------------------------------------
-- Table `sql7145733`.`students`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sql7145733`.`students` ;

CREATE TABLE IF NOT EXISTS `sql7145733`.`students` (
  `firstname` VARCHAR(30) NOT NULL,
  `lastname`  VARCHAR(45) NOT NULL,
  `class`     VARCHAR(5)  NOT NULL,
  `device`    VARCHAR(30) NOT NULL,
  `email`     VARCHAR(30) NOT NULL,
  INDEX `deasd_idx` (`device` ASC),
  INDEX `class_idx` (`class` ASC),
  PRIMARY KEY (`email`),
  FOREIGN KEY (`email`) REFERENCES devicelogins(`email`),
  FOREIGN KEY (`device`) REFERENCES devices(`serialnumber`),
  FOREIGN KEY (`class`) REFERENCES classes(`class`)

);

-- -----------------------------------------------------
-- Table `sql7145733`.`personel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sql7145733`.`personel` ;

CREATE TABLE IF NOT EXISTS `sql7145733`.`personel` (
  `firstname` VARCHAR(30) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `device` VARCHAR(30) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  INDEX `device_idx` (`device` ASC),
  INDEX `email_idx` (`email` ASC),
  PRIMARY KEY (`email`),
    FOREIGN KEY (`device`) REFERENCES devices(`serialnumber`),
    FOREIGN KEY (`email`) REFERENCES devicelogins(`email`)
);

-- -----------------------------------------------------
-- Table `sql7145733`.`repairs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sql7145733`.`repairs` ;

CREATE TABLE IF NOT EXISTS `sql7145733`.`repairs` (
  `device` VARCHAR(30) NOT NULL,
  `owner` VARCHAR(30) NOT NULL,
  `ticketid` INT,
  `status` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`ticketid`),
    FOREIGN KEY (`device`) REFERENCES devices(`serialnumber`),
    FOREIGN KEY (`owner`) REFERENCES students(`email`),
    FOREIGN KEY (`owner`) REFERENCES personel(`email`)
);

-- -----------------------------------------------------
-- Table `sql7145733`.`logins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sql7145733`.`logins` ;

CREATE TABLE IF NOT EXISTS `sql7145733`.`logins` (
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`username`)
);

-- -----------------------------------------------------
-- Table `sql7145733`.`assignments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sql7145733`.`assignments` ;

CREATE TABLE IF NOT EXISTS `sql7145733`.`assignments` (
  `assignment` VARCHAR(100) NOT NULL,
  `owner` VARCHAR(20) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`owner`) REFERENCES logins(`username`)

);

-- -----------------------------------------------------
-- Table `sql7145733`.`devicehistory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sql7145733`.`devicehistory` ;

CREATE TABLE IF NOT EXISTS `sql7145733`.`devicehistory` (
  `email`     VARCHAR(30) NOT NULL,
  `device`    VARCHAR(30) NOT NULL,
  `startdate` DATE        NOT NULL,
  `enddate`   DATE,
  PRIMARY KEY (`email`),
  FOREIGN KEY (`email`) REFERENCES students (`email`),
  FOREIGN KEY (`email`) REFERENCES personel (`email`),
  FOREIGN KEY (`device`) REFERENCES devices (`serialnumber`)
);



