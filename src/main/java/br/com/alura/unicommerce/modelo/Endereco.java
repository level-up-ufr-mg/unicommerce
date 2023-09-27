package br.com.alura.unicommerce.modelo;

import javax.persistence.Embeddable;

import br.com.alura.unicommerce.record.DadosCadastroEndereco;

@Embeddable
public class Endereco {
	
	private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    
    public Endereco() {
    	
    }
    
    //Construtor com a record de Endereco
    public Endereco(DadosCadastroEndereco dados) {
    	this.rua = dados.rua();
    	this.numero = String.valueOf(dados.numero());
    	this.complemento = dados.complemento();
    	this.bairro = dados.bairro(); 
    	this.cidade = dados.cidade();
    	this.estado = dados.estado();
    }
    
    public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String estado) {
		super();
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

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
