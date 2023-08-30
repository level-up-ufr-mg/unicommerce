package br.com.alura.unicommerce.modelo;

import javax.persistence.Embeddable;

@Embeddable
public enum tipoDesconto {
	FIDELIDADE,
	CREDITO,
	BANCO,
	NENHUM
}
