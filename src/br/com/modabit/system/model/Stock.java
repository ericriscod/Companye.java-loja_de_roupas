package br.com.modabit.system.model;

import java.util.ArrayList;
import java.util.List;

public class Stock {

	private List<Product> list;

	public Stock() {
		list = new ArrayList<>();
	}

	public List<Product> getList() {
		return list;
	}

	/*public boolean increaseProduct(Product product) {
		for (Product increase : list) {
			if (increase.equals(product)) {
				increase.setIncreaseQuantity(product.getQuantity());
				return true;
			}
		}
		if(list.add(product))
			return true;
		else
		return false;
	}

	public void decrementProduct(Product product) {
		for (Product decrement : list) {
			if (decrement.equals(product)) {
				if (decrement.getQuantity() >= product.getQuantity()) {
					decrement.setDecrementQuantity(product.getQuantity());
				}
			}
		}
	}*/

}
