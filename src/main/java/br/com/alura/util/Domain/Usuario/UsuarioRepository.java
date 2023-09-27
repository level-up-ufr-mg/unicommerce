package br.com.alura.util.Domain.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

	UserDetails findByLogin(String login);

	 

	boolean existsByLogin(String login);

}
