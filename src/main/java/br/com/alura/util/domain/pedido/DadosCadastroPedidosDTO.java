package br.com.alura.util.domain.pedido;

import java.math.BigDecimal;
import java.util.Date;

import br.com.alura.util.domain.cliente.Cliente;
import br.com.alura.util.domain.endereco.Descontos;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPedidosDTO(
		
		
		@NotNull
		BigDecimal desconto,
		
		 BigDecimal valorTotal,
			
		@NotNull
		Descontos tipoDesconto,
		
		@Valid
		@NonNull
		Cliente cliente
		
		) {

}
