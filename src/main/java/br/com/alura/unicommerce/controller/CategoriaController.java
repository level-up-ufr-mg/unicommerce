package br.com.alura.unicommerce.controller;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.modelo.Categoria;

public class CategoriaController {
	
	
	public void criaCategoria(Categoria categoria) {
		
		
		CategoriaDao categoriaDao = new CategoriaDao(null);
		categoriaDao.cadastra(categoria);
		
		
	}

}
