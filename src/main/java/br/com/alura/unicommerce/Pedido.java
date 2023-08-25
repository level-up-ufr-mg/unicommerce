package br.com.alura.unicommerce;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

    private String categoria;
    private String produto;
    private String cliente;

    private BigDecimal preco;
    private int quantidade;

    private LocalDate data;

    public Pedido(String categoria2, String produto2, String cliente2, BigDecimal preco2, int quantidade2,
			LocalDate data2) {
	}

	public String getCategoria() {
        return categoria;
    }

    public String getProduto() {
        return produto;
    }

    public String getCliente() {
        return cliente;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDate getData() {
        return data;
    }

}