package br.com.alura.util.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.util.domain.categoria.Categoria;
import br.com.alura.util.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional
	public void cadastra(Categoria categoria) throws Exception {
		if (categoria == null) {
			throw new Exception("Cadastro inválido para objeto nulo");

		} if (categoriaRepository.existsByNome(categoria.getNome())) {
			throw new Exception("Erro. Nome de categoria ja cadastrado.");
		}

		categoriaRepository.save(categoria);
	}

	public Optional<Categoria> buscaPorId(Long categoriaId) throws Exception {

		if (categoriaId == null)
			throw new Exception("Falha ao carregar categoria, id inválido");

		return categoriaRepository.findById(categoriaId);
	}

	public Optional<List<Categoria>> listaTodas() {
		return Optional.ofNullable(categoriaRepository.findAll());
	}

}
