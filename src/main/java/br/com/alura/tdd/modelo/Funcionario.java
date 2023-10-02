package br.com.alura.tdd.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {
	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;

	public Funcionario(String nome, BigDecimal salario) {
		this.nome = nome;
		this.dataAdmissao = LocalDate.now();
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void reajustarSalario(BigDecimal reajuste) {
		this.salario = this.salario.add(reajuste);
		arredondaSalario();
	}

	private void arredondaSalario() {
		this.salario = this.salario.setScale(2, RoundingMode.HALF_UP);
	}
}


//
//
//								****************************************
//								** 	04 Como testar métodos privados?  **
//								****************************************
//
//
//				public void reajustarSalario(BigDecimal reajuste) {
//					this.salario = this.salario.add(reajuste);
//					arredondaSalario();
//				}
//				
//				private void arredondaSalario() {
//					this.salario = this.salario.setScale(2, RoundingMode.HALF_UP);
//				}