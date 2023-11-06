package br.com.alura.unicommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.Domain.Pedido.Pedido;
import br.com.alura.unicommerce.Domain.Repository.PedidoRepository;
import br.com.alura.unicommerce.Infra.Exceptions.DatabaseException;
import br.com.alura.unicommerce.Infra.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public Optional<Pedido> buscaPorId(Long clienteId) {
		Optional<Pedido> resultPedido = repository.findById(clienteId);
		Pedido pedido = resultPedido.get();
		return Optional.ofNullable(pedido);

	}

	public void insert(Pedido pedido) {

		System.out.println(pedido);

		if (pedido == null)
			throw new IllegalArgumentException("Falha ao cadastrar o pedido.");
		repository.save(pedido);
	}

	public Pedido update(Long pedidoId, Pedido pedido) {
		try {
			Pedido entity = repository.getReferenceById(pedidoId);
			entity = repository.save(pedido);
			return pedido;
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + pedidoId);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

}
