package br.com.alura.unicommerce;

import org.apache.commons.logging.LogFactory;
import org.apache.juli.logging.Log;
import org.springframework.aop.TargetClassAware;

import br.com.alura.unicommerce.modelo.Categoria;

public class Simulando {
	private static Log log = LogFactory.getLog(getClass());
	
	public static void main(String[] args) {
		log.info("message");
	}
}
