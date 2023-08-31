package br.com.alura.unicommerce.funcoes;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.util.JPAUtil;

public class BuscaClientePorId {
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
	}
}
