package br.com.alura.unicommerce.Controller;

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

import br.com.alura.unicommerce.DTO.DadosCadastraCategoria;
import br.com.alura.unicommerce.Domain.Categoria.Categoria;
import br.com.alura.unicommerce.Domain.Repository.CategoriaRepository;
import br.com.alura.unicommerce.vo.RelatorioVendasPorCategoriaVo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastraCategoria dados, BindingResult result) {

		if (result.hasErrors())
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		repository.save(new Categoria(dados));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/vendas")
	public ResponseEntity<Page<RelatorioVendasPorCategoriaVo>> relatorioVendasCategoria(Pageable paginacao) {
		return ResponseEntity.ok(repository.getRelatorioVendasPorCategoria(paginacao));
	}
}