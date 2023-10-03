package br.com.alura.util.domain.itemPedido;

import java.math.BigDecimal;

import br.com.alura.util.domain.endereco.Descontos;
import br.com.alura.util.domain.pedido.Pedido;
import br.com.alura.util.domain.produto.Produto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "unicommerce", name = "item_pedido")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"itemPedidoId"})
@Getter
@Setter
@ToString
public class ItemPedido  {

	
	public ItemPedido(Pedido pedido, Produto produtoDePedido) {
	}


	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemPedidoId;
	
	
	@Column(name = "PRECO_UNITARIO", precision = 10, scale = 2, nullable = false)
	private BigDecimal precoUnitario;
	
	
	@Column(nullable = false)
	private Long quantidade;
	
	@Column(name = "TIPO_DESCONTO", length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Descontos tipoDesconto;
	
	
	@Column(precision = 10, scale = 2,name = "DESCONTO")
	private BigDecimal desconto;
	
	
	// ==================== Variaveis de Relacionamento================
	
	@ManyToOne // fetch = FetchType.LAZY
	@JoinColumn(name = "PEDIDO_ID")
	private Pedido pedidoId;
	
	
	
	
	@ManyToOne // fetch = FetchType.LAZY
	@JoinColumn(name = "PRODUTO_ID")
	private Produto produtoId;
	
	
	
	// ==================== Variaveis de Relacionamento================
	
	
	
	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
