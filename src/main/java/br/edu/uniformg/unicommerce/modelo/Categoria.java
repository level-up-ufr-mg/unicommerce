package br.edu.uniformg.unicommerce.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

    private Long id;
    private String nome;
    private Boolean status;

    public Categoria() {
    }

    public Categoria(String nome, boolean status) {
        this.nome = nome;
        this.status = status;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                '}';
    }
}