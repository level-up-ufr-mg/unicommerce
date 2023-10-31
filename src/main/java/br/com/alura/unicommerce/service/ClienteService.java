
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

import br.com.alura.unicommerce.DTO.DadosCadastraCliente;
import br.com.alura.unicommerce.DTO.DadosListagemCliente;
import br.com.alura.unicommerce.Domain.Cliente.Cliente;
import br.com.alura.unicommerce.Domain.Pedido.Pedido;
import br.com.alura.unicommerce.Domain.Repository.ClienteRepository;
import br.com.alura.unicommerce.Infra.Exceptions.DatabaseException;
import br.com.alura.unicommerce.Infra.Exceptions.ResourceNotFoundException;
import br.com.alura.unicommerce.vo.RelatorioClientesFiesVo;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	public List<RelatorioClientesFiesVo> getRelatorioClientesFieis(List<Pedido> pedidos) {

		List<RelatorioClientesFiesVo> relatorioClientesFieis = new ArrayList<>();

		pedidos.forEach(pedido -> {
			relatorioClientesFieis
					.add(new RelatorioClientesFiesVo(pedido.getCliente().getNome(), 1L, pedido.getValorTotal()));
		});

		return relatorioClientesFieis;
	}

	@Autowired
	private ClienteRepository repository;

	public Optional<Cliente> buscaPorId(Long clienteId) {
		Optional<Cliente> resultCliente = repository.findById(clienteId);
		Cliente cliente = resultCliente.get();
		return Optional.ofNullable(cliente);

	}

	@Transactional(readOnly = true)
	public Page<DadosListagemCliente> findAllPaged(PageRequest pageRequest) {
		Page<Cliente> list = repository.findAll(pageRequest);
		return list.map(p -> new DadosListagemCliente(p));
	}

	public void inserirCliente(Cliente cliente) {

		// System.out.println(cliente);

		if (cliente == null)
			throw new IllegalArgumentException("Falha ao cadastrar cadastrar o cliente.");
		repository.save(cliente);
	}

	public DadosCadastraCliente update(Long clienteId, DadosCadastraCliente cliente) {
		try {
			Cliente entity = repository.getReferenceById(clienteId);
			entity = repository.save(new Cliente(cliente));
			return new DadosCadastraCliente(entity);
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

//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import br.com.alura.unicommerce.Domain.Cliente;
//import br.com.alura.unicommerce.Domain.Pedido;
//import br.com.alura.unicommerce.dao.ClienteDao;
//import br.com.alura.unicommerce.vo.RelatorioClientesFiesVo;
//import jakarta.validation.constraints.NotNull;
//
//@Service
//public class ClienteService {
//
//	@Autowired
//	private ClienteDao clienteDao;
//
//	public List<RelatorioClientesFiesVo> getRelatorioClienteFieis(List<Pedido> listaDePedidos) {
//
//		List<RelatorioClientesFiesVo> relatorioClientesFieis = new ArrayList<>();
//
//		listaDePedidos.forEach(pedido -> {
//			relatorioClientesFieis
//					.add(new RelatorioClientesFiesVo(pedido.getCliente().getNome(), 1L, pedido.getValorTotal()));
//		});
//
//		return relatorioClientesFieis;
//	}
//
//	public Optional<Cliente> buscaPorId(@NotNull Long clienteId) {
//
//		Cliente cliente = clienteDao.buscaPorId(clienteId);
//		return Optional.ofNullable(cliente);
//	}
//}