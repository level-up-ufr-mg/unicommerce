package br.com.alura.unicommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.dto.DadosCadastraUsuario;
import br.com.alura.unicommerce.modelo.Usuario;
import br.com.alura.unicommerce.repository.UsuarioRepository;
import jakarta.validation.Valid;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AtenticacaoService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	public void cadastra(@Valid DadosCadastraUsuario dados) {
		
		repository.save(new Usuario(dados));
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 
		return repository.findByLogin(username);
	}

}
