package br.com.alura.unicommerce.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.unicommerce.Domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}