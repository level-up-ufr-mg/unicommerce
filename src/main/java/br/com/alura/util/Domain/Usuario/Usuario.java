package br.com.alura.util.Domain.Usuario;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.alura.util.Domain.Cliente.Cliente;
import br.com.alura.util.Domain.Cliente.ListaDadosClieteDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "unicommerce", name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
@ToString
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	
	@OneToOne(mappedBy = "userId",cascade = CascadeType.ALL)
	private Cliente cliente;
	
	 

	public void  LoginCadastro 	 (@Valid CadastroUsuarioDto dados) {
		this.login= dados.login();
		this.senha= dados.senha();
	}


		public Usuario ( String login, String senha) {
			this.login =  login;
			this.senha=  senha;
		}


		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}


		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return senha;
		}


		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return login;
		}


		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}


		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}


		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}


		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
  
}
