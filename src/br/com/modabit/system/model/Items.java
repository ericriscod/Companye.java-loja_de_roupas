package br.com.modabit.system.model;

public class Items {
	
	private Product product;
	private Double price;
	private Integer quantity;
	
	
	public Items(Product product, Double price, Integer quantity) {
		super();
		this.product = product;
		this.price = price;
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
