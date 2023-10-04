package br.com.alura.unicommerce.modelo;

import br.com.alura.unicommerce.record.DadosCadastroCategoria;
import br.com.alura.unicommerce.record.DadosNovaCategoria;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@Column(name = "nome")//anotação usada se o nome da coluna do bd não for o mesmo da entidade 
    private String nome;
    private Boolean status ;
    
//    @OneToMany(mappedBy = "categoria") 
//    private List<Produto> produtos;

   
    public Categoria() {
    }
    
    public Categoria(String nome, Boolean status) {
        this.nome = nome;
        this.status = status;
    }
    
    public Categoria(String nome) {
        this.nome = nome;
    }
    
    //Construtor que recebe a DTO para ser retornada no Controller
    public Categoria(DadosCadastroCategoria dados) {
        this.nome = dados.nome();
        this.status = dados.status();
    }
    

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Boolean getStatus() {
		return status;
	}


	public void setNome(String nome) {
		
    	if(nome.trim().isEmpty() || nome == null) { 
    		throw new IllegalArgumentException("ERRO: Nome da Categoria inválido.");  
    	}
		
		this.nome = nome;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


//	public void setProdutos(List<Produto> produtos) {
//		this.produtos = produtos;
//	}

	
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", status=" + status + "]";
	}
}

