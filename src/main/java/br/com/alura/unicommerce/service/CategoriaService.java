package br.com.alura.unicommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.dto.DadosCadastraCategoria;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.repository.CategoriaRepository;
import jakarta.validation.Valid;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	public void cadastra(@Valid Categoria categoria) {
		
		repository.save(categoria);
		
	}

}
