package br.com.alura.unicommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.unicommerce.dto.ProdutoDTO;
import br.com.alura.unicommerce.form.ProdutoForm;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.repository.CategoriaRepository;
import br.com.alura.unicommerce.repository.ProdutoRepository;
import br.com.alura.unicommerce.service.exceptions.DatabaseException;
import br.com.alura.unicommerce.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Page<ProdutoDTO> findAllPaged(PageRequest pageRequest) {
		Page<Produto> list = repository.findAll(pageRequest);
		return list.map(x -> new ProdutoDTO(x));
	}

	public Optional<Produto> findById(Long produtoId) {
		Optional<Produto> obj = repository.findById(produtoId);
		Produto entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return Optional.ofNullable(entity);
	}

	public void insert(Produto produto) {
		if (produto == null) throw new IllegalArgumentException("Falha ao cadastrar cadastrar o produto.");
	        repository.save(produto);	
	}

	public ProdutoForm update(Long produtoId, ProdutoForm form) {
		try {
			Produto entity = repository.getReferenceById(produtoId);
			copyDtoToEntity(form, entity);
			entity = repository.save(entity);
			return new ProdutoForm();
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + produtoId);
		}
	}

	public void delete(Long produtoId) {
		try {
			repository.deleteById(produtoId);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + produtoId);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(ProdutoForm form, Produto entity) {
		
		entity.setNome(form.getNome());
		entity.setDescricao(form.getDescricao());
		entity.setQuantidadeEstoque(form.getQuantidadeEstoque());
		entity.setPreco(form.getPreco());
		
//		entity.getCategoria().clear();
//		for (CategoriaDTO catDto : dto.getCategoria()) {
//			Categoria categoria = categoriaRepository.getReferenceById(catDto.getId());
//			entity.getCategoria().add(categoria);
//		}
	}

}
