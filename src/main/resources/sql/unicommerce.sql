CREATE SCHEMA `unicommerce` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `unicommerce`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `unicommerce`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `quantidade_estoque` FLOAT NOT NULL,
  `categoria_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `unicommerce`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `unicommerce`.`pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `cliente_id` VARCHAR(45) NOT NULL,
  `desconto` FLOAT NULL,
  `tipo_desconto` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `unicommerce`.`item_pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `preco_unitario` FLOAT NOT NULL,
  `quantidade` FLOAT NOT NULL,
  `pedido_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  `desconto` FLOAT NULL,
  `tipo_desconto` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
