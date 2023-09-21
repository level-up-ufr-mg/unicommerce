package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO{
		
	private Long id;
	
	@NotBlank
    private String nome;
    
	@NotBlank
    private String cpf;
    
    private String telefone;
	
    @NotNull @Valid 
    private EnderecoDTO endereco;

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
		this.endereco = new EnderecoDTO(obj.getEndereco());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}
}
