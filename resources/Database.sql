/*
Server: sql7.freemysqlhosting.net
Name: sql7145733
Username: sql7145733
Password: WSeC627snV
Port number: 3306
*/


-- -----------------------------------------------------
-- Schema DeviceGuru
-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `sql7145733`;
CREATE SCHEMA IF NOT EXISTS `sql7145733` DEFAULT CHARACTER SET utf8 ;
USE `sql7145733` ;

-- -----------------------------------------------------
-- Table `DeviceGuru`.`Employees`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `sql7145733`.`Employees`;
CREATE TABLE IF NOT EXISTS `sql7145733`.`Employees` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(50) NULL DEFAULT NULL,
  `lastname` VARCHAR(50) NULL DEFAULT NULL,
  `birth_date` DATE NOT NULL,
  `cell_phone` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`)
)









