package br.com.alura.unicommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.vo.RelatorioClientesFiesVo;
import jakarta.persistence.EntityManager;

@Repository
public class ClienteDao {

	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public Cliente buscaPorId(Long id) {
		return em.find(Cliente.class, id);
	}

	public void cadastra(Cliente cliente) {
		this.em.persist(cliente);
	}

	public void atualiza(Cliente cliente) {
		this.em.merge(cliente);
	}

	public void remove(Cliente cliente) {
		cliente = em.merge(cliente);
		this.em.remove(cliente);
	}

	public List<Cliente> listaTodos() {
		String jpql = " SELECT c FROM Cliente c ";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}

	public List<Cliente> listaPorNome(String nome) {
		String jpql = " SELECT c FROM Cliente c WHERE c.nome LIKE :nome ";
		return em.createQuery(jpql, Cliente.class).setParameter("nome", "%" + nome + "%").getResultList();
	}

	public String listaPorCPF(String cpf) {
		String jpql = "SELECT c.nome FROM Cliente c WHERE c.cpf = :cpf";
		return em.createQuery(jpql, String.class).setParameter("cpf", cpf).getSingleResult();
	}

	public List<RelatorioClientesFiesVo> relatorioClientesFies() {
		String jpql = " SELECT new br.com.alura.unicommerce.vo.RelatorioClientesFiesVo( "
				+ " p.cliente.nome, COUNT(p), SUM(p.valorTotal)) " + " FROM Pedido p " + " JOIN p.cliente c "
				+ " GROUP BY c.nome ";
		return em.createQuery(jpql, RelatorioClientesFiesVo.class).getResultList();
	}
}