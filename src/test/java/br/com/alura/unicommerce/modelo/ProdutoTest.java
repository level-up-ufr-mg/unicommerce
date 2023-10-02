package br.com.alura.unicommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.util.JPAUtil;

class ProdutoTest {
	
	
	EntityManager em = JPAUtil.getEntityManager();
	ProdutoDao produtoDao = new ProdutoDao(em);
	CategoriaDao categoriaDao = new CategoriaDao(em);

	@Test
	void deveRegistrarUmProdutoComPrecoMenorOuIgualAZero() {
		String Saude = categoriaDao.buscaNomePorNome("Saude");
//		Categoria informatica = categoriaDao.buscaPorNome("Informatica");
//		Produto Macbook = new Produto("Macbook Pro", new BigDecimal("0.0"), "", 20, informatica);
		assertThrows(IllegalArgumentException.class, () -> {
			new Produto("Vacina", new BigDecimal("250"), "", 20, Saude);
		})
		;
	}

}
