/*
Server: sql7.freemysqlhosting.net
Name: sql7147049
Username: sql7147049
Password: 9TSw6r1nzu
Port number: 3306
*/


-- -----------------------------------------------------
-- Schema DeviceGuru
-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `sql7147295`;
CREATE SCHEMA IF NOT EXISTS `sql7147295` DEFAULT CHARACTER SET utf8 ;
USE `sql7147295` ;

-- -----------------------------------------------------
-- Table `DeviceGuru`.`Employees`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `sql7147295`.`students`;
CREATE TABLE IF NOT EXISTS `sql7147295`.`students` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(50) NULL DEFAULT NULL,
  `lastname` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
);


