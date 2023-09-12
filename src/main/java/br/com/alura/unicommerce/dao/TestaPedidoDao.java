package br.com.alura.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.relatorios.RelatorioProdutosVendidosMaisDe3x;
import br.com.alura.unicommerce.util.JPAUtil;

public class TestaPedidoDao {
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDao pedidoDao = new PedidoDao(em);
		
		List<RelatorioProdutosVendidosMaisDe3x> relatorioProdutosVendidosMaisDe3x = pedidoDao.buscaRelatorioProdutosVendidosMaisDe3x();
		relatorioProdutosVendidosMaisDe3x.forEach(System.out::println);		
	}
}
