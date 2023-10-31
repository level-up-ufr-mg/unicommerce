package br.com.alura.unicommerce.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.unicommerce.Domain.Pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>  {

}
