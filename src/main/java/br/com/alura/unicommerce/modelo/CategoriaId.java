//package br.com.alura.unicommerce.modelo;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//
//@Embeddable
//public class CategoriaId implements Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Column(name = "nome", nullable = false, length = 50, unique = true)
//	private String nome;
//
//	@Column(nullable = false, length = 20, unique = true)
//	private boolean status;
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public boolean isStatus() {
//		return status;
//	}
//
//	public void setStatus(boolean status) {
//		this.status = status;
//	}
//
//}
