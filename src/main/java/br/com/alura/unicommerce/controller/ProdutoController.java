package br.com.alura.unicommerce.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.unicommerce.dto.DadosListagemProduto;
import br.com.alura.unicommerce.dto.ProdutoDTO;
import br.com.alura.unicommerce.form.ProdutoForm;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.service.CategoriaService;
import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,					
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
			) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<ProdutoDTO> list = service.findAllPaged(pageRequest);
		
		return ResponseEntity.ok().body(list);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<Produto> prouduto = service.findById(id);
		return ResponseEntity.ok().body(prouduto);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Object> insertProduto(@RequestBody @Valid ProdutoForm form,
												UriComponentsBuilder uriBuilder,
												BindingResult result ){
		
		try {
			if(result.hasErrors()) 
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			Produto novo = form.converter(categoriaService);
			service.insert(novo);			
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(form).toUri();
			return ResponseEntity.created(uri).body(form);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu uma falha no cadastro do produto");
		}
		
	}
	
	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Object> update(@PathVariable Long ProdutoId, @RequestBody ProdutoForm form){
		service.update(ProdutoId, form);
		return ResponseEntity.ok().body(form);
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<ProdutoDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}


}
