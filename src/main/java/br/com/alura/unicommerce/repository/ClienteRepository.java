package br.com.alura.unicommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.unicommerce.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
