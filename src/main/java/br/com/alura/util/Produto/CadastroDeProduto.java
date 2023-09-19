package br.com.alura.util.Produto;

import java.util.Optional;

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

import br.com.alura.util.Categoria.Categoria;
import br.com.alura.util.Categoria.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RequestMapping(value = "/api/produto")
@RestController
public class CadastroDeProduto {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<String> cadastra(@RequestBody @Valid DadosCadastroProdutoDTO dados) {
		Categoria categoriaId = dados.categoria();
		Long id = categoriaId.getCategoriaId();

		String nomedoProduto = dados.nome();

		boolean nomedoProdutoExiste = repository.existsByNome(nomedoProduto);

		Categoria CategoriaDeProduto = categoriaRepository.getReferenceById(id);
		Optional<Categoria> obj = categoriaRepository.findById(id);

		if (nomedoProdutoExiste == false) {
			if (obj.isPresent()) {
				repository.save(new Produto(dados, CategoriaDeProduto));
				return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com sucesso.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro. Categoria Invalida.");
			}
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Não é  possivel cadastra pedido com esse nome, pois ja existe.");
		}

	}

	@GetMapping
	public Page<ListaDadosProdutoDTO> Lista(@PageableDefault(size = 5, sort = { "nome" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(ListaDadosProdutoDTO::new);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		Categoria categoria = new Categoria(null, "informatica", "ativada");
//		Produto produto = new Produto(null,"computador", "intel", 10L,new BigDecimal("70.00") ,categoria);
//
//		EntityManager em = Factory.getEntityManager();
//		ProdutoDao produtodao = new ProdutoDao(em);
//		CategoriaDao categoriadao = new CategoriaDao(em); 
//
//		Cadastrar(categoria, produto, em, produtodao, categoriadao);
////
////		Editar(categoria, produto, em);
////
////		Delete(categoria, produto, em);
////
////		ListaIndisponiveis(produtodao);
////
////		BuscaporId(produtodao);
////		
//	//BuscarTodos(produtodao);
//		
//	}
//
//	private static void ListaIndisponiveis(ProdutoDao produtoDao) {
//		List<Produto> listaPorNomesClientes = produtoDao.BuscaIndisponives("ATIVADO");// DESATIVADO
//		listaPorNomesClientes.forEach(c -> System.out
//				.print("\n\n ID : " + c.getCategoriaId() + "\n - Nome :  " + c.getNome() + "\n - Descrição : " + c.getDescricao()
//						+ "\n - Quantidade : " + c.getQuantidadeEstoque() + "\n Preco: "+c.getPreco()+"\n Categoria: " + c.getCategoriaId() + "\n\n"));
//
//	}
//
//	private static void BuscarTodos(ProdutoDao produtoDao) {
//		List<Produto>buscarTodos = produtoDao.BuscarTodos();
//		buscarTodos.forEach(c -> System.out
//				.print("\n\n ID : " + c.getCategoriaId() + "\n - Nome :  " + c.getNome() + "\n - Descrição : " + c.getDescricao()
//				+ "\n - Quantidade : " + c.getQuantidadeEstoque() + "\n Preco: "+c.getPreco()+"\n Categoria: " + c.getCategoriaId() + "\n\n"));
//		
//	}
//	
//	private static void BuscaporId(ProdutoDao produtoDao) {
//		Produto c = produtoDao.buscaProID(1L);
//		System.out.print(
//				("\n\n ID : " + c.getCategoriaId() + "\n - Nome :  " + c.getNome() + "\n - Descrição : " + c.getDescricao()
//				+ "\n - Quantidade : " + c.getQuantidadeEstoque() + "\n Preco: "+c.getPreco()+"\n Categoria: " + c.getCategoriaId() + "\n\n"));
//
//	}
//
//	private static void Delete(Categoria categoria, Produto produto, EntityManager em) {
//		// DELETE
//
//		em.getTransaction().begin();// inicio
//
//		em.persist(categoria); // persist
//		em.persist(produto);
//
//		em.remove(produto);// porque invertendo a odem dos REMOVE ele aparece um update
//		em.remove(categoria);
//
//		em.flush();// ou .commit
//	}
//
//	private static void Cadastrar(Categoria categoria, Produto produto, EntityManager em, ProdutoDao produtodao,
//			CategoriaDao categoriadao) {
//		// +++ Cadastra +++
//		em.getTransaction().begin();
//
//		categoriadao.cadastra(categoria);
//		produtodao.cadastra(produto);
//
//		em.getTransaction().commit();
//		em.close();
//	}
//
//	private static void Editar(Categoria categoria, Produto produto, EntityManager em) {
//		// +++ EDITAR++++
//		em.getTransaction().begin(); // inicio
//
//		em.persist(categoria); // percist
//		em.persist(produto);
//
//		categoria.setNome("unifor");
//
//		// em.flush();// para sincronizar ao BD sem fazer o comitt
//
//		em.getTransaction().commit();
//		em.close(); // termino
//	}

}
