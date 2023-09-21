package br.com.alura.unicommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.unicommerce.modelo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	
}
