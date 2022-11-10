package br.com.modabit.model.entities;

import java.io.Serializable;

public class Items implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private Product product;
	private Double price;
	private Integer quantity;
	
	
	public Items() {
	}
	
	public Items(Product product, Integer quantity) {
		super();
		this.product = product;
		this.price = product.getPrice();
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "\nItems [product:" + product + ", price= " + price + ", quantity= " + quantity + "]";
	}
	
}
