package br.com.alura.util.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.util.domain.categoria.Categoria;
import br.com.alura.util.domain.produto.DadosCadastroProdutoDTO;
import br.com.alura.util.domain.produto.ListaDadosProdutoDTO;
import br.com.alura.util.domain.produto.Produto;
import br.com.alura.util.repository.CategoriaRepository;
import br.com.alura.util.repository.ProdutoRepository;
import jakarta.validation.Valid;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@Transactional
	public ResponseEntity<String> cadastra(@Valid DadosCadastroProdutoDTO dados) {
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


	public Page<ListaDadosProdutoDTO> listar(Pageable paginacao) {
		return repository.findAll(paginacao).map(ListaDadosProdutoDTO::new);
	}

	
	
	
	
	
}
