package br.com.alura.unicommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.Domain.Produto.Produto;
import br.com.alura.unicommerce.Domain.Repository.ProdutoRepository;
import br.com.alura.unicommerce.Infra.Exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Optional<Produto> buscaPorId(Long produtoId) {
		Optional<Produto> obj = repository.findById(produtoId);
		Produto entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return Optional.ofNullable(entity);
	}

}