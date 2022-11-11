package br.com.modabit.model.service;

import br.com.modabit.model.dao.DaoFactory;
import br.com.modabit.model.entities.Items;

public class ShoppingService {
	
	//private List<Items> cart = null;

	public Items addItem(Integer id) {
		Items item = DaoFactory.createStockDao().findById(id);
		return item;
	}

}
