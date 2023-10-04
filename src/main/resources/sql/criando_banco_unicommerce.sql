CREATE DATABASE unicommerce;

USE unicommerce;

CREATE TABLE categoria (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL COMMENT '0: Inativa, 1: Ativa'
);

CREATE TABLE produto (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    quantidade_estoque INT NOT NULL,
    categoria_id BIGINT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

CREATE TABLE cliente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    rua VARCHAR(255),
    numero VARCHAR(10),
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(2)
);

CREATE TABLE pedido (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data DATE NOT NULL,
    cliente_id BIGINT  NOT NULL,
    desconto DECIMAL(10, 2)  NOT NULL,
    tipo_desconto VARCHAR(20) NOT NULL,-- Nenhum, Fidelidade
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE item_pedido (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL,
    pedido_id BIGINT  NOT NULL,
    produto_id BIGINT  NOT NULL,
    desconto DECIMAL(10, 2)  NOT NULL,
    tipo_desconto VARCHAR(20) NOT NULL, -- Nenhum, Promoção, Quantidade ',  
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

