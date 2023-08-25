package br.com.alura.unicommerce.teste;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.util.JPAUtil;
import java.math.BigDecimal;

public class CadastroDeProduto {   
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        Categoria celulares = new Categoria();
        celulares.setNome("Celulares");
        celulares.setStatus("ATIVA");

        Produto celular = new Produto();
        celular.setNome("Smartphone Modelo X");
        celular.setPreco(new BigDecimal("1000.00")); // Agora aceita BigDecimal
        celular.setDescricao("Um ótimo smartphone");
        celular.setQuantidadeEmEstoque(50);
        celular.setCategoria(celulares);

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
