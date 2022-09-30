-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pharmacydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pharmacydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pharmacydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `pharmacydb` ;

-- -----------------------------------------------------
-- Table `pharmacydb`.`PRODUCTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacydb`.`PRODUCTS` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Product ID',
  `name` VARCHAR(45) NOT NULL COMMENT 'The name of product',
  `description` TEXT NOT NULL COMMENT 'Description of product',
  `quantity` INT NOT NULL COMMENT 'Quantity of products stored',
  PRIMARY KEY (`id`),
  INDEX `name` (`name` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE USER 'user1' IDENTIFIED BY 'user1';

GRANT ALL ON `pharmacydb`.* TO 'user1';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO PRODUCTS (NAME, DESCRIPTION, QUANTITY) VALUES ("depon", "pain relief", 9);
INSERT INTO PRODUCTS (NAME, DESCRIPTION, QUANTITY) VALUES ("algofren", "pain relief", 5);