package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.unicommerce.modelo.desempenho;

class BonusServiceTest {

	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Marcelo", LocalDate.now(), new BigDecimal("1000"));
		
		service.concederReajuste(funcionario, desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForABom() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Marcelo", LocalDate.now(), new BigDecimal("1000"));
		
		service.concederReajuste(funcionario, desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForAOtimo() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Marcelo", LocalDate.now(), new BigDecimal("1000"));
		
		service.concederReajuste(funcionario, desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}
