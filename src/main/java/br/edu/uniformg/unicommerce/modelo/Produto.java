package br.edu.uniformg.unicommerce.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private Integer quantidadeEstoque;
    
    //FK
    private Long categoriaId;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Integer quantidadeEstoque, Long categoriaId) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoriaId = categoriaId;
	}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	@ManyToOne
    @JoinColumn(name = "categoria_id")
	public Long getCategoria_id() {
		return categoriaId;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public void setCategoria_id(Long categoria_id) {
		this.categoriaId = categoria_id;
	}

	@Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", categoria=" + categoriaId +
                '}';
    }
}



