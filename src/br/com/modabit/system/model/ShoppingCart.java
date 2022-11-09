package br.com.modabit.system.model;

import java.util.List;

public class ShoppingCart {
	private List<Product> produtcs;
	
	public List<Product> getProdutcs() {
		return produtcs;
	}



	public void setProdutcs(List<Product> produtcs) {
		this.produtcs = produtcs;
	}



	public Double total(List<Product> product) {
		return 0d;
	}
}
