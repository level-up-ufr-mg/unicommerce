package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.unicommerce.modelo.desempenho;

class BonusServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	private BonusService bonus;

	@BeforeEach
	private void inicializar() {
		System.out.println("-- Iniciado --");
		this.bonus = new BonusService();
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Fernando", new BigDecimal("1000000"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("-- Concluido --");
	}
	
	@BeforeAll
	public static void antesDeTudo() {
		System.out.println("-- Inicializando --");
	}
	
	@AfterAll
	public static void depoisDeTudo() {
		System.out.println("-- Finalizando --");
	}

	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
//		assertThrows(IllegalArgumentException.class, () -> bonus.calcularBonus(funcionario));

		try {
			bonus.fail("Não deu exception");
		} catch (Exception e) {
			assertEquals("Funcionário com salário maior que R$10000,00 não pode receber bônus!", e.getMessage());
		}
	}

	@Test
	public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForABom() {
		service.concederReajuste(funcionario, desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForAOtimo() {
		service.concederReajuste(funcionario, desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}



//			****************************************
//			** 	Organizando o código de teste   **


//		private ReajusteService service;
//		private Funcionario funcionario;
//		private BonusService bonus;
//		
//		@BeforeEach
//		private void inicializar() {
//			System.out.println("-- Iniciado --");
//			this.bonus = new BonusService();
//			this.service = new ReajusteService();
//			this.funcionario = new Funcionario("Fernando", new BigDecimal("1000000"));
//		}
//		
//		@AfterEach
//		public void finalizar() {
//			System.out.println("-- Concluido --");
//		}
//		
//		@BeforeAll
//		public static void antesDeTudo() {
//			System.out.println("-- Inicializando --");
//		}
//		
//		@AfterAll
//		public static void depoisDeTudo() {
//			System.out.println("-- Finalizando --");
//		}
//		
//		@Test
//		public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
//		//	assertThrows(IllegalArgumentException.class, () -> bonus.calcularBonus(funcionario));
//		
//			try {
//				bonus.fail("Não deu exception");
//			} catch (Exception e) {
//				assertEquals("Funcionário com salário maior que R$10000,00 não pode receber bônus!", e.getMessage());
//			}
//		}
//		
//		@Test
//		public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForABom() {
//			service.concederReajuste(funcionario, desempenho.BOM);
//			assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
//		}
//		
//		@Test
//		public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForAOtimo() {
//			service.concederReajuste(funcionario, desempenho.OTIMO);
//			assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
//		}


//****************************************
//**	Lidando com exceptions no JUnit **

//@Test
//public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
//	BonusService service = new BonusService();
//	assertThrows(IllegalArgumentException.class, 
//			() -> service.calcularBonus(new Funcionario("Rodrigo", new BigDecimal("25000.00"))));
//}

//@Test
//public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
////	ReajusteService service = new ReajusteService();
////	Funcionario funcionario = new Funcionario("Marcelo", LocalDate.now(), new BigDecimal("1000"));
//	BonusService service = new BonusService();
//	BigDecimal bonus = service.calcularBonus(new Funcionario("Fabiano", new BigDecimal("25000")));
//	
////	service.concederReajuste(funcionario, desempenho.A_DESEJAR);
////	assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
//	assertEquals(new BigDecimal("0.00"), bonus);
//}
