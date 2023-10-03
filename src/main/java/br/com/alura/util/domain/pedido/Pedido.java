package br.com.alura.util.domain.pedido;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.util.domain.cliente.Cliente;
import br.com.alura.util.domain.endereco.Descontos;
import br.com.alura.util.domain.itemPedido.ItemPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "unicommerce", name = "pedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = { "pedidoId" })
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long pedidoId;

	@Column(nullable = false,name = "DATA")
	private LocalDate data = LocalDate.now();

	@Column(nullable = false, precision = 10, scale = 2,name = "DESCONTO_ID")
	private BigDecimal desconto;

	@Enumerated(EnumType.STRING)
	private Descontos tipoDesconto;
	
	@Column(name = "VALOR_TOTAL")
	private BigDecimal valorTotal = BigDecimal.ZERO;

	// ==================== Variaveis de Relacionamento================
	@ManyToOne
	@JoinColumn(name = "clienteId") 
	private Cliente cliente;

	@OneToMany(mappedBy = "pedidoId", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	// ==================== Variaveis de Relacionamento================


	public void adicionarItem(ItemPedido itemPedido) {
		itemPedido.setPedidoId(this);
		this.itens.add(itemPedido);
		this.valorTotal = this.valorTotal.add(itemPedido.getPrecoUnitario());
	}


	public Pedido(@Valid DadosCadastroPedidosDTO dados, Cliente entidadeCliente) {

		this.desconto= dados.desconto();
		this.tipoDesconto =dados.tipoDesconto(); 
		this.valorTotal = dados.valorTotal();
		
		this.cliente = entidadeCliente;
		
		
	}
 
  
	
	
}
