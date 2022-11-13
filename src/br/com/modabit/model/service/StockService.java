package br.com.modabit.model.service;

import java.util.List;

import br.com.modabit.model.dao.DaoFactory;
import br.com.modabit.model.dao.StockDao;
import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.Stock;

public class StockService {

	private StockDao data = DaoFactory.createStockDao();

	public String insertInStock(Items items) {
		boolean isNew = true;
		List<Items> list = data.findAll();
		
		for (Items item : list) {
			if (item.equals(items)) {
				items.setQuantity(items.getQuantity() + item.getQuantity());
				data.update(items);
				isNew = false;
				return "\n Successfully updated!";
			}
		}
		if (isNew) {
			data.insert(items);
			return "\n Successfully inserted!";
		}
		return "\n Insertion failure";
	}

	public List<Items> getStockList() {
		return data.findAll();
	}
}
