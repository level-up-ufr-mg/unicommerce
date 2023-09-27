package br.com.alura.util.Domain.Pedido;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.util.Domain.Cliente.Cliente;
import br.com.alura.util.Domain.Endereco.Descontos;
import br.com.alura.util.Domain.ItemPedido.ItemPedido;
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
import jakarta.persistence.Table;
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
	private Long pedidoId;

	@Column(nullable = false)
	private Date data;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal desconto;

	@Enumerated(EnumType.STRING)
	private Descontos tipoDesconto;

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
 
 
	
 


 
	
	
}
