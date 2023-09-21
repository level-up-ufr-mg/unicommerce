package br.com.alura.unicommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	public Optional<Produto> buscaPorId(Long produtoId){
		return repository.findById(produtoId);
	}
	
	

}
