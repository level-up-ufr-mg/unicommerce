package br.com.alura.unicommerce.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.alura.unicommerce.Domain.Usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	UserDetails findByLogin(String username);
}
