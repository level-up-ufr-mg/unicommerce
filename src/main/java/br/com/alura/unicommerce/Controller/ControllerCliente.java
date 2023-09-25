package br.com.alura.unicommerce.Controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.util.JPAUtil;
import br.com.alura.unicommerce.vo.RelatorioDeVendasPorClienteVo;

public class ControllerCliente {
    public static void main(String[] args) {
    	EntityManager em = JPAUtil.getEntityManager();
        
    	
    	ClienteDao clienteDao = new ClienteDao(em);
    	
    	List<RelatorioDeVendasPorClienteVo> relatorio = clienteDao.relatorioDeVendasPorClienteVo();
    	relatorio.forEach(System.out::println);
//		cadastra(em);
//        buscaPorId(em);
//		atualiza(em);
//		remove(em);
//		listaTodos(em);
//		listaPorNome(em);
    }

	private static void buscaPorId(EntityManager em) {
    	long nmroIdDoCliente = 20L;
		ClienteDao buscaPorId = new ClienteDao(em);

		Cliente clientesPorId = buscaPorId.buscaPorId(nmroIdDoCliente);
		System.out.println("ID: " + clientesPorId);
	}

	private static void cadastra(EntityManager em) {
		Endereco endereco01 = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
		Cliente cliente01 = new Cliente("Ana Costa", "456.789.123-00", "(48) 55555-5555", endereco01);
		
		Endereco endereco02 = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
		Cliente cliente02 = new Cliente("Marcelo", "111.111.111-11", "(37) 89795-8575", endereco02);
		
		Endereco endereco03 = new Endereco("Avenida Central", 456, "Bloco A", "Centro", "Cidade Grande", "SP");
		Cliente cliente03 = new Cliente("Ana Maria", "222.222.222-22", "(11) 98765-4321", endereco03);
		
		Endereco endereco04 = new Endereco("Rua das Flores", 123, "Casa 5", "Jardim Primavera", "Cidade Pequena", "RJ");
		Cliente cliente04 = new Cliente("Carlos", "333.333.333-33", "(21) 87654-3210", endereco04);
		
		Endereco endereco05 = new Endereco("Avenida das Árvores", 456, "Apartamento 10", "Centro", "Cidade Grande", "SP");
		Cliente cliente05 = new Cliente("Ana", "444.444.444-44", "(11) 98765-4321", endereco05);

		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		clienteDao.cadastra(cliente01);
		clienteDao.cadastra(cliente02);
		clienteDao.cadastra(cliente03);
		clienteDao.cadastra(cliente04);
		clienteDao.cadastra(cliente05);
		em.getTransaction().commit();
		em.close();
	}
	
	private static void atualiza(EntityManager em) {
		Endereco endereco01 = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
		Cliente cliente01 = new Cliente("Ana Costa", "456.789.123-00", "(48) 55555-5555", endereco01);
		
	    em.getTransaction().begin();
	    em.merge(cliente01);
	    em.getTransaction().commit();
	}

	private static void remove(EntityManager em) {
		Endereco endereco01 = new Endereco("Rua da Praia", 789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
		Cliente cliente01 = new Cliente("Ana Costa", "456.789.123-00", "(48) 55555-5555", endereco01);
		
	    em.getTransaction().begin();
	    em.remove(cliente01);
	    em.getTransaction().commit();
	}

	private static void listaTodos(EntityManager em) {
		ClienteDao clienteDaoListaTodos = new ClienteDao(em);

		List<Cliente> listaTodos = clienteDaoListaTodos.listaTodos();
		listaTodos.forEach(p -> {
		    System.out.println("ID: " + p.getId() + ", ");
		    System.out.println("Nome: " + p.getNome() + ", ");
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
		    System.out.println("Descrição: " + p.getEndereco() + ", ");
		    System.out.println();
		});
	}
}
