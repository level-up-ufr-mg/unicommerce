package br.com.alura.unicommerce.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.record.DadosCadastroCategoria;
import br.com.alura.unicommerce.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired //para que o Spring inicialize
	private CategoriaRepository repository;
	
	@GetMapping ("helloWorld")
	public String olaMundo() {
		return "Hello World"; //response
	}
	
	@PostMapping("/testeImpressao")
	public void cadastrar(@RequestBody String json) { //@RequestBody: para puxar esse parâmetro do corpo da requisição
		System.out.println("O que está chegando como parâmetro para o método cadastrar: " + json);
	}

	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroCategoria dados) { //DadosCadastroCategoria é a record (DTO)
		System.out.println(dados);
		repository.save(new Categoria(dados));
	}
	
//	publicResponseEntity<CategoriaDao> findCategoriaBy(Long id){
//		Categoria categoria = categoriaDao.getClass();
//		
//	}
	
}
