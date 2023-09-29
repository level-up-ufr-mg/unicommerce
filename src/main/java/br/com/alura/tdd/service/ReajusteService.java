package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.unicommerce.modelo.desempenho;

public class ReajusteService {
	public void concederReajuste(Funcionario funcionario, desempenho desempenho) {
		BigDecimal percentual = desempenho.percentualReajuste();
		BigDecimal reajuste = percentual.multiply(funcionario.getSalario());
		funcionario.reajustarSalario(reajuste);
	}
}
