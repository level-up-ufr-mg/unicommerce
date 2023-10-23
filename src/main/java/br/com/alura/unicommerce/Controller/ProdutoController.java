package br.com.alura.unicommerce.controller;

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

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.dto.DadosCadastraProduto;
import br.com.alura.unicommerce.dto.DadosListagemProduto;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.repository.CategoriaRepository;
import br.com.alura.unicommerce.repository.ProdutoRepository;
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
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastraProduto dados, BindingResult result) {

		if (result.hasErrors())
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

		Categoria categoriaId = dados.categoria();
		Long idCategoria = categoriaId.getId();
		Categoria dadosIdCategoria = categoriaRepository.getReferenceById(idCategoria);
		Optional<Categoria> obj = categoriaRepository.findById(idCategoria);
		if (!obj.isEmpty()) {
			repository.save(new Produto(dados, dadosIdCategoria));
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public Page<DadosListagemProduto> listar(@PageableDefault(size = 5, sort = { "nome" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemProduto::new);
	}
}