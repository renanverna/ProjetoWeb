SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `projeto` ;
CREATE SCHEMA IF NOT EXISTS `projeto` DEFAULT CHARACTER SET utf8 ;
USE `projeto` ;

-- -----------------------------------------------------
-- Table `projeto`.`login`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto`.`login` ;

CREATE  TABLE IF NOT EXISTS `projeto`.`login` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `usuario` VARCHAR(45) NULL DEFAULT NULL ,
  `senha` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `projeto`.`produtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto`.`produtos` ;

CREATE  TABLE IF NOT EXISTS `projeto`.`produtos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(45) NULL DEFAULT NULL ,
  `valor_compra` DECIMAL(5,2) NULL DEFAULT NULL ,
  `valor_venda` DECIMAL(5,2) NULL DEFAULT NULL ,
  `quantidade_estoque` INT(11) NOT NULL DEFAULT '0' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `projeto`.`venda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto`.`venda` ;

CREATE  TABLE IF NOT EXISTS `projeto`.`venda` (
  `id` INT(20) NOT NULL AUTO_INCREMENT ,
  `data` DATETIME NOT NULL ,
  `idlogin` INT(20) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `id` (`id` ASC) ,
  CONSTRAINT `fk_{KTvI4U=xRQ2O8EJ2t3ACv}`
    FOREIGN KEY (`id` )
    REFERENCES `projeto`.`login` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `projeto`.`venda_itens`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projeto`.`venda_itens` ;

CREATE  TABLE IF NOT EXISTS `projeto`.`venda_itens` (
  `idvenda` INT(11) NOT NULL ,
  `idproduto` INT(11) NOT NULL ,
  `quantidade` INT(11) NOT NULL ,
  PRIMARY KEY (`idvenda`, `idproduto`) ,
  INDEX `idvenda` (`idvenda` ASC) ,
  INDEX `idproduto` (`idproduto` ASC) ,
  CONSTRAINT `idproduto`
    FOREIGN KEY (`idproduto` )
    REFERENCES `projeto`.`produtos` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idvenda`
    FOREIGN KEY (`idvenda` )
    REFERENCES `projeto`.`venda` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



INSERT INTO produtos VALUES

(1, 'caneta', '1.23', '3.23','500'),
(2, 'mochila', '19.93', '59.93','500'),
(3, 'lapis', '1.23', '3.23','500'),
(4, 'lapiseira', '1.23', '3.23','500'),
(5, 'apontador', '1.23', '3.23','500'),
(6, 'estojo', '1.23', '3.23','500'),
(7, 'grafite', '1.23', '3.23','500'),
(8, 'caderno universitario', '1.23', '3.23','500'),
(9, 'caderno capa dura', '1.23', '3.23','500'),
(10, 'regua de madeira', '1.23', '3.23','500'),
(11, 'regua de plastico', '1.23', '3.23','500'),
(12, 'Pendriver 8G', '1.23', '3.23','500'),
(13, 'Pendriver 16G', '1.23', '3.23','500'),
(14, 'Pendriver 32G', '19.93', '59.93','500'),
(15, 'Pendriver 64G', '19.93', '59.93','500'),
(16, 'Pendriver 128G', '4.93', '9.93','500'),
(17, 'Pendriver 256', '7.93', '12.93','500'),
(18, 'Pendriver 512G', '9.93', '15.93','500');


INSERT INTO login VALUES

(1, '1', '1'),
(2, 'teste', 'teste'),
(3, 'renan', '123'),
(4, 'admin', '123'),
(5, 'eduardo', '123'),
(6, 'marcelo', '123'),
(7, 'vendedor', '123'),
(8, 'gerente', '123');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


use projeto;

select * from venda;
select * from login;
select * from venda_itens;
select * from produtos;
