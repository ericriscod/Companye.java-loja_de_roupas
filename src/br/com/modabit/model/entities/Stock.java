package br.com.modabit.model.entities;

import java.util.List;

public class Stock {

	private List<Items> list;

	public Stock(List<Items> list) {
		this.list = list;
	}

	public List<Items> getList() {
		return list;
	}

	public void setList(List<Items> list) {
		this.list = list;
	}

	/*
	 * public boolean increaseProduct(Product product) { for (Product increase :
	 * list) { if (increase.equals(product)) {
	 * increase.setIncreaseQuantity(product.getQuantity()); return true; } }
	 * if(list.add(product)) return true; else return false; }
	 * 
	 * public void decrementProduct(Product product) { for (Product decrement :
	 * list) { if (decrement.equals(product)) { if (decrement.getQuantity() >=
	 * product.getQuantity()) {
	 * decrement.setDecrementQuantity(product.getQuantity()); } } } }
	 */

}
