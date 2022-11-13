package br.com.modabit.view;

import java.util.List;
import java.util.Scanner;

import br.com.modabit.model.entities.Items;
import br.com.modabit.model.enums.Payment;
import br.com.modabit.model.service.SaleService;
import br.com.modabit.model.service.ShoppingService;

public class SaleView {
	
	
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void validateSale() {
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                            Payment                             \n");
		System.out.println(" Enter payment method (CREDIT, DEBIT, PIX)");
		System.out.print(" Form of payment: ");
		Payment pay = Payment.valueOf(sc.next());
		List<Items> listCart = new ShoppingService().getShoppingList();
		Boolean isValid = true;
		
		SaleService saleService = new SaleService();
		
		isValid = saleService.validateSale(listCart, pay);
		if(isValid) {
			System.out.println(" Success!");
		}else {
			System.out.println(" Failed!");
		}
		
		sc.next();
	}
}