package br.com.alura.util.Controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.util.Domain.Cliente.Cliente;
import br.com.alura.util.Domain.Cliente.ClienteRepositoy;
import br.com.alura.util.Domain.Pedido.DadosCadastroPedidosDTO;
import br.com.alura.util.Domain.Pedido.Pedido;
import br.com.alura.util.Domain.Pedido.PedidoRepository;
import br.com.alura.util.Domain.Produto.Produto;
import br.com.alura.util.Domain.Produto.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedido")
public class CadastroDePedido {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteRepositoy clienteRepositoy;
	
	 
	
	 
	 
	 @GetMapping("/{pedidoId}")
	    public ResponseEntity<Page<Pedido>> getPedidoDetails(@PathVariable Long pedidoId, Pageable pageable) {
		  Optional<Pedido> obj = 	repository.findById(pedidoId);
		 	if ( obj.isPresent() && !obj.isEmpty()) {
		 		Page<Pedido> pedidoPage = repository.DetalhamentoDePedido(pedidoId, pageable);
		 		 return ResponseEntity.ok(pedidoPage);
			}else {
				return ResponseEntity.notFound().build();
			}
	    } /// nao deu certo 
	 
	 
	 @PostMapping
		@Transactional
		public void cadastra(@RequestBody @Valid DadosCadastroPedidosDTO dados) {
			
			Cliente cliente = dados.cliente();
			Long idCliente = cliente.getClienteId();
			
			Produto produto = dados.itemPedido().getProdutoId();
			Long idProduto = produto.getProdutoId();
			
			
			Cliente  ClienteDePedido = clienteRepositoy.getReferenceById(idCliente);
			Produto  ProdutoDePedido = produtoRepository.getReferenceById(idProduto);
			
			
				Optional<Cliente>objCLiente	= 	clienteRepositoy.findById(idCliente) ;
				Optional<Produto>objProduto = produtoRepository.findById(idProduto)	;		
			if (objCLiente.isPresent() && objProduto.isPresent()) {
				repository.save(new Pedido(dados, ClienteDePedido , ProdutoDePedido));
			}
		}

	
	
	
	
	
	
//	 @PostMapping
//		@Transactional
//		ResponseEntity<Object> cadastra(@RequestBody @Valid DadosNovoPedido dadosDePedido, 
//				BindingResult result) {
//			
//			if (result.hasErrors()) ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//			
//			Optional<Pedido> novoPedido = dadosDePedido.converter(clienteService, produtoService);
//			
//			if (novoPedido.isPresent()) {pedidoService.cadastra(novoPedido.get());
//				return ResponseEntity.status(HttpStatus.CREATED).body(new DadosPedido(novoPedido.get()));
//			}
//			
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DadosMensagem("Falha ao gravar novo pedido"));
//		}
	
	
//	public static void main(String[] args) {
//		 
//		EntityManager em = Factory.getEntityManager();
//		ProdutoDao produto = new ProdutoDao(em); 
//		ClienteDao ClienteDao = new ClienteDao(em);  
//		PedidoDao pedidoDao = new PedidoDao(em);
//  
//		
//		
//		
//		Endereco endereco = new Endereco("rua x", 100L, "casa", "centro",
//				"São paulo ", "SAO PAULO");
//		Cliente cliente = new Cliente(null, "Ana Beatriz ", 1254686588L, 99043201L, endereco);
//		 
//		Pedido pedido = new Pedido(null, new Timestamp(System.currentTimeMillis()), new BigDecimal("00"),
//				Descontos.NENHUM, cliente,BigDecimal.ZERO);
//
//	Produto buscaProID = 	produto.buscaProID(1L); 
//	
//		pedido.adicionarItem(new ItemPedido(null, new BigDecimal("10"), 2L, pedido, buscaProID , new BigDecimal("00"),
//				Descontos.NENHUM));
//
//		
//		//Cadastra(cliente, pedido, em, ClienteDao, pedidoDao);
//
//		
//		
//		// Editar(cliente, pedido, em, ClienteDao, pedidoDao);
//
//		// Deletar(cliente, pedido, em, ClienteDao, pedidoDao);
//	
//		RelatotioClientesFieis(pedidoDao);
//	}
//	
//	
//	private static void RelatotioClientesFieis(PedidoDao pedidoDao) {
//		List<RelatorioClientesFieisVO> relatorio = pedidoDao.relatorioClientesFiesVOs();
//		relatorio.forEach(System.out::println);
//		
//	}
//	
//	
//
//	private static void Deletar(Cliente cliente, Pedido pedido, EntityManager em, ClienteDao ClienteDao,
//			PedidoDao pedidoDao) {
//		// DELETE
//
//		em.getTransaction().begin();// inicio
//
//		ClienteDao.cadastra(cliente);
//		pedidoDao.cadastra(pedido);
//
//		em.remove(pedido);
//		em.remove(cliente);// porque invertendo a odem dos REMOVE ele aparece um update
//
//		em.flush();// ou .commit
//	}
//
//	private static void Editar(Cliente cliente, Pedido pedido, EntityManager em, ClienteDao ClienteDao,
//			PedidoDao pedidoDao) {
//		// +++ EDITAR++++
//		em.getTransaction().begin(); // inicio
//
//		ClienteDao.cadastra(cliente);
//		pedidoDao.cadastra(pedido);
//
//		pedido.setDesconto(new BigDecimal("80.0"));
//		pedido.setTipoDesconto(Descontos.NENHUM);;
//
//		// em.flush();// para sincronizar ao BD sem fazer o comitt
//
//		em.getTransaction().commit();
//		em.close(); // termino
//	}
//
//	private static void Cadastra(Cliente cliente, Pedido pedido, EntityManager em, ClienteDao ClienteDao,
//			PedidoDao pedidoDao) {
//		// +++ CADASTRA +++
//		em.getTransaction().begin();
//		ClienteDao.cadastra(cliente);
//		pedidoDao.cadastra(pedido);
//		em.getTransaction().commit();
//		em.close();
//	}

}
