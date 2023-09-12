package br.com.alura.unicommerce.dao;

import java.util.List;
import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Cliente;

public class ClienteDao {

    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public Cliente buscaPorId(Long id) {
        return em.find(Cliente.class, id);
    }

    public void cadastra(Cliente cliente) {
        this.em.persist(cliente);
    }

    public void atualiza(Cliente cliente) {
        this.em.merge(cliente);
    }

    public void remove(Cliente cliente) {
    	cliente = em.merge(cliente); //Caso a entidade esteja em detached aqui está forçando ela a entrar no estado managed
        this.em.remove(cliente);
    }

    public List<Cliente> listaTodos() {
    	String jpql = " SELECT c FROM Cliente c "; // esse Cliente não é o nome da tabela não, é o nome da entidade que como está ligada na tabela do bd  
        return  em.createQuery(jpql, Cliente.class).getResultList();
    }
    
    
    public List<Cliente> listaPorNome(String nome) {
    	String jpql = " SELECT c FROM Cliente c WHERE c.nome LIKE :nome ";
        return  em.createQuery(jpql, Cliente.class)
        		.setParameter("nome", "%" + nome + "%")
        		.getResultList();
   }
    
//    //Exemplo quando eu quero filtrar somente um registro
//    public String listaPorCPF(String cpf) {
//    	String jpql = "SELECT c.nome FROM Cliente c WHERE c.cpf = :cpf";
//        return  em.createQuery(jpql, String.class)
//        		.setParameter("cpf", cpf)
//        		.getSingleResult();
//    }
}
