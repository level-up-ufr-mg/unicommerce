package br.com.alura.unicommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.alura.unicommerce.Relatorios.RelatorioDeVendasPorClienteVo;
import br.com.alura.unicommerce.service.ClienteService;

public class PedidoTest {

	static List<Pedido> listaComUmPedido = new ArrayList<>();
	static List<Pedido> listaSemPedidos = new ArrayList<>();
	static List<Pedido> listaCompleta = new ArrayList<>();
	
	@BeforeAll
	static void preparaDados() {
		Endereco endereco = new Endereco("Rua da Praia", 
				789, "Casa 2", "Bairro Praiano", "Cidade Litorânea", "SC");
		Cliente cliente = new Cliente("Elisandra", "444.444.444-44", "(11)99999-9999", 
				endereco);
		
		Categoria categoria = new Categoria("Moda");
		Produto vestido = new Produto("Vestido de Seda", new BigDecimal("1300.00"),
				"Manequen o deixou", 10, categoria);
		Produto bermuda = new Produto("Bermuda de Seda", new BigDecimal("2600.00"),
				"Bermuda", 7, categoria);
		Produto camisa = new Produto("Camisa de Seda", new BigDecimal("4000.00"),
				"Camisa", 4, categoria);
		
		Pedido pedidoUm = new Pedido(cliente, new BigDecimal(1), TipoDeDescontoPedido.NENHUM, new BigDecimal(0)); 
		ItemDePedido umPedidoItemDePedido = new ItemDePedido(vestido, pedidoUm, 1, new BigDecimal(0), 
				TipoDeDescontoItemDePedido.NENHUM);
		pedidoUm.adicionarItem(umPedidoItemDePedido);	
		listaComUmPedido.add(pedidoUm);
		listaCompleta.add(pedidoUm);
		
		Pedido pedidoDois = new Pedido(cliente, new BigDecimal(1), TipoDeDescontoPedido.NENHUM, new BigDecimal(0)); 
		ItemDePedido doisPedidoItemDePedido01 = new ItemDePedido(vestido, pedidoDois, 1, new BigDecimal(0), 
				TipoDeDescontoItemDePedido.NENHUM);
		ItemDePedido doisPedidoItemDePedido02 = new ItemDePedido(bermuda, pedidoDois, 1, new BigDecimal(0), 
				TipoDeDescontoItemDePedido.NENHUM);
		pedidoDois.adicionarItem(doisPedidoItemDePedido01);
		pedidoDois.adicionarItem(doisPedidoItemDePedido02);
		listaCompleta.add(pedidoDois);
		
		Pedido pedidoTres = new Pedido(cliente, new BigDecimal(1), TipoDeDescontoPedido.NENHUM, new BigDecimal(0)); 
		ItemDePedido tresPedidoItemDePedido01 = new ItemDePedido(vestido, pedidoTres, 1, new BigDecimal(0), 
				TipoDeDescontoItemDePedido.NENHUM);
		ItemDePedido tresPedidoItemDePedido02 = new ItemDePedido(camisa, pedidoTres, 1, new BigDecimal(0), 
				TipoDeDescontoItemDePedido.NENHUM);
		ItemDePedido tresPedidoItemDePedido03 = new ItemDePedido(bermuda, pedidoTres, 1, new BigDecimal(0), 
				TipoDeDescontoItemDePedido.NENHUM);
		pedidoTres.adicionarItem(tresPedidoItemDePedido01);
		pedidoTres.adicionarItem(tresPedidoItemDePedido02);
		pedidoTres.adicionarItem(tresPedidoItemDePedido03);	
		listaCompleta.add(pedidoTres);
	}

	@Test
	void deveGerarORelatorioSeNaoHouverPedidos() {
		
		List<RelatorioDeVendasPorClienteVo> relatorioClientesFieis = 
				new ClienteService().getRelatorioClientesFieis(listaSemPedidos);
		
		assertNotNull(relatorioClientesFieis);
		assertEquals(relatorioClientesFieis.isEmpty(), relatorioClientesFieis);
	}

	@Test
	void deveGarantirASomaDosTotaisDosPedidos() {
		List<RelatorioDeVendasPorClienteVo> relatorioClientesFieis = 
				new ClienteService().getRelatorioClientesFieis(listaComUmPedido);
		
		BigDecimal total = BigDecimal.ZERO;
		for (RelatorioDeVendasPorClienteVo pedido : relatorioClientesFieis) {
			total = total.add(pedido.getMontante());
		}
		
		assertNotNull(relatorioClientesFieis);
		assertEquals(new BigDecimal("1300.00"), total);
		}
	
	@Test
	void deveGerarORelatorioComApenasUmUnicoPedido() {
		
		List<RelatorioDeVendasPorClienteVo> relatorioClientesFieis = new ClienteService().getRelatorioClientesFieis(listaComUmPedido);
		
		assertNotNull(relatorioClientesFieis);
		assertEquals(new BigDecimal("1300.00"), relatorioClientesFieis.get(0).getMontante());
	
	}

}
