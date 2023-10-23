package br.com.alura.unicommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.vo.RelatorioClientesFiesVo;
import jakarta.validation.constraints.NotNull;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	public List<RelatorioClientesFiesVo> getRelatorioClienteFieis(List<Pedido> listaDePedidos) {

		List<RelatorioClientesFiesVo> relatorioClientesFieis = new ArrayList<>();

		listaDePedidos.forEach(pedido -> {
			relatorioClientesFieis
					.add(new RelatorioClientesFiesVo(pedido.getCliente().getNome(), 1L, pedido.getValorTotal()));
		});

		return relatorioClientesFieis;
	}

	public Optional<Cliente> buscaPorId(@NotNull Long clienteId) {

		Cliente cliente = clienteDao.buscaPorId(clienteId);
		return Optional.ofNullable(cliente);
	}
}