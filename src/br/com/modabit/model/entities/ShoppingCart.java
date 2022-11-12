package br.com.modabit.model.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Items> list;
	
	
	public ShoppingCart() {
		list = new ArrayList<>();
	}
	
	public List<Items> getList() {
		return list;
	}

	public void setList(List<Items> items) {
		this.list = items;
	}
	

	@Override
	public String toString() {
		return "ShoppingCart [list=" + list + "]";
	}

	
} 
