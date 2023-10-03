package br.com.alura.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.alura.util.domain.usuario.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

	UserDetails findByLogin(String login);

	 

	boolean existsByLogin(String login);

}
