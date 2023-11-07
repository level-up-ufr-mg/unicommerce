package br.com.alura.unicommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.DTO.DadosCadastroUsuario;
import br.com.alura.unicommerce.Domain.Repository.UsuarioRepository;
import br.com.alura.unicommerce.Domain.Usuario.Usuario;
import jakarta.validation.Valid;

@Service
public class AtenticacaoService implements UserDetailsService {
	@Autowired
	private UsuarioRepository repository;

	public void cadastra(@Valid DadosCadastroUsuario dados) {
		repository.save(new Usuario(dados));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByLogin(username);
	}
}