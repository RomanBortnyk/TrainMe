SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `TrainMe` DEFAULT CHARACTER SET utf8 ;
USE `TrainMe` ;

-- -----------------------------------------------------
-- Table `TrainMe`.`avatar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrainMe`.`avatar` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `image` MEDIUMBLOB NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `TrainMe`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrainMe`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday_date` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `user_type` VARCHAR(45) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `avatar_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_coach_avatar1_idx` (`avatar_id` ASC),
  CONSTRAINT `fk_user_avatar`
    FOREIGN KEY (`avatar_id`)
    REFERENCES `TrainMe`.`avatar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `TrainMe`.`chat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrainMe`.`chat` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user1_id` INT(11) NOT NULL,
  `user2_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_chat_user1_idx` (`user1_id` ASC),
  INDEX `fk_chat_user2_idx` (`user2_id` ASC),
  CONSTRAINT `fk_chat_user1`
    FOREIGN KEY (`user1_id`)
    REFERENCES `TrainMe`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chat_user2`
    FOREIGN KEY (`user2_id`)
    REFERENCES `TrainMe`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `TrainMe`.`discipline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrainMe`.`discipline` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `icon` BLOB NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `TrainMe`.`discipline_user_link`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrainMe`.`discipline_user_link` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `discipline_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_discipline_user_link_user_idx` (`user_id` ASC),
  INDEX `fk_discipline_user_link_discipline_idx` (`discipline_id` ASC),
  CONSTRAINT `fk_discipline_user_link_discipline`
    FOREIGN KEY (`discipline_id`)
    REFERENCES `TrainMe`.`discipline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_discipline_user_link_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `TrainMe`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 59
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `TrainMe`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrainMe`.`feedback` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `author_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `text` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_deal_author_idx` (`author_id` ASC),
  INDEX `fk_deal_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_feedback_author`
    FOREIGN KEY (`author_id`)
    REFERENCES `TrainMe`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `TrainMe`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `TrainMe`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrainMe`.`message` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `text` TEXT NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `chat_id` INT(11) NOT NULL,
  `author_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_message_chat1_idx` (`chat_id` ASC),
  INDEX `fk_message_user_idx` (`author_id` ASC),
  CONSTRAINT `fk_message_chat`
    FOREIGN KEY (`chat_id`)
    REFERENCES `TrainMe`.`chat` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_user`
    FOREIGN KEY (`author_id`)
    REFERENCES `TrainMe`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 276
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
