package br.com.alura.unicommerce.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //anotação que indica que a classe é uma entidade
@Table(name = "categoria") //anotação usada se o nome da tabela do bd não for o mesmo da entidade 
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@Column(name = "nome")//anotação usada se o nome da coluna do bd não for o mesmo da entidade 
    private String nome;
    private Boolean status ;

   
    public Categoria() {
    }
    
    public Categoria(String nome) throws IllegalArgumentException {
    	this.setNome(nome);
    	
    }
    
    public Categoria(String nome, Boolean status) {
        this.nome = nome;
        this.status = status;
    }
  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
    	if (nome == null ) {
            throw new IllegalArgumentException("Nome inválido, o nome da categoria não pode ser nula.");
         }
    	
    	if (nome.isEmpty() ) {
            throw new IllegalArgumentException("Nome inválido, o nome da categoria não pode ser vazio.");
         }
    	
        this.nome = nome;
    }
    
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
   
}

