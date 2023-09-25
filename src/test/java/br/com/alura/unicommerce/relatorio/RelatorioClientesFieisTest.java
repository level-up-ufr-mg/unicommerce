//package br.com.alura.unicommerce.relatorio;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
////import com.google.protobuf.Internal.ListAdapter; // comentei essa importação pois começou a dar erro quando começei a migrar o projeto para Spring boot
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import br.com.alura.unicommerce.modelo.Pedido;
//import br.com.alura.unicommerce.modelo.Produto;
//import br.com.alura.unicommerce.modelo.TipoDescontoItemPedido;
//import br.com.alura.unicommerce.modelo.Categoria;
//import br.com.alura.unicommerce.modelo.Cliente;
//import br.com.alura.unicommerce.modelo.Endereco;
//import br.com.alura.unicommerce.modelo.ItemDePedido;
//import br.com.alura.unicommerce.modelo.TipoDescontoPedido;
//import br.com.alura.unicommerce.service.ClienteService;
//import br.com.alura.unicommerce.vo.RelatorioClientesFiesVo;
//
//public class RelatorioClientesFieisTest {
//
//	static List<Pedido> listaUmPedidos = new ArrayList<>();
//	static List<Pedido> listaCompleta = new ArrayList<>();
//	static List<Pedido> listaVazia = new ArrayList<>();
//	
//	@BeforeAll //para usar essa anotação o metodo tem que ser static
//	static void preparaDados() {
//		
//		Categoria categoria = new Categoria("Eletrônicos", true);
//		Produto produto = new Produto ("Mouse","Mouse Gamer",3, categoria, new BigDecimal("120"));
//		Produto produto1 = new Produto ("Teclado","Teclado Gamer",6, categoria, new BigDecimal("110"));
//		Produto produto2 = new Produto ("Fone","Fone Gamer",5, categoria, new BigDecimal("150"));
//		
//		
//		Endereco endereco = new Endereco ( "Avenida Brasil", "168", "Casa", "Ouro Negro", "Formiga", "MG");
//		Cliente  cliente = new Cliente("Dayane Costa", "00000000000", "37998751208", endereco, null);
//		
//		Pedido pedido = new Pedido(cliente, new BigDecimal("30"));
//		ItemDePedido itemPedido = new ItemDePedido(2, pedido, produto, new BigDecimal("30") , TipoDescontoItemPedido.NENHUM);
//		pedido.adicionarItem(itemPedido);
//		listaUmPedidos.add(pedido);	
//		listaCompleta.add(pedido);
//		
//		
//		Pedido pedido2 = new Pedido(cliente, new BigDecimal("30"));
//		ItemDePedido itemPedido2 = new ItemDePedido(2, pedido2, produto, new BigDecimal("30") , TipoDescontoItemPedido.NENHUM);
//		ItemDePedido itemPedido3 = new ItemDePedido(2, pedido2, produto1, new BigDecimal("30") , TipoDescontoItemPedido.NENHUM);
//		ItemDePedido itemPedido4 = new ItemDePedido(2, pedido2, produto2, new BigDecimal("30") , TipoDescontoItemPedido.NENHUM);
//		pedido2.adicionarItem(itemPedido2);
//		pedido2.adicionarItem(itemPedido3);
//		pedido2.adicionarItem(itemPedido4);
//		listaCompleta.add(pedido2);
//		
//		
//		Pedido pedido3 = new Pedido(cliente, new BigDecimal("30"), TipoDescontoPedido.NENHUM);
//		ItemDePedido itemPedido5 = new ItemDePedido(2, pedido3, produto, new BigDecimal("30") , TipoDescontoItemPedido.NENHUM);
//		ItemDePedido itemPedido6 = new ItemDePedido(2, pedido3, produto1, new BigDecimal("30") , TipoDescontoItemPedido.NENHUM);
//		pedido3.adicionarItem(itemPedido5);
//		pedido3.adicionarItem(itemPedido6);
//		listaCompleta.add(pedido3);
//		
//		Pedido pedido4 = new Pedido(cliente, new BigDecimal("30"), TipoDescontoPedido.NENHUM);
//		listaVazia.add(pedido4);
//		
//	}
//	
//	
//	@Test
//	void deveRelatorioComApenasUmUnicoPedido() {
//		
//		List<RelatorioClientesFiesVo> relatorioClientesFieis = new ClienteService().getRelatorioClienteFieis(listaUmPedidos);
//		assertNotNull(relatorioClientesFieis);
//		assertEquals(new BigDecimal("240"), relatorioClientesFieis.get(0).getTotalGasto());
//		
//	}
//	
//	
//	@Test
//    void deveGerarORelatorioSeNaoTiverPedido() {
//		
//		List<RelatorioClientesFiesVo> relatorioClientesFieis = new ClienteService().getRelatorioClienteFieis(listaVazia);
//		assertNotNull(relatorioClientesFieis);
//		assertEquals(new BigDecimal("0"), relatorioClientesFieis.get(0).getTotalGasto());
//		
//	}
//	
//	
//	@Test
//    void deveGarantirQueASomaDosTotaisDosPedidos() {
//
//		List<RelatorioClientesFiesVo> relatorioClientesFieis = new ClienteService().getRelatorioClienteFieis(listaCompleta);
//		
//		BigDecimal total = BigDecimal.ZERO;
////		relatorioClientesFieis.forEach(pedido -> {
////			total.add(pedido.getTotalGasto());
////		});
//		
//		for (RelatorioClientesFiesVo pedido : relatorioClientesFieis) {
//			total = total.add(pedido.getTotalGasto());
//		}
//		
//		assertNotNull(relatorioClientesFieis);
//		assertEquals(new BigDecimal("240"), relatorioClientesFieis.get(0).getTotalGasto());
//		
//		
//	}
//    
//}
