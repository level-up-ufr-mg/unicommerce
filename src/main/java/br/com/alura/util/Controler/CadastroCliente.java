package br.com.alura.util.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.util.Domain.Cliente.Cliente;
import br.com.alura.util.Domain.Cliente.ClienteRepositoy;
import br.com.alura.util.Domain.Cliente.DadosCadastroClienteDTO;
import br.com.alura.util.Domain.Cliente.ListaDadosClieteDTO;
import br.com.alura.util.Domain.Usuario.Usuario;
import br.com.alura.util.Domain.Usuario.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class CadastroCliente {

	@Autowired
	private ClienteRepositoy repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

 
	@PostMapping
	   @Transactional
	   public ResponseEntity<String> cadastra(@RequestBody @Valid DadosCadastroClienteDTO dados) {
	       if (dados.cpf().toString().length() == 11 && dados.telefone().toString().length() == 11 && dados != null) {
	           boolean registroCpfExistente = repository.existsByCpf(dados.cpf());

	           if (registroCpfExistente == true) {
	               return ResponseEntity.status(HttpStatus.CONFLICT)
	                       .body("Já existe um registro cadastrado com o CPF informado.");
	           } else {
	              
	               Usuario usuario = new Usuario(dados.usuario().getLogin(), dados.usuario().getSenha());
	               usuarioRepository.save(usuario);
	                
	               Cliente cliente = new Cliente(dados);
	               cliente.setUser_id(usuario);
	               repository.save(cliente);

	               return ResponseEntity.status(HttpStatus.OK).body("Cadastro realizado com sucesso.");
	           }
	       } else {
	           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Por favor, insira os dados corretamente.");
	       }
	   }
	 
	
	
	
	@GetMapping
	public Page<ListaDadosClieteDTO> Lista(@PageableDefault(size = 5, sort = { "nome" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(ListaDadosClieteDTO::new);
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public static void main(String[] args) {
//
//		Endereco endereco = new Endereco("rua x", 100L, "casa", "centro",
//				"São paulo ", "SAO PAULO");
//		
//		Cliente cliente = new Cliente(null, "Rosa", 2156248571524L, 99000101L, endereco);
//
//		EntityManager em = Factory.getEntityManager();
//		ClienteDao ClienteDao = new ClienteDao(em);
//
//		
//		Cadastro(cliente, em, ClienteDao);
//// 
////		Editar(cliente, em);
////	
////		Deletar(cliente, em);
////	
//
//	//	BuscaPorID(ClienteDao);
//
//	//	BuscaTodos(ClienteDao); 
//
//	//	ListaPorNome(ClienteDao);
//
//	}
//
//	private static void BuscaPorID(ClienteDao ClienteDao) {
//		Cliente c = ClienteDao.buscaProID(1L);
//		System.out.print(c.getClienteId() + " - " + c.getNome() + " - " + c.getCpf() + " - " + c.getTipoDesconto());
//	}
//
//	private static void BuscaTodos(ClienteDao ClienteDao) {
//		List<Cliente> buscarTodos = ClienteDao.BuscarTodos();
//		buscarTodos.forEach(c -> System.out.print(c.getClienteId() + " - " + c.getNome() + " - " + c.getCpf() + " - " + c.getTipoDesconto() + "\n \n"));
//	}
//
//	private static void ListaPorNome(ClienteDao clienteDao) {
//		
//		List<Cliente> listaPorNomesClientes = clienteDao.listaPorNomesClientes();
//		listaPorNomesClientes.forEach(c -> System.out.print(c.getClienteId() + " - " + c.getNome() +"\n \n" ) );
//		
//
//	
//	}
//
//	private static void Deletar(Cliente cliente, EntityManager em) {
//		// +++ DELETE +++
//		em.getTransaction().begin();
//
//		em.persist(cliente);// persist
//
//		em.remove(cliente);
//		// ou
//		// ClienteDao.remover(cliente);
//
//		em.flush();// ou .commit
//	}
//
//	private static void Editar(Cliente cliente, EntityManager em) {
//		// +++ EDITAR +++
//		em.getTransaction().begin();// inicio
//
//		em.persist(cliente);// percist
//
//		cliente.setNome("teste");
//
//		em.getTransaction().commit();// para sincronizar ao BD sem fazer o comitt
//
//		em.close(); // termino
//	}
//
//	private static void Cadastro(Cliente cliente, EntityManager em, ClienteDao ClienteDao) {
//		// +++ CADASTRAR +++
//		em.getTransaction().begin();// inicio
//
//		ClienteDao.cadastra(cliente);
//
//		em.getTransaction().commit();
//		em.close();
//	}

}
