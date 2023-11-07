package br.com.alura.unicommerce.Domain.Usuario;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;

import br.com.alura.unicommerce.DTO.DadosCadastraUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Usuarios")
@Entity(name = "Usuario")
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String login;
	private String senha;
    
    public Usuario() {
	}
    
    public Usuario(DadosCadastraUsuario dados) {
    	this.login = dados.login();
    	this.senha = dados.senha();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}

	public void setUsername(String login) {
		this.login = login;
	}

	public void setPassword(String senha) {
		this.senha = BCrypt.hashpw(senha, BCrypt.gensalt());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	public Long getId() {
		return ID;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
