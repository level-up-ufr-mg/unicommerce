//package br.com.alura.unicommerce.modelo;
//
//import java.util.List;
//
//import br.com.alura.unicommerce.Relatorios.RelatorioDeVendasPorClienteVo;
//import jakarta.persistence.EntityManager;
//
//class ClienteTest {
//	
//	public static void main(String[] args) {
//    	EntityManager em = JPAUtil.getEntityManager();
//
//		ClienteDao clienteDao = new ClienteDao(em);
//    	
//    	List<RelatorioDeVendasPorClienteVo> relatorio = clienteDao.relatorioDeVendasPorClienteVo();
//    	relatorio.forEach(System.out::println);
//    	}
//
//	}