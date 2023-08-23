package br.edu.uniformg.unicommerce.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

    private Long id;
    private LocalDate data;
    private Double desconto;
    private String tipoDesconto; 
    //FK
    private String clienteId;

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

    @ManyToOne
    @JoinColumn(name = "cliente_id")
	public String getCliente() {
		return clienteId;
	}

	public double getDesconto() {
		return desconto;
	}

    @Enumerated(EnumType.STRING)
	public String getTipoDesconto() {
		return tipoDesconto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", desconto=" + desconto + ", cliente=" + clienteId + "]";
	}
}

