package br.com.modabit.controller.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.modabit.model.dao.DaoFactory;
import br.com.modabit.model.dao.SaleDao;
import br.com.modabit.model.dao.StockDao;
import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.Sale;
import br.com.modabit.model.enums.PaymentEnum;

public class SaleServiceController {
	private static List<Items> listUpdate = new ArrayList<>();
	private static StockDao dataStock = DaoFactory.createStockDao();
	private static SaleDao dataSale = DaoFactory.createSaleDao();

	public Boolean validateSale(List<Items> listCart) {
		List<Items> listDataBase = dataStock.findAll();

		for (int i = 0; i < listCart.size(); i++) {
			for (int j = 0; j < listDataBase.size(); j++) {

				if (listCart.get(i).equals(listDataBase.get(j))) {

					if ((listCart.get(i).getQuantity() <= listDataBase.get(j).getQuantity())
							&& ((listCart.get(i).getQuantity() > 0 && listDataBase.get(j).getQuantity() > 0))) {

						Integer itemDataQuantity = listDataBase.get(j).getQuantity();
						Integer itemCartQuantity = listCart.get(i).getQuantity();

						Integer quantity = itemDataQuantity - itemCartQuantity;

						Items item = listCart.get(i);

						item.setQuantity(quantity);
						listUpdate.add(item);
					}
				}
			}
		}
		if (listUpdate.size() == listCart.size()) {
			return true;
		} else {
			return false;
		}
	}

	public void takeOutOfStock() {
		for (Items takeout : listUpdate) {
			dataStock.update(takeout);
		}
	}
	
	public List<Sale> getListHistoric(){
		return DaoFactory.createSaleDao().findAll();
	}
	
	public void histortic(PaymentEnum method, String pixKey, Double priceTotal, Date moment) {
		Sale sale = new Sale();
		
		sale.setMethod(method);
		sale.setPixKey(pixKey);
		sale.setPriceTotal(priceTotal);
		sale.setMoment(moment);
		
		dataSale.insert(sale);
	}
}