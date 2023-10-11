package br.com.alura.unicommerce.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.unicommerce.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
}
