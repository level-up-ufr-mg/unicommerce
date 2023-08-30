package br.com.alura.unicommerce.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id")
	private Pedido pedidoId;

	@ManyToOne
	@JoinColumn(name = "id")
	private Produto produtoId;

	@Column(name = "preco_unitario")
	private Double precoUnitario;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "desconto")
	private Double desconto;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_desconto")
	private TipoDesconto tipoDesconto;

	// Construtores, getters e setters

	// Enum para o tipo de desconto
	public enum TipoDesconto {
		QUANTIDADE, PROMOCAO, NENHUM
	}
}
