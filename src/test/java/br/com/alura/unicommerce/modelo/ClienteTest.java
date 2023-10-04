package br.com.alura.unicommerce.modelo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.Relatorios.RelatorioDeVendasPorClienteVo;
import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.util.JPAUtil;

class ClienteTest {
	
	public static void main(String[] args) {
    	EntityManager em = JPAUtil.getEntityManager();

		ClienteDao clienteDao = new ClienteDao(em);
    	
    	List<RelatorioDeVendasPorClienteVo> relatorio = clienteDao.relatorioDeVendasPorClienteVo();
    	relatorio.forEach(System.out::println);
    	}

	}