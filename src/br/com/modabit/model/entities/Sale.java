package br.com.modabit.model.entities;

import br.com.modabit.model.enums.Payment;

public class Sale {

	private Payment payment;
	private ShoppingCart shoppingCart = null;
	private Double cashValue;

	public Sale() {
		shoppingCart = new ShoppingCart();
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Double getCashValue() {
		return cashValue;
	}

	public void setCashValue(Double cashValue) {
		this.cashValue = cashValue;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	
}
