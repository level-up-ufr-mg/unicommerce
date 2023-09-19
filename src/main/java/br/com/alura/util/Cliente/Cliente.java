package br.com.alura.util.Cliente;

import java.io.Serializable;

import br.com.alura.util.Endereco.Endereco;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "unicommerce", name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"clienteId"})
@Getter
@Setter
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false)
	private Long clienteId;
	
	@Column(name ="nome",nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Long cpf;
	
	@Column(nullable = false)
	private Long telefone;
	
	@Embedded
	private Endereco endereco;

	

	public Cliente(@Valid DadosCadastroClienteDTO dados) {
	this.nome = dados.nome();
	this.telefone =dados.telefone();
	this.cpf= dados.cpf();
	
	this.endereco = new Endereco(dados.endereco());
	}



	@Override
	public String toString() {
		return "ClienteEntity [clienteId=" + clienteId + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone
				+ ", endereco=" + endereco + "]";
	}
	

	
}
