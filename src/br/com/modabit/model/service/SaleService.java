package br.com.modabit.model.service;

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
		
		Boolean isValidated = null; 

		for (int i=0; i<listCart.size(); i++) {
			System.out.println("For1");
			for (Items listData : listDataBase) {
				System.out.println("For2");
				if (listCart.get(i).equals(listData)) {
					if (listCart.get(i).getQuantity() > listData.getQuantity()) {
						isValidated = false;
					} else {
						Integer quantity = listData.getQuantity() - listCart.get(i).getQuantity();
						listCart.get(i).setQuantity(quantity);
						data.update(listCart.get(i));
						isValidated = true;
					}
				}
			}
		}
		return isValidated;
	}

}
