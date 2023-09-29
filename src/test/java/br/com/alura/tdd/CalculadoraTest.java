package br.com.alura.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {

	@Test
	public void deveriaSomarDoisNumerosPositivos() {
		Calculadora calculadora = new Calculadora();
		int soma = calculadora.somar(3, 7);
		
		assertEquals(10, soma);
	}
}
