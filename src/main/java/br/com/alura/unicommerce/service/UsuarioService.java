package br.com.alura.unicommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.modelo.Usuario;
import br.com.alura.unicommerce.repository.UsuarioRepository;
import br.com.alura.unicommerce.service.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public <Optinal>Usuario buscaPorId(Long usuarioId) {
		Optional<Usuario> obj = repository.findById(usuarioId);
		Usuario entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}
	
	public void insert(Usuario usuario) {
		if (usuario == null) throw new IllegalArgumentException("Falha ao cadastrar cadastrar o produto.");
	        repository.save(usuario);	
	}
}
