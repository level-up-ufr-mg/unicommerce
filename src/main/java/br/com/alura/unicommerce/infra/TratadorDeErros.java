package br.com.alura.unicommerce.infra;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {
	
	private record DadosErroValidacao(String campo, String mensagem) {
		public DadosErroValidacao(FieldError erro) {
		this(erro.getField(), erro.getDefaultMessage());
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratarErro404() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
		
		List<FieldError> erros = (List<FieldError>) ex.getFieldError();
		
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
	}
	
	
	}	
}