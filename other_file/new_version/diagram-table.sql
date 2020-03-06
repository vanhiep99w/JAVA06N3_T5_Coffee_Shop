-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema coffee_shop
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `coffee_shop` ;

-- -----------------------------------------------------
-- Schema coffee_shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `coffee_shop` DEFAULT CHARACTER SET utf8 ;
USE `coffee_shop` ;

-- -----------------------------------------------------
-- Table `coffee_shop`.`work`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`work` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`work` (
  `id_work` INT(11) NOT NULL AUTO_INCREMENT,
  `name_work` VARCHAR(45) NOT NULL,
  `salary_an_hour` FLOAT NOT NULL,
  PRIMARY KEY (`id_work`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`employee` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`employee` (
  `id_employee` INT(11) NOT NULL AUTO_INCREMENT,
  `name_employee` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `id_work` INT(11) NOT NULL,
  PRIMARY KEY (`id_employee`),
  INDEX `fk_employee_work1_idx` (`id_work` ASC) VISIBLE,
  CONSTRAINT `fk_employee_work`
    FOREIGN KEY (`id_work`)
    REFERENCES `coffee_shop`.`work` (`id_work`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`table_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`table_status` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`table_status` (
  `id_table_status` INT(11) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_table_status`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`table` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`table` (
  `id_table` INT(11) NOT NULL AUTO_INCREMENT,
  `name_table` VARCHAR(45) NOT NULL,
  `id_table_status` INT(11) NOT NULL,
  PRIMARY KEY (`id_table`),
  INDEX `fk_table_table_status1_idx` (`id_table_status` ASC) VISIBLE,
  CONSTRAINT `fk_table_table_status`
    FOREIGN KEY (`id_table_status`)
    REFERENCES `coffee_shop`.`table_status` (`id_table_status`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`order` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`order` (
  `id_order` INT(11) NOT NULL AUTO_INCREMENT,
  `id_employee` INT(11) NOT NULL,
  `id_table` INT(11) NOT NULL,
  `time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_order`),
  INDEX `fk_order_table1_idx` (`id_table` ASC) VISIBLE,
  INDEX `fk_order_employee1_idx` (`id_employee` ASC) VISIBLE,
  CONSTRAINT `fk_order_employee`
    FOREIGN KEY (`id_employee`)
    REFERENCES `coffee_shop`.`employee` (`id_employee`),
  CONSTRAINT `fk_order_table`
    FOREIGN KEY (`id_table`)
    REFERENCES `coffee_shop`.`table` (`id_table`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`bill` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`bill` (
  `id_bill` INT(11) NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `vat` FLOAT NOT NULL,
  `sum` FLOAT NOT NULL,
  `id_order` INT(11) NOT NULL,
  PRIMARY KEY (`id_bill`),
  INDEX `fk_bill_order1_idx` (`id_order` ASC) VISIBLE,
  CONSTRAINT `fk_bill_order1`
    FOREIGN KEY (`id_order`)
    REFERENCES `coffee_shop`.`order` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`category` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`category` (
  `id_category` INT(11) NOT NULL AUTO_INCREMENT,
  `name_category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`product` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`product` (
  `id_product` INT(11) NOT NULL AUTO_INCREMENT,
  `name_product` VARCHAR(45) NOT NULL,
  `price` FLOAT NOT NULL,
  `id_category` INT(11) NOT NULL,
  `image` VARCHAR(45) NULL,
  PRIMARY KEY (`id_product`),
  INDEX `fk_product_category1_idx` (`id_category` ASC) VISIBLE,
  CONSTRAINT `fk_product_category`
    FOREIGN KEY (`id_category`)
    REFERENCES `coffee_shop`.`category` (`id_category`))
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`product_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`product_order` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`product_order` (
  `id_order` INT(11) NOT NULL,
  `amount` INT(11) NOT NULL,
  `order_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_product` INT(11) NOT NULL,
  PRIMARY KEY (`id_order`, `id_product`),
  INDEX `fk_product_detail_product1_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `fk_product_detail_product1`
    FOREIGN KEY (`id_product`)
    REFERENCES `coffee_shop`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_detail_order1`
    FOREIGN KEY (`id_order`)
    REFERENCES `coffee_shop`.`order` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`order_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`order_status` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`order_status` (
  `id_order_status` INT(11) NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_order_status`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`product_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`product_status` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`product_status` (
  `id_prodcut_status` INT(11) NOT NULL AUTO_INCREMENT,
  `id_product` INT(11) NOT NULL,
  `time_sell_out` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_prodcut_status`, `id_product`),
  INDEX `fk_product_status_product1_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `fk_product_status_product1`
    FOREIGN KEY (`id_product`)
    REFERENCES `coffee_shop`.`product` (`id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`shift`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`shift` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`shift` (
  `id_shift` INT(11) NOT NULL AUTO_INCREMENT,
  `name_shift` VARCHAR(45) NOT NULL,
  `start_time` TIME NOT NULL,
  `end_time` TIME NOT NULL,
  PRIMARY KEY (`id_shift`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`shift_employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`shift_employee` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`shift_employee` (
  `id_shift` INT(11) NOT NULL,
  `id_employee` INT(11) NOT NULL,
  PRIMARY KEY (`id_shift`, `id_employee`),
  INDEX `fk_shift_has_employee_employee1_idx` (`id_employee` ASC) VISIBLE,
  INDEX `fk_shift_has_employee_shift1_idx` (`id_shift` ASC) VISIBLE,
  CONSTRAINT `fk_shift_has_employee_employee`
    FOREIGN KEY (`id_employee`)
    REFERENCES `coffee_shop`.`employee` (`id_employee`),
  CONSTRAINT `fk_shift_has_employee_shift`
    FOREIGN KEY (`id_shift`)
    REFERENCES `coffee_shop`.`shift` (`id_shift`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `coffee_shop`.`product_order_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop`.`product_order_detail` ;

CREATE TABLE IF NOT EXISTS `coffee_shop`.`product_order_detail` (
  `id_order_status` INT(11) NOT NULL,
  `id_order` INT(11) NOT NULL,
  `id_product` INT(11) NOT NULL,
  `time` TIME NULL,
  PRIMARY KEY (`id_order_status`, `id_order`, `id_product`),
  INDEX `fk_order_status_has_product_order_product_order1_idx` (`id_order` ASC, `id_product` ASC) VISIBLE,
  INDEX `fk_order_status_has_product_order_order_status1_idx` (`id_order_status` ASC) VISIBLE,
  CONSTRAINT `fk_order_status_has_product_order_order_status1`
    FOREIGN KEY (`id_order_status`)
    REFERENCES `coffee_shop`.`order_status` (`id_order_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_status_has_product_order_product_order1`
    FOREIGN KEY (`id_order` , `id_product`)
    REFERENCES `coffee_shop`.`product_order` (`id_order` , `id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
