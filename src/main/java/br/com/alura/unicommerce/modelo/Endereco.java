package br.com.alura.unicommerce.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	 */
	
	@Column(name = "rua", nullable = false, length = 120)
	private String rua;
	
	@Column(name = "numero", length = 10, nullable = false)
	private String numero;
	
	@Column(name = "complemento", nullable = false, length = 150)
	private String complemento;
	
	@Column(name = "bairro", length = 150, nullable = false)
	private String bairro;
	
	@Column(name = "cidade", nullable = false, length = 150)
	private String cidade;
	
	@Column(name = "estado", nullable = false, length = 2)
	private String estado;
	
	public Endereco() {}

	public Endereco(String rua, String numero, String complemento, String bairro, String cidade,
			String estado) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}

}
