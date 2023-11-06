package br.com.alura.unicommerce.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.unicommerce.Domain.Cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>  {

}
