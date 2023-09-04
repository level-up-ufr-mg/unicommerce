package br.com.alura.unicommerce.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.util.JPAUtil;
import br.com.alura.unicommerce.vo.RelatorioDeVendasCategoriaVo;
import br.com.alura.unicommerce.vo.RelatorioDeVendasClienteVo;
import br.com.alura.unicommerce.vo.RelatorioProdutoVendidosMaisTresVezesVo;

public class RelatorioVendasController {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		PedidoDao pedidoDao = new PedidoDao(em);

		/*
		 * BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		 * System.out.println("VALOR TOTAL: " +totalVendido);
		 */

		/*
		 * List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		 * relatorio.forEach(System.out::println);
		 */

		System.out.println("--------------- Relatório de produtos vendidos mais de três vezes  ------------------ ");

		List<RelatorioProdutoVendidosMaisTresVezesVo> relatorioProdutosVendidos = pedidoDao
				.buscarProdutosVendidosMaisTresVezes();
		relatorioProdutosVendidos.forEach(System.out::println);

		System.out.println("--------------- Relatório de clientes fiéis  ------------------ ");

		List<RelatorioDeVendasClienteVo> relatorioClienteFieis = pedidoDao.relatorioDeVendasClientesFieis();
		relatorioClienteFieis.forEach(System.out::println);

		System.out.println("--------------- Relatório de vendas por categoria  -------------- ");

		List<RelatorioDeVendasCategoriaVo> relatorioVendasPorCategoria = pedidoDao.relatorioDeVendasPorCategoria();
		relatorioVendasPorCategoria.forEach(System.out::println);

	}

}
