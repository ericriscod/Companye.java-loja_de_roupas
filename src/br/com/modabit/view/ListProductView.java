package br.com.modabit.view;

import java.util.ArrayList;
import java.util.List;

import br.com.modabit.model.entities.Items;
import br.com.modabit.model.service.StockService;

public class ListProductView {
	private StockService stock = null;
	private List<Items> list = null;
	
	public ListProductView() {
		listProduct();
	}
	
	private void listProduct() {
		stock = new StockService();
		list = new ArrayList<>();
		
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                   LIST OF PRODUCTS - STOCK" + "\n\n");
		
		list.addAll(stock.stockList());
		for(Items prod: list) {
			System.out.println(prod);
			//System.out.println("ProductID: " + prod.getProduct().getId() + prod.getProduct());
		}
	}
}
