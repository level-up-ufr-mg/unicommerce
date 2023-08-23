package br.edu.uniformg.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.uniformg.unicommerce.modelo.Cliente;

/*
buscaPorId(id)
cadastra(Cliente)
atualiza(Cliente)
remove(Cliente)
listaTodos()
listaPorNome(nome)
*/

public class ClienteDao {
	
	private EntityManager em;
	
	public ClienteDao() {
		
	}
	
	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	
	
	public Cliente buscaClientePorId(Long id) {
		return em.find(Cliente.class, id);
	}
	
	public void atualizarCliente(Cliente cli) {
		this.em.merge(cli);
	}
	
	public void removerCliente(Cliente cli) {
		this.em.remove(cli);
	}
	
	public void cadastrarCliente(Cliente cli) {
		this.em.persist(cli);
	}
	
	public List<Cliente> listaTodosClientes() {
		String jpql = "SELECT c FROM Cliente c";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public void listaPorNomeCliente(Cliente nome) {
		String jpql = "SELECT c.nome FROM c";
		em.createQuery(jpql, Cliente.class);
	}

}
