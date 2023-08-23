package br.edu.uniformg.unicommerce.modelo;

import javax.persistence.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

public class Endereco {
	
    private Long id;
	private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    
    public Endereco() {
    	
    }

	public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
