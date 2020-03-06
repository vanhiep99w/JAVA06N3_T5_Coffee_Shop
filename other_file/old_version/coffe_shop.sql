-- MySQL Workbench Forward Engineering



SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema coffee_shop_final
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `coffee_shop_final` ;

-- -----------------------------------------------------
-- Schema coffee_shop_final
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `coffee_shop_final` DEFAULT CHARACTER SET utf8 ;
USE `coffee_shop_final` ;

-- -----------------------------------------------------
-- Table `coffee_shop_final`.`order_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`order_status` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`order_status` (
  `id_order_status` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_order_status`))
ENGINE = InnoDB;

LOCK TABLE coffee_shop_final.order_status WRITE;
INSERT INTO coffee_shop_final.order_status values(1,'ĐANG LÀM'),(2,'ĐÃ GIAO'),(3,'ĐÃ HỦY');
UNLOCK TABLES;



-- -----------------------------------------------------
-- Table `coffee_shop_final`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`category` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`category` (
  `id_category` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB;

LOCK TABLE coffee_shop_final.category WRITE;
INSERT INTO coffee_shop_final.category values(1,'ĐỒ UỐNG CÓ GA'),(2,'TRÀ SỮA'),
										(3,'BÁNH NGỌT'),(4,'NƯỚC ÉP'),(5,'SINH TỐ'),
                                        (6,'COFFEE');
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `coffee_shop_final`.`product_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`product_status` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`product_status` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_product`))
ENGINE = InnoDB;

LOCK TABLE coffee_shop_final.product_status write;
INSERT INTO coffee_shop_final.product_status VALUES(1,TRUE),(2,FALSE);
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `coffee_shop_final`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`product` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` FLOAT NOT NULL,
  `id_category` INT NOT NULL,
  PRIMARY KEY (`id_product`),
  INDEX `fk_product_category_idx` (`id_category` ASC) VISIBLE,
  CONSTRAINT `fk_product_category`
    FOREIGN KEY (`id_category`)
    REFERENCES `coffee_shop_final`.`category` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_product_status`
    FOREIGN KEY (`id_product`)
    REFERENCES `coffee_shop_final`.`product_status` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

LOCK TABLE coffee_shop_final.product WRITE;
INSERT INTO coffee_shop_final.product VALUES(1,'PEPSI',10000,1),(2,'COCACOLA',10000,1),(3,'7UP',9000,1),
										(4,'TRÀ SỮA TRÂN CHÂU',15000,2),(5,'TRÀ SỮA ĐAU TÂY',15000,2),
                                        (6,'TRÀ SỮA SOCALA',15000,2),(7,'TRÀ SỮA BẠC HÀ',20000,2),
                                        (8,'TRÀ SỮA MATCHA',25000,2),(9,'PANTA',8000,1),(10,'SPRINK',12000,1),
                                        (11,'TRÀ SỮA BLUEBERRY',25000,2),(12,'BÁNH  PAVALO',20000,3),
                                        (13,'BÁNH MOCHI',15000,3),(14,'BÁNH BLACK FOREST',17000,3),(15,'BÁNH MACARON',16000,3),
                                        (16,'NƯỚC ÉP CAM',11000,4),(17,'NƯỚC ÉP ỔI',11000,4),(18,'NƯỚC ÉP TÁO',11000,4),(19,'NƯỚC ÉP DƯA HẤU',12000,4),
                                        (20,'NƯỚC ÉP THƠM + CÀ RỐT',15000,4),(21,'NƯỚC ÉP DÂU + CAM',15000,4),
                                        (22,'SINH TỐ XOÀI',14000,5),(23,'SINH TỐ BƠ',14000,5),(24,'SINH TỐ CÀ CHUA',14000,5),(25,'SINH TỐ CHUỐI',14000,5),
                                        (26,'COFFEE ĐEN',20000,6),(27,'COFFEE BẠC SỈU',20000,6),(28,'CAFFE SỮA',20000,6);
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `coffee_shop_final`.`table_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`table_status` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`table_status` (
  `id_table_status` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_table_status`))
