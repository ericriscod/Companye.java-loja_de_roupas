package br.com.modabit.model.entities;

import java.io.Serializable;

public class Items implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private Product product;
	private Double price;
	private Integer quantity;
	
	
	public Items(Product product, Integer quantity) {
		super();
		this.product = product;
		this.price = product.getPrice();
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double subTotal() {
		
		price = product.getPrice();
		
		return price * quantity;
	}
	
}
