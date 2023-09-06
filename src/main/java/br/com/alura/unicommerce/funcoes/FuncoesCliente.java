package br.com.alura.unicommerce.funcoes;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
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

        List<Cliente> clientesPorId = buscaPorId.buscaPorId(1L);
        clientesPorId.forEach(c -> {
            System.out.print("ID: " + c.getId() + ", ");
            System.out.print("Nome: " + c.getNome() + ", ");
            // Adicione mais campos aqui conforme a necessidade
            System.out.println();
        });
    }

    private static void cadastra(EntityManager em) {
        Cliente cliente = new Cliente("João", "joao@example.com");
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();
        clienteDao.cadastra(cliente);
        em.getTransaction().commit();
    }

    private static void atualiza(EntityManager em) {
        ClienteDao clienteDao = new ClienteDao(em);
        List<Cliente> clientesPorNome = clienteDao.listaPorNome("João");

        if (!clientesPorNome.isEmpty()) {
            Cliente cliente = clientesPorNome.get(0);
            cliente.setEmail("joao.novo@example.com");

            em.getTransaction().begin();
            clienteDao.atualiza(cliente);
            em.getTransaction().commit();
        }
    }

    private static void remove(EntityManager em) {
        ClienteDao clienteDao = new ClienteDao(em);
        List<Cliente> clientesPorNome = clienteDao.listaPorNome("João");

        if (!clientesPorNome.isEmpty()) {
            Cliente cliente = clientesPorNome.get(0);

            em.getTransaction().begin();
            clienteDao.remove(cliente);
            em.getTransaction().commit();
        }
    }

    private static void listaTodos(EntityManager em) {
        ClienteDao clienteDao = new ClienteDao(em);

        List<Cliente> listaTodos = clienteDao.listaTodos();
        listaTodos.forEach(c -> {
            System.out.print("ID: " + c.getId() + ", ");
            System.out.print("Nome: " + c.getNome() + ", ");
            // Adicione mais campos aqui conforme a necessidade
            System.out.println();
        });
    }

    private static void listaPorNome(EntityManager em) {
        ClienteDao clienteDao = new ClienteDao(em);

        List<Cliente> clientesPorNome = clienteDao.listaPorNome("Maria");
        clientesPorNome.forEach(c -> {
            System.out.print("ID: " + c.getId() + ", ");
            System.out.print("Nome: " + c.getNome() + ", ");
            // Adicione mais campos aqui conforme a necessidade
            System.out.println();
        });
    }
}
