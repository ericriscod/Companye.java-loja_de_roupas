package br.com.modabit.model.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Items> list;
	private Double totalPrice = 0d;

	public ShoppingCart() {
		list = new ArrayList<>();
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalValue) {
		this.totalPrice = totalValue;
	}

	public List<Items> getList() {
		return list;
	}

	public void setList(List<Items> items) {
		this.list = items;
	}

}
