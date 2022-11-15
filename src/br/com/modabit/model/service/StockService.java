package br.com.modabit.model.service;

import java.util.List;

import br.com.modabit.model.dao.DaoFactory;
import br.com.modabit.model.dao.StockDao;
import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.Product;
import br.com.modabit.model.enums.Category;
import br.com.modabit.model.enums.Color;
import br.com.modabit.model.enums.Department;
import br.com.modabit.model.enums.Size;
import br.com.modabit.model.enums.TypeName;

public class StockService {

	private StockDao data = DaoFactory.createStockDao();

	public Integer insertInStock(Items items) {
		boolean isNew = true;
		List<Items> listData = data.findAll();

		for (Items item : listData) {
			if (item.equals(items)) {
				items.setQuantity(items.getQuantity() + item.getQuantity());
				data.update(items);
				isNew = false;
				// "\n Successfully updated!"
				return 1;
			}
		}
		if (isNew) {
			data.insert(items);
			// "\n Successfully inserted!"
			return 2;
		}
		// "\n Insertion failure"
		return 0;
	}

	public Items createItem(TypeName type, Size size, Color color, Category category, Department department,
			Double price, Integer quantity) {
		Product prod = new Product(type, size, color, category, department, price);
		Items item = new Items(prod, quantity);
		return item;
	}
	

	public List<Items> getStockList() {
		data = DaoFactory.createStockDao();
		return data.findAll();
	}
}
