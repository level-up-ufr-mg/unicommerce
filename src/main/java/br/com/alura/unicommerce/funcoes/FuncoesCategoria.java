package br.com.alura.unicommerce.funcoes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.util.JPAUtil;

public class FuncoesCategoria {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
				
		buscaPorId(em);
		listaTodas(em);
	}
	
	private static void buscaPorId(EntityManager em) {
		CategoriaDao buscaPorId = new CategoriaDao(em);

		List<Categoria> categoriasPorId = buscaPorId.buscaPorId(7L);
		categoriasPorId.forEach(c -> {
		    System.out.print("ID: " + c.getId() + ", ");
		    System.out.print("Nome: " + c.getNome() + ", ");
		    System.out.print("Ativo: " + c.isStatus());
		    System.out.println();
		});
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