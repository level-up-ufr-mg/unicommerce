package br.com.alura.unicommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.vo.RelatorioVendasPorCategoriaVo;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	@Query(" SELECT new br.com.alura.unicommerce.vo.RelatorioVendasPorCategoriaVo("	
    		+ " c.nome, SUM(item.quantidade), "
    		+ " SUM(item.quantidade * item.produto.preco - item.desconto)) "
    		+ " FROM Pedido pedido "
    		+ " JOIN pedido.itens item "
    		+ " JOIN item.produto p "
    		+ " JOIN p.categoria c "
    		+ " GROUP BY c.nome ")
	Page<RelatorioVendasPorCategoriaVo> getRelatorioVendasPorCategoria(Pageable pageable);
}
