package br.com.modabit.model.service;

import java.util.ArrayList;
import java.util.List;

import br.com.modabit.model.dao.DaoFactory;
import br.com.modabit.model.dao.StockDao;
import br.com.modabit.model.entities.Items;
import br.com.modabit.model.enums.Payment;

public class SaleService {

	public SaleService() {

	}

	public Boolean validateSale(List<Items> listCart, Payment pay) {

		StockDao data = DaoFactory.createStockDao();
		List<Items> listDataBase = data.findAll();
		List<Items> listUpdate = new ArrayList<>();

		for (int i = 0; i < listCart.size(); i++) {
			for (int j = 0; j < listDataBase.size(); j++) {
				
				if (listCart.get(i).equals(listDataBase.get(j))) {
					
					if (listCart.get(i).getQuantity() < listDataBase.get(j).getQuantity() | (listCart.get(i).getQuantity() > 0 && listDataBase.get(j).getQuantity() > 0)) {
						
						Integer quantity = listDataBase.get(j).getQuantity() - listCart.get(i).getQuantity();
						listCart.get(i).setQuantity(quantity);
						listUpdate.add(listCart.get(i));
					}
				}
			}
		}

		if (listUpdate.size() == listCart.size()) {
			for(Items list: listUpdate) {
				data.update(list);
			}
			return true;
		}
		return false;
	}
}