ENGINE = InnoDB;

LOCK TABLE coffee_shop_final.table_status WRITE;
INSERT INTO coffee_shop_final.table_status VALUES(1,'EMPTY'),(2,'FULL'),(3,'ORDERED');
UNLOCK TABLES;

-- -----------------------------------------------------
-- Table `coffee_shop_final`.`table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`table` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`table` (
  `id_table` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `id_status_table` INT NOT NULL,
  PRIMARY KEY (`id_table`),
  INDEX `fk_table_table_status_idx` (`id_status_table` ASC) VISIBLE,
  CONSTRAINT `fk_table_table_status`
    FOREIGN KEY (`id_status_table`)
    REFERENCES `coffee_shop_final`.`table_status` (`id_table_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

LOCK TABLE coffee_shop_final.table WRITE;
INSERT INTO coffee_shop_final.table VALUES(1,'A01',1),(2,'A02',1),(3,'A03',1),(4,'A04',1),
									(5,'A05',1),(6,'A06',1),(7,'A07',1),(8,'A08',1),
                                    (9,'B01',1),(10,'B02',1),(11,'B03',1),(12,'B04',1),
									(13,'B05',1),(14,'B06',1),(15,'B07',1),(16,'B08',1);
UNLOCK TABLES;
                                    


-- -----------------------------------------------------
-- Table `coffee_shop_final`.`order_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`order_detail` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`order_detail` (
  `id_order` INT NOT NULL,
  `id_product` INT NOT NULL,
  `amount` INT NOT NULL,
  `order_time` DATETIME NOT NULL DEFAULT current_timestamp(),
  `id_order_status` INT NOT NULL,
  PRIMARY KEY (`id_order`),
  INDEX `fk_order_detail_order_status1_idx` (`id_order_status` ASC) VISIBLE,
  CONSTRAINT `fk_order_detail_order_status`
    FOREIGN KEY (`id_order_status`)
    REFERENCES `coffee_shop_final`.`order_status` (`id_order_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `coffee_shop_final`.`work`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`work` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`work` (
  `id_work` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `salary_in_hour` FLOAT NOT NULL,
  PRIMARY KEY (`id_work`))
ENGINE = InnoDB;

