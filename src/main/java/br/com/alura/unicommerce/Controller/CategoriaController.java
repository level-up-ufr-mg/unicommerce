package br.com.alura.unicommerce.Controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.unicommerce.DTO.DadosCadastraCategoria;
import br.com.alura.unicommerce.DTO.DadosDetalhamentoCategoria;
import br.com.alura.unicommerce.Domain.Categoria.Categoria;
import br.com.alura.unicommerce.Domain.Repository.CategoriaRepository;
import br.com.alura.unicommerce.service.CategoriaService;
import br.com.alura.unicommerce.vo.RelatorioDeVendasPorCategoriaVo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@Autowired
	private CategoriaService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastraCategoria dados, BindingResult result,
			UriComponentsBuilder uriBuilder) {

		if (result.hasErrors())
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		Categoria categoria = new Categoria(dados);

		service.cadastra(categoria);

		URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(categoria.getId()).toUri();

		return ResponseEntity.created(uri).body(new DadosDetalhamentoCategoria(categoria));
	}

	@GetMapping("/vendas")
	public ResponseEntity<Page<RelatorioDeVendasPorCategoriaVo>> relatorioDeVendasPorCategoria(Pageable paginacao) {
		return ResponseEntity.ok(repository.getRelatorioVendasPorCategoria(paginacao));
	}

}