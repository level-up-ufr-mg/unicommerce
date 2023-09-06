package br.com.alura.unicommerce.funcoes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.util.JPAUtil;

public class FuncoesCategoria {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		/* cadastraCategoria(em); */
		
		CategoriaDao buscarPorIdCategoria = new CategoriaDao(em);
		Categoria c = buscarPorIdCategoria.buscarPorId(2l);
		System.out.println(c.getId());
	}
	
	
}
