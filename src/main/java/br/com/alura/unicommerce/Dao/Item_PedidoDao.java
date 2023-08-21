package br.com.alura.unicommerce.Dao;

import br.com.alura.unicommerce.entidades.Item_Pedido;
import jakarta.persistence.EntityManager;

public class Item_PedidoDao {

	
	
	 private EntityManager  em;

	public Item_PedidoDao(EntityManager manager) {
		this.em = manager;
	} 
	 
	public void cadastra (Item_Pedido Item_Pedido) {
		this.em.persist(Item_Pedido);
	} 
	

	public void Atualizr(Item_Pedido Item_Pedido) {
		this.em.merge(Item_Pedido);
	}
	public void remover (Item_Pedido item_Pedido) {
		item_Pedido = this.em.merge(item_Pedido);
		this.em.remove(item_Pedido);
	}
	
}
