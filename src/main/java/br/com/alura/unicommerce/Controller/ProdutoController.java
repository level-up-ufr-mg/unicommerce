package br.com.alura.unicommerce.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.unicommerce.DTO.DadosCadastroProduto;
import br.com.alura.unicommerce.DTO.DadosListagemProduto;
import br.com.alura.unicommerce.Domain.Categoria.Categoria;
import br.com.alura.unicommerce.Domain.Produto.Produto;
import br.com.alura.unicommerce.Domain.Repository.CategoriaRepository;
import br.com.alura.unicommerce.Domain.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastroProduto dados, BindingResult result,
			UriComponentsBuilder uriBuilder) {

		if (result.hasErrors())
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

		Categoria categoriaId = dados.categoria();
		Long categoriaIDLong = categoriaId.getId();
		Categoria dadosIDCategoria = categoriaRepository.getReferenceById(categoriaIDLong);
		Optional<Categoria> obj = categoriaRepository.findById(categoriaIDLong);
		if (!obj.isEmpty()) {
			Produto produto = new Produto(dados, dadosIDCategoria);
			repository.save(produto);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public Page<DadosListagemProduto> listar(@PageableDefault(size = 5, sort = { "nome" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemProduto::new);
	}
}