LOCK TABLE coffee_shop_final.work WRITE;
INSERT INTO coffee_shop_final.work VALUES(1,'NHẦN VIÊN LỄ TÂN',13000),(2,'NHẦN VIÊN ORDER',13000),
									(3,'NHẦN VIÊN VỆ SINH',10000),(4,'NHẦN VIÊN BẢO VỆ',10000),
                                    (5,'NHẦN VIÊN PHA CHẾ',14000);
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `coffee_shop_final`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`employee` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`employee` (
  `id_employee` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `id_work` INT NOT NULL,
  
  PRIMARY KEY (`id_employee`),
  INDEX `fk_employee_work_idx` (`id_work` ASC) VISIBLE,
  CONSTRAINT `fk_employee_work`
    FOREIGN KEY (`id_work`)
    REFERENCES `coffee_shop_final`.`work` (`id_work`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

LOCK TABLES coffee_shop_final.employee WRITE;
INSERT INTO coffee_shop_final.employee VALUES(1,'TRẦN VĂN A','2139343242',1),(2,'TRẦN VĂN B','213234242',1),
										(3,'TRẦN QUỐC C','2438942342',2),(4,'TRẦN TAM D','4234879234',2),
                                        (5,'NGUYỄN TOÀN E','89724243',3),(6,'NGUYỄN VĂN T','72863434',3),
                                        (7,'VŨ OANH T','523423432',4),(8,'QUỐC THANH N','729343234',4),
                                        (9,'ĐINH TÀI M','28937403',5),(10,'TOẢN TRUNG S','419323123',5);
UNLOCK TABLES;


-- -----------------------------------------------------
-- Table `coffee_shop_final`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`order` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`order` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `id_employee` INT NOT NULL,
  `id_table` INT NOT NULL,
  `time` DATETIME NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_order`),
  INDEX `fk_order_table1_idx` (`id_table` ASC) VISIBLE,
  INDEX `fk_order_employee1_idx` (`id_employee` ASC) VISIBLE,
  CONSTRAINT `fk_order_order_detail`
    FOREIGN KEY (`id_order`)
    REFERENCES `coffee_shop_final`.`order_detail` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_table`
    FOREIGN KEY (`id_table`)
    REFERENCES `coffee_shop_final`.`table` (`id_table`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_employee`
    FOREIGN KEY (`id_employee`)
    REFERENCES `coffee_shop_final`.`employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `coffee_shop_final`.`product_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`product_order` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`product_order` (
  `id_product` INT NOT NULL,
  `id_order` INT NOT NULL,
  PRIMARY KEY (`id_product`, `id_order`),
  INDEX `fk_product_has_order_detail_order_detail1_idx` (`id_order` ASC) VISIBLE,
  INDEX `fk_product_has_order_detail_product1_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `fk_product_has_order_detail_product`
    FOREIGN KEY (`id_product`)
    REFERENCES `coffee_shop_final`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_has_order_detail_order_detail`
    FOREIGN KEY (`id_order`)
    REFERENCES `coffee_shop_final`.`order_detail` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `coffee_shop_final`.`bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`bill` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`bill` (
  `id_bill` INT NOT NULL AUTO_INCREMENT,
  `id_order` INT NOT NULL,
  `time` DATETIME NOT NULL DEFAULT current_timestamp(),
  `vat` FLOAT NOT NULL,
  `sum` FLOAT NOT NULL,
  PRIMARY KEY (`id_bill`),
  INDEX `fk_bill_order1_idx` (`id_order` ASC) VISIBLE,
  CONSTRAINT `fk_bill_order`
    FOREIGN KEY (`id_order`)
    REFERENCES `coffee_shop_final`.`order` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `coffee_shop_final`.`shift`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`shift` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`shift` (
  `id_shift` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `start_time` TIME NOT NULL,
  `end_time` TIME NOT NULL,
  PRIMARY KEY (`id_shift`))
ENGINE = InnoDB;

LOCK TABLE coffee_shop_final.shift WRITE;
INSERT INTO coffee_shop_final.shift VALUES(1,'CA_1','07:00:00','11:30:00'),(2,'CA_2','11:30:00','15:30:00'),
									(3,'CA_3','15:30:00','19:30:00'),(4,'CA_4','19:30:00','23:00:00');
UNLOCK TABLES;



-- -----------------------------------------------------
-- Table `coffee_shop_final`.`shift_employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee_shop_final`.`shift_employee` ;

CREATE TABLE IF NOT EXISTS `coffee_shop_final`.`shift_employee` (
  `d_shift` INT NOT NULL,
  `id_employee` INT NOT NULL,
  PRIMARY KEY (`d_shift`, `id_employee`),
  INDEX `fk_shift_has_employee_employee_idx` (`id_employee` ASC) VISIBLE,
  INDEX `fk_shift_has_employee_shift_idx` (`d_shift` ASC) VISIBLE,
  CONSTRAINT `fk_shift_has_employee_shift`
    FOREIGN KEY (`d_shift`)
    REFERENCES `coffee_shop_final`.`shift` (`id_shift`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shift_has_employee_employee`
    FOREIGN KEY (`id_employee`)
    REFERENCES `coffee_shop_final`.`employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

LOCK TABLE coffee_shop_final.shift_employee WRITE;
INSERT INTO coffee_shop_final.shift_employee VALUES(1,1),(1,3),(1,5),(1,7),(1,9),
											(2,1),(2,3),(2,5),(2,7),(2,9),
                                            (3,2),(3,4),(3,6),(3,8),(3,10),
                                            (4,2),(4,4),(4,6),(4,8),(4,10);
UNLOCK TABLES;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
