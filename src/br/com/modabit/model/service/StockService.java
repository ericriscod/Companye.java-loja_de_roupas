package br.com.modabit.model.service;

import java.util.List;

import br.com.modabit.model.dao.DaoFactory;
import br.com.modabit.model.dao.StockDao;
import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.Stock;

public class StockService {
	
	StockDao data = DaoFactory.createStockDao();

	public String insertInStock(Items items) {
		boolean isNew;
		List<Items> list;
		
		list = data.findAll();
		isNew = true;

		for (Items item : list) {
			if (item.equals(items)) {
				items.setQuantity(items.getQuantity() + item.getQuantity());
				data.update(items);
				return "\n Successfully updated!";
			}
		}
		if (isNew) {
			data.insert(items);
			return "\n Successfully inserted!";
		}

		return "\n Insertion failure";
	}
	
	public List<Items> stockList (){
		 return data.findAll();
	}
}
