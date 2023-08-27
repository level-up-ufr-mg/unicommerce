package br.com.alura.unicommerce.teste;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.util.JPAUtil;

public class CadastroDeCliente {
	public static void main(String[] args) {
		Cliente Maria = new Cliente();
		Maria.setNome("Maria do Carmo");
		Maria.setCpf("123.456.789");
		Maria.setTelefone("37 012345-6789");
		
		EntityManager em = JPAUtil.getEntityManager();
		ClienteDao dao = new ClienteDao(em);
		
		em.getTransaction().begin();
		dao.buscaPorId(Maria);
	}
}
