package br.com.alura.unicommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.alura.unicommerce.modelo.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);

}