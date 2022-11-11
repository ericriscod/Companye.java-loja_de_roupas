package br.com.modabit.model.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Items> list;
	
	
	public ShoppingCart() {
		list = new ArrayList<>();
	}
	
	public List<Items> getlist() {
		return list;
	}

	public void setlist(List<Items> produtc) {
		this.list = produtc;
	}
	

	@Override
	public String toString() {
		return "ShoppingCart [list=" + list + "]";
	}

	
} 
