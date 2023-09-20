package br.com.alura.unicommerce.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.record.DadosCadastroProduto;
import br.com.alura.unicommerce.repository.CategoriaRepository;
import br.com.alura.unicommerce.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid DadosCadastroProduto dados, BindingResult result){

		if(result.hasErrors()) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		Categoria categoria = dados.categoria();
		Long categoriId = categoria.getId();
		
		Categoria dadosIdCategoria = categoriaRepository.getReferenceById(categoriId);
		
		Optional<Categoria> obj = categoriaRepository.findById(categoriId);
		
		if(!obj.isEmpty()) {
			repository.save(new Produto(dados, dadosIdCategoria));
		}
		
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	
	
	
	
	
//	private void cadastrar(@RequestBody @Valid DadosCadastroProduto dados) { //cadastra com os dados da record (DTO)
//		
//		repository.save(new Produto(dados)); //Produto deve ter um construtor que receba o DTO para ser persistido.
//	}

}

