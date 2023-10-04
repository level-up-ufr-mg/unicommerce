package br.com.alura.unicommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Produto;
import jakarta.validation.constraints.NotNull;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoDao produtoDao;
	
	public Optional<Produto> buscaPorId(@NotNull Long id) {
		
		Produto produto = produtoDao.buscaPorId(id);
		
		return Optional.ofNullable(produto);
	}

}
