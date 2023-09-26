package br.com.alura.util.Domain.Pedido;

import java.math.BigDecimal;
import java.sql.Date;

import br.com.alura.util.Domain.Cliente.Cliente;
import br.com.alura.util.Domain.ItemPedido.ItemPedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPedidosDTO(
		@NotNull
		Long id ,
		@NotBlank
		Date data , 
		@NotBlank
		BigDecimal desconto,
		
		@NotNull
		Cliente cliente,
	
		@NotNull
		ItemPedido itemPedido  ) {

}
