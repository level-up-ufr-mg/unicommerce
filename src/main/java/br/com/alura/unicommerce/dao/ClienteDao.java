package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.Relatorios.RelatorioDeVendasPorClienteVo;
import br.com.alura.unicommerce.modelo.Cliente;

public class ClienteDao {
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public Cliente buscaPorId(Long id) {
		if (id == 0)
			throw new IllegalArgumentException();
		Cliente econtrado = em.find(Cliente.class, id);
		return econtrado;
	}

	public void cadastra(Cliente cliente) {
		em.persist(cliente);
	}

	public void atualiza(Cliente cliente) {
		em.merge(cliente);
	}

	public void remove(Cliente cliente) {
		em.remove(cliente);
	}

	public List<Cliente> listaTodos() {
		String jpql = "SELECT c FROM Cliente c";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}

	public List<Cliente> listaPorNome(String nome) {
		String jpql = "SELECT c FROM Cliente c WHERE c.nome = :nome";
		return em.createQuery(jpql, Cliente.class).setParameter("nome", nome).getResultList();
	}

	public List<RelatorioDeVendasPorClienteVo> relatorioDeVendasPorClienteVo() {
		String jpql = "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasPorClienteVo(" 
				+ "c.dadosPessoais.nome, "
				+ "COUNT(p.id), " 
				+ "SUM(ip.precoUnitario * ip.quantidade) as montante) " 
				+ "FROM Cliente c "
				+ "LEFT JOIN c.pedido p " 
				+ "LEFT JOIN p.itens ip " 
				+ "GROUP BY c.dadosPessoais.nome "
				+ "ORDER BY montante DESC ";
		return em.createQuery(jpql, RelatorioDeVendasPorClienteVo.class).setMaxResults(3).getResultList();
	}
}
