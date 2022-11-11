package br.com.modabit.model.service;

import java.util.List;

import br.com.modabit.model.dao.DaoFactory;
import br.com.modabit.model.dao.StockDao;
import br.com.modabit.model.entities.Items;

public class StockService {

	public String insertInStock(Items items) {
		boolean isNew;
		List<Items> list;

		StockDao data = DaoFactory.createStockDao();
		list = data.findAll();
		isNew = true;

		for (Items item : list) {
			if (item.equals(items)) {
				items.setQuantity(items.getQuantity() + item.getQuantity());
				data.update(items);
				isNew = false;
				return "\n successfully updated!";
			}
		}
		if (isNew) {
			data.insert(items);
			return "\n successfully inserted!";
		}

		return "\n insertion failure";
	}
}
