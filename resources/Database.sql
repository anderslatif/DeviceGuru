DROP SCHEMA IF EXISTS `deviceguru`;
CREATE SCHEMA IF NOT EXISTS `deviceguru` DEFAULT CHARACTER SET utf8 ;
USE `deviceguru`;
-- -----------------------------------------------------
-- Table `deviceguru`.`devicelogins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `deviceguru`.`devicelogins` ;

CREATE TABLE IF NOT EXISTS `devicelogins` (
  `email` VARCHAR(40) NOT NULL,
  `password` VARCHAR(100) NULL,
  PRIMARY KEY (`email`)
);

-- -----------------------------------------------------
-- Table `deviceguru`.`devices`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `deviceguru`.`devices` ;

CREATE TABLE IF NOT EXISTS `devices` (
  `serialnumber` VARCHAR(30) NOT NULL,
  `type` VARCHAR(20) NULL,
  PRIMARY KEY (`serialnumber`)
);




-- -----------------------------------------------------
-- Table `sql7145733`.`students`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `deviceguru`.`students` ;

CREATE TABLE IF NOT EXISTS `students` (
  `firstname` VARCHAR(100) NOT NULL,
  `lastname`  VARCHAR(100) NOT NULL,
  `serialnumber`    VARCHAR(100) NOT NULL,
  `email`     VARCHAR(200) NOT NULL,
  `class`     VARCHAR(10) NOT NULL,
  `department` INT DEFAULT 0,
  `activestudent` INT DEFAULT 0,
  PRIMARY KEY (`email`),
  FOREIGN KEY (`email`) REFERENCES devicelogins(`email`),
  FOREIGN KEY (`serialnumber`) REFERENCES devices(`serialnumber`)

);

-- -----------------------------------------------------
-- Table `sql7145733`.`personel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `deviceguru`.`personel` ;

CREATE TABLE IF NOT EXISTS `personel` (
  `firstname` VARCHAR(30) NOT NULL,
  `lastname` VARCHAR(80) NOT NULL,
  `device` VARCHAR(30) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`email`),
#     FOREIGN KEY (`device`) REFERENCES devices(`serialnumber`),
    FOREIGN KEY (`email`) REFERENCES devicelogins(`email`)
);

-- -----------------------------------------------------
-- Table `sql7145733`.`repairs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `deviceguru`.`repairs` ;

CREATE TABLE IF NOT EXISTS `repairs` (
  `serialnumber` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `ticketid` INT AUTO_INCREMENT,
  `status` VARCHAR(550) NOT NULL,
  PRIMARY KEY (`ticketid`),
    FOREIGN KEY (`serialnumber`) REFERENCES devices(`serialnumber`),
    FOREIGN KEY (`email`) REFERENCES students(`email`)
#  ,   FOREIGN KEY (`owner`) REFERENCES personel(`email`)
);

-- -----------------------------------------------------
-- Table `sql7145733`.`logins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `deviceguru`.`logins` ;

CREATE TABLE IF NOT EXISTS `logins` (
  `username` VARCHAR(40) NOT NULL,
  `password` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`username`)
);

-- -----------------------------------------------------
-- Table `sql7145733`.`assignments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `deviceguru`.`assignments` ;

CREATE TABLE IF NOT EXISTS `assignments` (
  `assignment` TEXT NOT NULL,
  `owner` VARCHAR(40) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`owner`) REFERENCES logins(`username`)
);

-- -----------------------------------------------------
-- Table `sql7145733`.`devicehistory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `deviceguru`.`devicehistory` ;

CREATE TABLE IF NOT EXISTS `devicehistory` (
  `email`     VARCHAR(100) NOT NULL,
  `serialnumber`    VARCHAR(30) NOT NULL,
  `startdate` DATE        NOT NULL,
  `enddate`   DATE,
  PRIMARY KEY (`email`),
  FOREIGN KEY (`email`) REFERENCES students (`email`),
#   FOREIGN KEY (`email`) REFERENCES personel (`email`),
  FOREIGN KEY (`serialnumber`) REFERENCES devices (`serialnumber`)
);



