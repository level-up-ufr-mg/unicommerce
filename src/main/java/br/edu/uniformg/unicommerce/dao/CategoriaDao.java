package br.edu.uniformg.unicommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import br.edu.uniformg.unicommerce.modelo.Categoria;

/*
	buscarPorId(id)
	cadastra(Categoria)
	listaTodas()
*/

public class CategoriaDao {
	
	private EntityManager em;
	
	public CategoriaDao(EntityManager em) { //contrutor já recebe o "em" pronto
		this.em = em;
	}
	
    public Categoria buscarPorId(Long id) { 
    	return em.find(Categoria.class, id);
    }
    
    public void cadastrarCategoria(Categoria categoria) {
    	this.em.persist(categoria);
    }
    

    public List<Categoria> listarCategorias () {
    	String jpql = "SELECT c FROM Categoria c";// " SELECT * FROM Categoria"; // Carrega os objetos c em Categoria
    	return em.createQuery(jpql, Categoria.class).getResultList();
    }   
    
    
	   //EntityManagerFactory factory =Persistence.createEntityManagerFactory("unicommerce");
	   //EntityManager em = factory.createEntityManager();  
    
    
//    public void cadastrarCategoria(Categoria categoria) {
//    	em.getTransaction().begin();
//    	em.persist(categoria);
//    	em.getTransaction().commit();
//    	em.close();
//    	
//    }

}
