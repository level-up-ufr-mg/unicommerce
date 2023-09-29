package br.com.alura.util.domain.pedido;

import java.util.Date;

import br.com.alura.util.domain.cliente.Cliente;
import br.com.alura.util.domain.endereco.Descontos;

public record DadosCadastroPedidosDTO(
		
		Date data,
		
		Descontos descontos,
		
		Cliente cliente
		
		) {

}
