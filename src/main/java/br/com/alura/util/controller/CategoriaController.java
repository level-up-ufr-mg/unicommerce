package br.com.alura.util.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.util.domain.categoria.AtualizarDadosCategoriaDTO;
import br.com.alura.util.domain.categoria.Categoria;
import br.com.alura.util.domain.categoria.DadosCadastroCategoriaDTO;
import br.com.alura.util.domain.categoria.DadosCategoria;
import br.com.alura.util.domain.categoria.DadosMensagem;
import br.com.alura.util.domain.categoria.ListaDadosCategoriaDTO;
import br.com.alura.util.repository.CategoriaRepository;
import br.com.alura.util.service.CategoriaService;
import br.com.alura.util.service.relatorio.RelatorideVendasPorCategoriaVO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RequestMapping(value = "/api/categoria")
@RestController
@SecurityRequirement(name = "bearer-key")
public class CategoriaController {
 
	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private CategoriaService service;

	@PostMapping 
	@Transactional
	public ResponseEntity<String> cadastra(@RequestBody @Valid DadosCadastroCategoriaDTO dados) {
		String nomeUnico = dados.nome();
		if (repository.existsByNome(nomeUnico)) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Não é possivel inserir pois essa categoria ja existe ! ");
		}
		repository.save(new Categoria(dados));
		return ResponseEntity.status(HttpStatus.CREATED).body("Categoria criada com sucesso.");
	}

	
