package br.com.modabit.view;

import java.util.Scanner;

import br.com.modabit.model.enums.Payment;
import br.com.modabit.model.service.SaleService;
import br.com.modabit.model.service.ShoppingCartService;

public class PaymentView {

	private static SaleService saleService = new SaleService();
	private static ShoppingCartService shoppingService = new ShoppingCartService();
	private static Scanner sc = new Scanner(System.in);

	public void paymentMethod() {
		Boolean isValidated = saleService.validateSale(shoppingService.getShoppingList());
		shoppingService.removeItemsAll();

		if (isValidated) {		
			System.out.println("\n\n _______________________________________________________________");
			System.out.println("\n\n                            Payment                             \n");
			System.out.println(" Cart validated!");
			System.out.println("\n Enter payment method (CREDIT, DEBIT, MONEY, PIX)");
			System.out.print(" Form of payment: ");
			String paymentString = sc.next();
			Payment pay = Payment.valueOf(paymentString.toUpperCase());
			selectPayment(pay);
		} else {
			System.out.println("\n\n _______________________________________________________________");
			System.out.println("\n\n                            Payment                             \n");
			System.out.println("\n No stock! Payment cancelled.");		
			System.out.print("\n\n Enter with 0 to continue: ");
		}

		sc.next();
	}

	public static void selectPayment(Payment pay) {
		switch (pay) {
		case CREDIT: {
			creditMethod();
			break;
		}
		case DEBIT: {
			debitMethod();
			break;
		}
		case MONEY: {
			break;
		}
		case PIX: {
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + pay);
		}
	}

	public static void creditMethod() {	
		java.sql.Date dateTime = new java.sql.Date(new java.util.Date().getTime());
		Double totalPrice = shoppingService.getTotalPrice();
		SaleService saleService = new SaleService();
	
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                        Payment - Credit                      \n");
		System.out.print(" Card number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		
		System.out.print(" Name in the card: ");	
		String name = sc.nextLine();
		
		System.out.print(" Expiretion date the card. (xx/xx/xxxx): ");
		String date = sc.next();
		
		System.out.println("\n Total for payment: R$" + String.format("%.2f", totalPrice));
		
		System.out.print("\n Confirm payment (y/n)? ");
		String confirmation =sc.next();
		
		if(confirmation.equalsIgnoreCase("y")) {	
			saleService.histortic(Payment.CREDIT, null, totalPrice, dateTime);
			saleService.takeOutOfStock();
			System.out.println("\n Approved payment!");
		}else {
			System.out.println("\n Cancelled payment!");
		}
		
		System.out.print("\n\n Enter with 0 to continue: ");
	}
	
	public static void debitMethod() {	
		java.sql.Date dateTime = new java.sql.Date(new java.util.Date().getTime());
		Double totalPrice = shoppingService.getTotalPrice();
		SaleService saleService = new SaleService();
		
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                        Payment - debit                      \n");
		System.out.print(" Card number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		
		System.out.print(" Name in the card: ");	
		String name = sc.nextLine();
		
		System.out.print(" Expiretion date the card. (xx/xx/xxxx): ");
		String date = sc.next();
		
		System.out.println("\n Total for payment: R$" + String.format("%.2f", totalPrice));
		
		System.out.print("\n Confirm payment (y/n)? ");
		String confirmation =sc.next();
		
		if(confirmation.equalsIgnoreCase("y")) {
			saleService.histortic(Payment.DEBIT, null, totalPrice, dateTime);
			saleService.takeOutOfStock();
			System.out.println("\n Approved payment!");
		}else {
			System.out.println("\n Cancelled payment!");
		}
		
		System.out.print("\n\n Enter with 0 to continue: ");
	}
}