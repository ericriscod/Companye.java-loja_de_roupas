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

}
