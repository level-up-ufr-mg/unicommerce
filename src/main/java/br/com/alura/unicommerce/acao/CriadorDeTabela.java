package br.com.alura.unicommerce.acao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriadorDeTabela {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nomeDaUnidadeDePersistencia");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.createNativeQuery("CREATE TABLE CATEGORIA (" + "ID INT PRIMARY KEY AUTO_INCREMENT,"
				+ "NOME VARCHAR(255) NOT NULL," + "STATUS ENUM('ATIVA', 'INATIVA') NOT NULL" + ")").executeUpdate();
		em.createNativeQuery("CREATE TABLE PRODUTO (" + "ID INT PRIMARY KEY AUTO_INCREMENT,"
				+ "NOME VARCHAR(255) NOT NULL," + "DESCRICAO TEXT," + "QUANTIDADE_ESTOQUE INT NOT NULL,"
				+ "CATEGORIA_ID INT," + "FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA(ID)" + ")").executeUpdate();
		em.createNativeQuery("CREATE TABLE CLIENTE (" + "ID INT PRIMARY KEY AUTO_INCREMENT,"
				+ "NOME VARCHAR(255) NOT NULL," + "CPF VARCHAR(11) NOT NULL," + "TELEFONE VARCHAR(20),"
				+ "RUA VARCHAR(255)," + "NUMERO VARCHAR(10)," + "COMPLEMENTO VARCHAR(255)," + "BAIRRO VARCHAR(255),"
				+ "CIDADE VARCHAR(255)," + "ESTADO VARCHAR(2)" + ")").executeUpdate();
		em.createNativeQuery("CREATE TABLE PEDIDO (" + "ID INT PRIMARY KEY AUTO_INCREMENT," + "DATA DATE NOT NULL,"
				+ "CLIENTE_ID INT," + "DESCONTO DECIMAL(10, 2),"
				+ "TIPO_DESCONTO ENUM('FIDELIDADE', 'NENHUM') NOT NULL,"
				+ "FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(ID)" + ")").executeUpdate();
		em.createNativeQuery("CREATE TABLE ITEM_PEDIDO (" + "ID INT PRIMARY KEY AUTO_INCREMENT,"
				+ "PRECO_UNITARIO DECIMAL(10, 2) NOT NULL," + "QUANTIDADE INT NOT NULL," + "PEDIDO_ID INT,"
				+ "PRODUTO_ID INT," + "DESCONTO DECIMAL(10, 2),"
				+ "TIPO_DESCONTO ENUM('QUANTIDADE', 'PROMOCAO', 'NENHUM') NOT NULL,"
				+ "FOREIGN KEY (PEDIDO_ID) REFERENCES PEDIDO(ID)," + "FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO(ID)"
				+ ")").executeUpdate();

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
