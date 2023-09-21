package br.com.alura.unicommerce.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.modelo.TipoDesconto;
import br.com.alura.unicommerce.modelo.TipoDescontoItemPedido;
import br.com.alura.unicommerce.service.ClienteService;

public class RelatorioDeVendasClienteVoTest {
	
	static List<Pedido> listaComUmPedido = new ArrayList<>();
	static List<Pedido> listaCompleta = new ArrayList<>();
	static List<Pedido> listaVazia = new ArrayList<>();
	
	@BeforeAll
	static void preparaOsDados() {
		Categoria eletronicos = new Categoria("Eletrônicos", true);
		Produto mouseGamer = new Produto ("Mouse", "Mouse Gamer",  new BigDecimal("90"), 3, eletronicos);
		Produto tecladoGamer = new Produto ("Teclado", "Teclado Gamer", new BigDecimal("160"), 5, eletronicos);
		Produto foneGamer = new Produto ("Fone", "Fone Gamer",  new BigDecimal("230"), 10, eletronicos);
		
		
		Endereco endereco = new Endereco ( "Suriname", "107", "Casa", "Vila Maria Cristina", "Formiga", "MG");
		Cliente  cliente = new Cliente("Marcos Silva", "000.000.000-00", "37999999999", endereco);

		
		Pedido pedidoUm = new Pedido( BigDecimal.ZERO, TipoDesconto.NENHUM, new Cliente("Evandro", "444.444.444-66", "(11)99999-9999"));
		ItemDePedido pedidoUmItemDoPedido = new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, BigDecimal.ZERO, pedidoUm, mouseGamer );
		pedidoUm.adicionarItem(pedidoUmItemDoPedido);
		
		listaComUmPedido.add(pedidoUm);
		listaCompleta.add(pedidoUm);
		
		Pedido pedidoDois = new Pedido(BigDecimal.ZERO, TipoDesconto.NENHUM, new Cliente("Marcos", "555.444.444-66", "(11)99999-9999"));
		ItemDePedido pedidoDoisItemDoPedido = new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, BigDecimal.ZERO, pedidoDois, mouseGamer);
		ItemDePedido pedidoDoisItemDoPedido2 = new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, BigDecimal.ZERO, pedidoDois, tecladoGamer);
		pedidoDois.adicionarItem(pedidoDoisItemDoPedido);
		pedidoDois.adicionarItem(pedidoDoisItemDoPedido2);
		listaCompleta.add(pedidoDois);
		
		Pedido pedidoTres = new Pedido(BigDecimal.ZERO, TipoDesconto.NENHUM, new Cliente("Dayane", "666.444.444-66", "(11)99999-9999"));
		ItemDePedido pedidoTresItemDoPedido = new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, BigDecimal.ZERO, pedidoTres, mouseGamer);
		ItemDePedido pedidoTresItemDoPedido2 = new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1, BigDecimal.ZERO, pedidoTres, tecladoGamer);
		ItemDePedido pedidoTresItemDoPedido3 = new ItemDePedido(TipoDescontoItemPedido.NENHUM, 1,  BigDecimal.ZERO, pedidoTres, foneGamer);
		pedidoTres.adicionarItem(pedidoTresItemDoPedido);
		pedidoTres.adicionarItem(pedidoTresItemDoPedido2);
		pedidoTres.adicionarItem(pedidoTresItemDoPedido3);
		listaCompleta.add(pedidoTres);
		System.out.println("Inicializou os dados");
		
		Pedido pedidoQuatro = new Pedido(new BigDecimal("30"), TipoDesconto.NENHUM, cliente);
		listaVazia.add(pedidoQuatro);
	}
	
	@Test
	void deveGerarORelatorioComApenasUmUnicoPedido() {
		
		List<RelatorioDeVendasClienteVo> relatorioClientesFieis = new ClienteService().getRelatorioClientesFieis(listaComUmPedido);
	
		assertNotNull(relatorioClientesFieis);
		assertEquals(new BigDecimal("90"), relatorioClientesFieis.get(0).getMontanteVendido());
	}
	
	@Test
	void deveGarantirASomaDosTotaisDosPedido() {
		
		List<RelatorioDeVendasClienteVo> relatorioClientesFieis = new ClienteService().getRelatorioClientesFieis(listaCompleta);
		
		BigDecimal total = BigDecimal.ZERO;
		for (RelatorioDeVendasClienteVo pedido : relatorioClientesFieis) {
			total = total.add(pedido.getMontanteVendido());
		}
		
		assertNotNull(relatorioClientesFieis);
		assertEquals(new BigDecimal("820"), total);
	}
	

	@Test
	void deveGerarORelatorioSeNaoHouverPedidos() {
	
		List<RelatorioDeVendasClienteVo> relatorioClientesFieis = new ClienteService().getRelatorioClientesFieis(listaVazia);
		assertNotNull(relatorioClientesFieis);
		assertEquals(new BigDecimal("0"), relatorioClientesFieis.get(0).getMontanteVendido());

	}

}
