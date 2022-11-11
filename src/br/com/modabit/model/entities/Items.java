package br.com.modabit.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Items implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Product product;
	private Double price;
	private Integer quantity;
	
	
	public Items() {
	}
	
	public Items(Integer id,Product product, Integer quantity) {
		super();
		this.id = id;
		this.product = product;
		this.price = product.getPrice();
		this.quantity = quantity;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "\nItems [product:" + product + ", price= " + price + ", quantity= " + quantity + "]";
	}
	
}
