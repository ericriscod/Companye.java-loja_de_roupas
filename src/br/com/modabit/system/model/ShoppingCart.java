package br.com.modabit.system.model;

import java.util.List;

public class ShoppingCart {
	private List<Items> produtcs;
	
	public List<Items> getProdutcs() {
		return produtcs;
	}



	public void setProdutcs(List<Items> produtcs) {
		this.produtcs = produtcs;
	}



	public Double total(List<Items> product) {
		return 0d;
	}
} 
