package br.com.alura.unicommerce.Controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.Relatorios.RelatorioDeVendasPorCategoriaVo;
import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.util.JPAUtil;

public class ControllerCategoria {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		cadastra(em);
		buscaPorId(em);
		listaTodas(em);

		CategoriaDao categoriaDao = new CategoriaDao(em);
//		BigDecimal totalVendidoBigDecimal = pedidoDao.valorTotalVendido();
//		System.out.println("Valor total vendido: " + totalVendidoBigDecimal);

		List<RelatorioDeVendasPorCategoriaVo> relatorio = categoriaDao.relatorioDeVendasPorCategoriaVo();
		relatorio.forEach(System.out::println);
	}

	private static void cadastra(EntityManager em) {

		CategoriaDao categoriaDao = new CategoriaDao(em);
		Categoria categoria01 = new Categoria("Eletrônicos");
		Categoria categoria02 = new Categoria("Moda");
		Categoria categoria03 = new Categoria("Esportes");
		Categoria categoria04 = new Categoria("Decoração");
		Categoria categoria05 = new Categoria("Eletrodomésticos");


		em.getTransaction().begin();
		categoriaDao.cadastra(categoria01);
		categoriaDao.cadastra(categoria02);
		categoriaDao.cadastra(categoria03);
		categoriaDao.cadastra(categoria04);
		categoriaDao.cadastra(categoria05);
		em.getTransaction().commit();
		em.close();
	}

	private static void buscaPorId(EntityManager em) {
		CategoriaDao buscaPorId = new CategoriaDao(em);

		Categoria categoriasPorId = buscaPorId.buscaPorId(1L);
		System.out.print(categoriasPorId);
	}

	private static void listaTodas(EntityManager em) {
		CategoriaDao listaTodas = new CategoriaDao(em);

		List<Categoria> listaTodasCategorias = listaTodas.listaTodas();
		listaTodasCategorias.forEach(c -> {
			System.out.print("ID: " + c.getId() + ", ");
			System.out.print("Nome: " + c.getNome() + ", ");
			System.out.print("Ativo: " + c.isStatus());
			System.out.println();
		});
	}

}