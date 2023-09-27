package br.com.alura.util.Domain.Pedido;

import java.util.Date;

import br.com.alura.util.Domain.Cliente.Cliente;
import br.com.alura.util.Domain.Endereco.Descontos;

public record DadosCadastroPedidosDTO(
		
		Date data,
		
		Descontos descontos,
		
		Cliente cliente
		
		) {

}
