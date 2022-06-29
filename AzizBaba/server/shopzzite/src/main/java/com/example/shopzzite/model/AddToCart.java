package com.example.shopzzite.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AddToCart {
	
	@Id
	private int addcart_id;

	private int qty;
	private int price;
	public int getAddcart_id() {
		return addcart_id;
	}
	public void setAddcart_id(int addcart_id) {
		this.addcart_id = addcart_id;
	}
	/*public Product getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Product product_id) {
		this.product_id = product_id;
	}*/
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public AddToCart(int addcart_id, Product product_id, int qty, int price) {
		super();
		this.addcart_id = addcart_id;
	//	this.product_id = product_id;
		this.qty = qty;
		this.price = price;
	}
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
