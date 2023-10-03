//package br.com.alura.unicommerce.Test;
// 
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeAll;
//
//import br.com.alura.util.unicommerce.modelo.Categoria;
//import br.com.alura.util.unicommerce.modelo.Cliente;
//import br.com.alura.util.unicommerce.modelo.Descontos;
//import br.com.alura.util.unicommerce.modelo.Endereco;
//import br.com.alura.util.unicommerce.modelo.ItemPedido;
//import br.com.alura.util.unicommerce.modelo.Pedido;
//import br.com.alura.util.unicommerce.modelo.Produto;
//public class RelatoriosTes {
//	
//	static List<Pedido> listaComUmPedido = new ArrayList<>();
//	static List<Pedido> listaCompleta = new ArrayList<>();
//	
//	@BeforeAll
//	static void preparaOsDados() {
//		Categoria eletronicos = new Categoria(null,"Eletronicos", "ativa");
//		Produto mouseGamer = new Produto (null,"Mouse", "Mouse Gamer", 3L, new BigDecimal("90"),eletronicos);
//		Produto tecladoGamer = new Produto (null,"Teclado", "Teclado Gamer", 5L,  new BigDecimal("160"),eletronicos);
//		Produto foneGamer = new Produto (null,"Fone", "Fone Gamer", 10L,  new BigDecimal("230"),eletronicos);
//		
//		Endereco endereco = new Endereco("rua x", 100L, "casa", "centro",
//				"São paulo ", "SAO PAULO");
//		
//		Pedido pedidoUm = new Pedido(null, new Timestamp(System.currentTimeMillis()),BigDecimal.ZERO, Descontos.NENHUM, new Cliente(null, " ANA ", 34342545L, 98524971L, endereco),BigDecimal.ZERO );
//		ItemPedido pedidoUmItemDoPedido = new ItemPedido(null,BigDecimal.ZERO,1L, pedidoUm, mouseGamer, BigDecimal.ZERO, Descontos.NENHUM);
//		
//		pedidoUm.adicionarItem(pedidoUmItemDoPedido);
//		
//		listaComUmPedido.add(pedidoUm);
//		listaCompleta.add(pedidoUm);
//		
//		Pedido pedidoDois = new Pedido(null, new Timestamp(System.currentTimeMillis()),BigDecimal.ZERO, Descontos.NENHUM, new Cliente(null, " BEATRIZ ", 34342545L, 98524971L, endereco),BigDecimal.ZERO );
//		ItemPedido pedidoDoisItemDoPedido = new ItemPedido(null,BigDecimal.ZERO,1L, pedidoDois, mouseGamer, BigDecimal.ZERO, Descontos.NENHUM);
//		ItemPedido pedidoDoisItemDoPedido2 = new ItemPedido(null,BigDecimal.ZERO,1L ,pedidoDois, tecladoGamer, BigDecimal.ZERO,Descontos.NENHUM);
//		pedidoDois.adicionarItem(pedidoDoisItemDoPedido);
//		pedidoDois.adicionarItem(pedidoDoisItemDoPedido2);
//		listaCompleta.add(pedidoDois);
//		
//		Pedido pedidoTres = new Pedido(null, new Timestamp(System.currentTimeMillis()),BigDecimal.ZERO, Descontos.NENHUM, new Cliente(null, " CARLOS ", 34342545L, 98524971L, endereco),BigDecimal.ZERO );
//		ItemPedido pedidoTresItemDoPedido = new ItemPedido(null,BigDecimal.ZERO,1L,  pedidoTres, mouseGamer, BigDecimal.ZERO, Descontos.NENHUM);
//		ItemPedido pedidoTresItemDoPedido2 = new ItemPedido(null,BigDecimal.ZERO,1L, pedidoTres, tecladoGamer, BigDecimal.ZERO, Descontos.NENHUM);
//		ItemPedido pedidoTresItemDoPedido3 = new ItemPedido(null,BigDecimal.ZERO,1L, pedidoTres, foneGamer, BigDecimal.ZERO, Descontos.NENHUM);
//		pedidoTres.adicionarItem(pedidoTresItemDoPedido);
//		pedidoTres.adicionarItem(pedidoTresItemDoPedido2);
//		pedidoTres.adicionarItem(pedidoTresItemDoPedido3);
//		listaCompleta.add(pedidoTres);
//		System.out.println("Inicializou os dados");
//	}
//	
////	@Test
////	void deveGerarORelatorioComApenasUmUnicoPedido() {
////		List<RelatorioClientesFieisVO> relatorioClientesFieis = new ClienteService().getRelatorioClientesFieis(listaComUmPedido);
////	
////		assertNotNull(relatorioClientesFieis);
////		assertEquals(new BigDecimal("90"), relatorioClientesFieis.get(0).getTotalGasto());
////	}
////	
////	@Test
////	void deveGarantirASomaDosTotaisDosPedido() {
////		
////		List<RelatorioClientesFieisVO> relatorioClientesFieis = new ClienteService().getRelatorioClientesFieis(listaCompleta);
////			BigDecimal total = BigDecimal.ZERO;
////			
////			 for(RelatorioClientesFieisVO pedido : relatorioClientesFieis) {
////				 total = total.add(pedido.getTotalGasto());
////			 }
////				 
////			assertNotNull(relatorioClientesFieis);
////			assertEquals(new BigDecimal("480"), total);
////	
////	}
////	
////	@Test
////	void deveGerarORelatorioSeNaoHouverPedidos() {
////	
////
////	}
//
//}