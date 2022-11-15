package br.com.modabit.model.service;

import java.util.List;

import br.com.modabit.model.dao.DaoFactory;
import br.com.modabit.model.dao.StockDao;
import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.ShoppingCart;

public class ShoppingCartService {
	private static ShoppingCart cart = new ShoppingCart();

	public Integer addItem(Integer id, Integer amont) {
		StockDao data = DaoFactory.createStockDao();
		Items item = data.findById(id);
		if (amont > 0) {
			item.setQuantity(amont);
			insertTotalPrice(item.subTotal());
		} else {
			return 3;
		}
		if ((!cart.getList().contains(item)) && item != null) {
			cart.getList().add(item);
			return 1;
		} else if (item != null) {
			cart.setTotalPrice(0d);
			for (int i = 0; i < cart.getList().size(); i++) {
				if (cart.getList().get(i).equals(item)) {
					cart.getList().get(i).getProduct().setPrice((item.getProduct().getPrice()));
					cart.getList().get(i).setQuantity(cart.getList().get(i).getQuantity() + item.getQuantity());
					Double subtotal = cart.getList().get(i).subTotal();
					cart.setTotalPrice(subtotal);
					return 2;
				}
			}
		}
		return 3;
	}

	public Boolean removeItem(Integer id) {
		for (int i = 0; i < cart.getList().size(); i++) {
			if (cart.getList().get(i).getProduct().getId() == id) {
				cart.getList().remove(i);
				return true;
			}
		}
		return false;
	}

	public void removeItemsAll() {
		cart.getList().removeAll(cart.getList());
	}

	public void insertTotalPrice(Double totalPrice) {
		cart.setTotalPrice(totalPrice);
	}

	public Double getTotalPrice() {
		return cart.getTotalPrice();
	}

	public List<Items> getShoppingList() {
		return cart.getList();
	}
}
