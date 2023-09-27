package br.com.alura.unicommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.unicommerce.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
