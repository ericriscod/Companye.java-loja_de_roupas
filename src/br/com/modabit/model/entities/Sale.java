package br.com.modabit.model.entities;

import java.util.Date;

import br.com.modabit.model.enums.Payment;

public class Sale {

	private Payment method;
	private String pixKey;
	private Double priceTotal;
	private Date moment;

	public Sale() {
	}

	public Sale(Payment method, String pixKey, Double priceTotal, Date moment) {
		super();
		this.method = method;
		this.pixKey = pixKey;
		this.priceTotal = priceTotal;
		this.moment = moment;
	}

	public Payment getMethod() {
		return method;
	}

	public void setMethod(Payment method) {
		this.method = method;
	}

	public String getPixKey() {
		return pixKey;
	}

	public void setPixKey(String pixKey) {
		this.pixKey = pixKey;
	}

	public Double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	@Override
	public String toString() {
		return "Sale [method= " + method + ", pixKey= " + pixKey + ", priceTotal= " + priceTotal + ", moment= " + moment
				+ "]";
	}
	
	

}
