package br.com.modabit.model.service;

import java.util.List;

import br.com.modabit.model.dao.DaoFactory;
import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.ShoppingCart;

public class ShoppingService {
	private static ShoppingCart shop = new ShoppingCart();

	// private List<Items> cart = null;

	public Integer addItem(Integer id, Integer amont) {

		Items item = DaoFactory.createStockDao().findById(id);
		item.setQuantity(amont);

		if ((!shop.getList().contains(item)) && item != null) {
			shop.getList().add(item);
			return 1;
		} else if(item != null){
			for (int i = 0; i< shop.getList().size(); i++) {
				if (shop.getList().get(i).equals(item)) {
					shop.getList().get(i).setPrice(item.getProduct().getPrice());
					shop.getList().get(i).setQuantity(shop.getList().get(i).getQuantity() + item.getQuantity());
					return 2;
				}
			}
		}
		return 3;

	}

	public List<Items> getShoppingList() {
		return shop.getList();
	}

}