//	 @PostMapping
//	    @Transactional
//	    public ResponseEntity<DadosCategoria> criaNovaCategoria(@RequestBody @Valid DadosCadastroCategoriaDTO form,
//	                                                    UriComponentsBuilder uriBuilder, BindingResult result) throws Exception {
//	    	
//	        if(result.hasFieldErrors())
//	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//
//	        Categoria novaCategoria = form.toEntity();
//	        service.cadastra(novaCategoria);
//
//	        URI uri = uriBuilder.path("/api/categorias/{id}").buildAndExpand(novaCategoria.getId()).toUri();
//	        return ResponseEntity.created(uri).body(new DadosCategoria(novaCategoria));
//	    }
	
	@GetMapping
	public ResponseEntity<Page<ListaDadosCategoriaDTO>> lista(@PageableDefault(size = 5, sort = { "nome" }) Pageable paginacao) {
		Page<Categoria> categorias = repository.findAll(paginacao);
		if (categorias.isEmpty()) {
			return ResponseEntity.noContent().header("Nenhuma Categoria Cadastrada.").build();
		} else {
			return ResponseEntity.ok(categorias.map(ListaDadosCategoriaDTO::new));
		}
	}

	
	   @GetMapping("/{id}")
	    public ResponseEntity<Object> obtemCategoriaPorId(@PathVariable("id") Long idCategoria) throws Exception{
	        if(idCategoria == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DadosMensagem("Id para buscar categoria inválido"));
	        
	        Optional<Categoria> encontrada = service.buscaPorId(idCategoria);
	        
	        if(encontrada.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new DadosMensagem("Categoria não encontrada"));

	        return ResponseEntity.status(HttpStatus.OK).body(new DadosCategoria(encontrada.get()));
	    }
	
	
	@PutMapping
	@Transactional
	public ResponseEntity<String> atualizarCadastro(@RequestBody @Valid AtualizarDadosCategoriaDTO dados) {
		Optional<Categoria> optionalCategoria = repository.findById(dados.id());
	
		if (optionalCategoria.isPresent()) {
			Categoria categoria = optionalCategoria.get();

			if (dados.nome() != null && !dados.nome().isEmpty() /* && dados != null */)  {// verifica se o campo nome esta null ou vazio
				String novoNome = dados.nome();

				if (!categoria.getNome().equals(novoNome)) { // verifica de o novo nome inserido em dadso ja esta em
																// cadastrado na tabela Categoria. se o novo erro
																// estiver cadsatrado ele acusa erro
					
					if (repository.existsByNome(novoNome)) {
						return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro. O novo nome já está em uso.");
					} else {
						categoria.setNome(novoNome);
					}
				}
			}

			if (dados.status() != null && categoria.getStatus() != dados.status()) {
	            boolean novoStatus = dados.status();
	            categoria.setStatus(novoStatus);
	        }
			repository.save(categoria);
			return ResponseEntity.ok("Categoria Editada com sucesso.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
		}
		//o motivo do teste ter ficado grande foi porque no meu banco na colula nome eu coloquei Unique 
	}


	@GetMapping("/vendas")
	public ResponseEntity<Page<RelatorideVendasPorCategoriaVO>> relatorioVendasPorCategoria(Pageable pageable) {
		Page<Categoria> categorias = repository.findAll(pageable);
		if (categorias.isEmpty()) {
			return ResponseEntity.noContent().header("Não existem dados para gera relatorio.").build();
		} else {
			return ResponseEntity.ok(repository.getRelatorioVendasPorCategoria(pageable));
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> DeletarMedico(@PathVariable("id") Long id) {
		repository.deleteById(id);
		Optional<Categoria> obj = repository.findById(id);
		
		if (obj.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Registro deletaco com sucesso.");
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Falha em deletar registro.");
		}
	}

//	public static void main(String[] args) {
//		Categoria celulares = new Categoria(null, "teste", "aaaaaaaa"); // transit
//
//		EntityManager em = Factory.getEntityManager();
//		CategoriaDao categoriaDao = new CategoriaDao(em);
//
//		Cadastra(celulares, em); 
////
////		Editar(celulares, em);
////
////		Delete(celulares, em, categoriaDao); 
////		
////		
//	//	buscaPorID(categoriaDao);
//	 
//		
//	//	BuscarTodos(categoriaDao);
//		
//	//	ListaporNome(categoriaDao); 
//
//	}
//
//	private static void buscaPorID(CategoriaDao categoriaDao) {
//		Categoria c = categoriaDao.buscaProID(1L);
//		System.out.print(c.getID()+" - "+c.getNome()+" - "+ c.getStatus()+" \n \n ");
//	}
//	
//	
//	private static void  BuscarTodos(CategoriaDao categoriaDao) {
//		 List<Categoria> buscarTodos = categoriaDao.BuscarTodos();
//		 buscarTodos.forEach(c -> System.out.print(c.getID()+" - "+c.getNome()+" - "+ c.getStatus()+" \n \n ") );
//	}	
//	
//	private static void ListaporNome(CategoriaDao categoriaDao) {
//		List<Categoria> listaporNome = categoriaDao.listaPorNomesClientes();
//		listaporNome.forEach(c -> System.out.print(c.getID()+" - "+c.getNome()+" \n\n"));
//		
//	}
//	
//	private static void Delete(Categoria celulares, EntityManager em, CategoriaDao categoriaDao) {
//		em.getTransaction().begin();// inicio
//
//		em.persist(celulares);// a entidade oi reconhecida
//
//		// ===============================================
//		categoriaDao.remover(celulares);
//		// OU
//		// em.remove(celulares);// reuisição ao banco de dados
//		// ===============================================
//
//		em.flush();// ou .commit() // para enviar ao banco de dados
//	}
//
//	private static void Editar(Categoria celulares, EntityManager em) {
//		em.getTransaction().begin(); // inicio
//
//		em.persist(celulares);// a entidade oi reconhecida
//
//		celulares.setNome("test");
//
//		// em.flush();// ou .commit() // para enviar ao banco de dados
//
//		em.getTransaction().commit();
//		em.close(); // termino
//	}
//
//	private static void Cadastra(Categoria celulares, EntityManager em) {
//		// +++ CADASTRA ++
//		CategoriaDao categoriaDao = new CategoriaDao(em);
//
//		em.getTransaction().begin(); // iniio
//
//		categoriaDao.cadastra(celulares); // chama o metodo cadastrar onde esta o parametro percist
//
//		em.getTransaction().commit();
//
//		em.close(); // termino
//	}
}
