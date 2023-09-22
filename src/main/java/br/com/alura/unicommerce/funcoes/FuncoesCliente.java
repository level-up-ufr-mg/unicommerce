package br.com.alura.unicommerce.funcoes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.util.JPAUtil;

public class FuncoesCliente {
    public static void main(String[] args) {
    	EntityManager em = JPAUtil.getEntityManager();
    	long nmroIdDoCliente = 20L;
        
        Endereco endereco = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
		Cliente cliente = new Cliente("Ana Costa", "456.789.123-00", "(48) 55555-5555", endereco);
        
		cadastra(em, cliente);
        buscaPorId(em, nmroIdDoCliente);
		atualiza(em, cliente);
		remove(em, cliente);
		listaTodos(em);
		listaPorNome(em);
    }

	private static void buscaPorId(EntityManager em, Long nmroIdDoCliente) {
		ClienteDao buscaPorId = new ClienteDao(em);

		Cliente clientesPorId = buscaPorId.buscaPorId(nmroIdDoCliente);
		System.out.println("ID: " + clientesPorId);
	}

	private static void cadastra(EntityManager em, Cliente cliente) {

		ClienteDao ClienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		ClienteDao.cadastra(cliente);
		em.getTransaction().commit();
		em.close();
	}
	
	private static void atualiza(EntityManager em, Cliente cliente) {
	    em.getTransaction().begin();
	    em.merge(cliente);
	    em.getTransaction().commit();
	}

	private static void remove(EntityManager em, Cliente cliente) {
	    em.getTransaction().begin();
	    em.remove(cliente);
	    em.getTransaction().commit();
	}

	private static void listaTodos(EntityManager em) {
		ClienteDao clienteDaoListaTodos = new ClienteDao(em);

		List<Cliente> listaTodos = clienteDaoListaTodos.listaTodos();
		listaTodos.forEach(p -> {
		    System.out.println("ID: " + p.getId() + ", ");
		    System.out.println("Nome: " + p.getNome() + ", ");
		    System.out.println("Preço: " + p.getTelefone() + ", ");
		    System.out.println("Descrição: " + p.getEndereco() + ", ");
		    System.out.println();
		});
	}

	private static void listaPorNome(EntityManager em) {
		ClienteDao listaPorNome = new ClienteDao(em);

		List<Cliente> nomesIndisponiveis = listaPorNome.listaPorNome("Valmir Santos");
		nomesIndisponiveis.forEach(p -> {
		    System.out.println("ID: " + p.getId() + ", ");
		    System.out.println("Nome: " + p.getNome() + ", ");
		    System.out.println("Preço: " + p.getTelefone() + ", ");
		    System.out.println("Descrição: " + p.getEndereco() + ", ");
		    System.out.println();
		});
	}
}
