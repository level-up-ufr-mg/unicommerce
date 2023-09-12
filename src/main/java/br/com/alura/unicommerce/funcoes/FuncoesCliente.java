package br.com.alura.unicommerce.funcoes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.util.JPAUtil;

public class FuncoesCliente {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        buscaPorId(em);
        cadastra(em);
        atualiza(em);
        remove(em);
        listaTodos(em);
        listaPorNome(em);
    }

	private static void buscaPorId(EntityManager em) {
		ClienteDao buscaPorId = new ClienteDao(em);

		List<Cliente> clientesPorId = buscaPorId.buscaPorId(2L);
		clientesPorId.forEach(p -> {
		    System.out.println("ID: " + p.getId() + ", ");
		    System.out.println("Nome: " + p.getNome() + ", ");
		    System.out.println("Preço: " + p.getTelefone() + ", ");
		    System.out.println("Descrição: " + p.getEndereco() + ", ");
		});
	}

	private static void cadastra(EntityManager em) {
		Endereco endereco = new Endereco("Palmeiras", 189, null, "Alvorada", "Doresópolis", "MG");
		Cliente cliente = new Cliente("Valmir Santos", "158.555.555-55", "(37) 97865-6545", endereco);

		ClienteDao ClienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		ClienteDao.cadastra(cliente);
		em.getTransaction().commit();
		em.close();
	}

	private static void listaTodos(EntityManager em) {
		ClienteDao clienteDaoListaTodos = new ClienteDao(em);

		List<Cliente> listaTodos = clienteDaoListaTodos.listaTodos();
		listaTodos.forEach(p -> {
		    System.out.println("ID: " + p.getId() + ", ");
		    System.out.println("Nome: " + p.getNome() + ", ");
		    System.out.println("Preço: " + p.getTelefone() + ", ");
		    System.out.println("Descrição: " + p.getEndereco() + ", ");
		    System.out.println();
		});
	}

	private static void listaPorNome(EntityManager em) {
		ClienteDao listaPorNome = new ClienteDao(em);

		List<Cliente> nomesIndisponiveis = listaPorNome.listaPorNome("Valmir Santos");
		nomesIndisponiveis.forEach(p -> {
		    System.out.println("ID: " + p.getId() + ", ");
		    System.out.println("Nome: " + p.getNome() + ", ");
		    System.out.println("Preço: " + p.getTelefone() + ", ");
		    System.out.println("Descrição: " + p.getEndereco() + ", ");
		    System.out.println();
		});
	}
}
