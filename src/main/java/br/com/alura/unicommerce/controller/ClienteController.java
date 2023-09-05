package br.com.alura.unicommerce.controller;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.util.JPAUtil;

public class ClienteController {
	public static void main(String[] args) {

		cadastrarCliente();
	}
	
	private static void cadastrarCliente() {
		EntityManager em = JPAUtil.getEntityManager();
		
				
		Endereco enderecoAna = new Endereco("Rua Frederico Moura", "110", "Casa", "Cidade Nova", "Franca", "SP");
		Endereco enderecoEli = new Endereco("Avenida Almirante Maximiano Fonseca", "500", "Apto 01", "Zona Portuária", "Rio Grande", "RS");
		Endereco enderecoDani = new Endereco("Rua Domingos Olímpio", "50", "", "Centro", "Sobral", "CE");
		Endereco enderecoBia = new Endereco("Rodovia Raposo Tavares", "80", "", "Lageadinho", "Cotia", "SP");
		Endereco enderecoCaio = new Endereco("Avenida Afonso Pena", "44", "Apto 310", "Boa Viagem", "Belo Horizonte", "MG");
		Endereco enderecoGabi = new Endereco("Rua Tenente-Coronel Cardoso", "190", "Casa", "Centro", "Campos dos Goytacazes", "RJ");

		Cliente ana = new Cliente("ANA", "520.770.180-03", "(81)2868-1314", enderecoAna);
		Cliente eli = new Cliente("ELI", "011.308.890-68", "(95)3847-3831", enderecoEli);
		Cliente dani = new Cliente("DANI", "131.102.310-00", "(37)3418-8122", enderecoDani);
		Cliente bia = new Cliente("BIA", "351.700.140-66", "(98)3364-2143", enderecoBia);
		Cliente caio = new Cliente("CAIO", "530.260.510-47", "(55)2177-8561", enderecoCaio);
		Cliente gabi = new Cliente("GABI", "530.260.510-47", "(55)2177-8561", enderecoGabi);

		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();
		clienteDao.cadastrar(ana);
		clienteDao.cadastrar(eli);
		clienteDao.cadastrar(dani);
		clienteDao.cadastrar(bia);
		clienteDao.cadastrar(caio);
		clienteDao.cadastrar(gabi);

		em.getTransaction().commit();
		em.close();
	}

}
