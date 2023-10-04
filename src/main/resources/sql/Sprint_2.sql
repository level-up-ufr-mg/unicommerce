USE unicommerce;
ALTER TABLE produto
ADD preco DECIMAL(10, 2) NOT NULL;

USE unicommerce;
ALTER TABLE pedido
ADD valor_total DECIMAL(10, 2);