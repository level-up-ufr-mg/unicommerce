package br.com.alura.unicommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.dto.DadosListagemCliente;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.repository.ClienteRepository;
import br.com.alura.unicommerce.service.exceptions.DatabaseException;
import br.com.alura.unicommerce.service.exceptions.ResourceNotFoundException;
import br.com.alura.unicommerce.vo.RelatorioDeVendasClienteVo;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	public List<RelatorioDeVendasClienteVo> getRelatorioClientesFieis(List<Pedido> pedidos) {

		List<RelatorioDeVendasClienteVo> relatorioClientesFieis = new ArrayList<>();

		pedidos.forEach(pedido -> {
			relatorioClientesFieis
					.add(new RelatorioDeVendasClienteVo(pedido.getCliente().getNome(), 1L, pedido.getValorTotal()));
		});

		return relatorioClientesFieis;
	}

	@Autowired
	private ClienteRepository repository;

	
	public Optional<Cliente> buscaPorId(Long clienteId) {
		Optional<Cliente> resultCliente = repository.findById(clienteId); // return Optional
		Cliente cliente = resultCliente.get(); // return Cliente
		return Optional.ofNullable(cliente);

	}

	@Transactional(readOnly = true)
	public Page<DadosListagemCliente> findAllPaged(PageRequest pageRequest) {
		Page<Cliente> list = repository.findAll(pageRequest);
		return list.map(x -> new DadosListagemCliente(x));
	}

	public void inserirCliente(Cliente cliente) {
		repository.save(cliente);
	}

	public Cliente update(Long clienteId, Cliente cliente) {
		try {
			Cliente entity = repository.getReferenceById(clienteId);
			entity = repository.save(cliente);
			return cliente;
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + clienteId);
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
