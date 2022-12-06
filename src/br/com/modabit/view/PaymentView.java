package br.com.modabit.view;

import java.util.Scanner;

import br.com.modabit.controller.service.SaleServiceController;
import br.com.modabit.controller.service.ShoppingCartServiceController;
import br.com.modabit.model.enums.PaymentEnum;

public class PaymentView {

	private static SaleServiceController saleService = new SaleServiceController();
	private static ShoppingCartServiceController shoppingService = new ShoppingCartServiceController();
	private static Scanner sc = new Scanner(System.in);
	private static String cpf = "";

	public void paymentMethod() {
		Boolean isValidated = saleService.validateSale(shoppingService.getShoppingList());
		shoppingService.removeItemsAll();

		if (isValidated) {
			System.out.println("\n\n _______________________________________________________________");
			System.out.println("\n\n                            Payment                             \n");
			System.out.println(" Cart validated!");
			System.out.print("\n Waht to include the CPF in the buy (y/n)? ");
			String option = sc.next();

			if (option.equalsIgnoreCase("y")) {
				System.out.print(" Digite the CPF:");
				cpf = sc.next();
				
				while (!saleService.validateCpf(cpf)) {
					System.out.println("\n Invalided CPF!");
					System.out.print(" Digite the CPF again:");
					cpf = sc.next();
				}
				System.out.println("\n Included CPF successfully!");
			}

			System.out.println("\n Enter payment method (CREDIT, DEBIT, MONEY, PIX)");
			System.out.print(" Form of payment: ");
			String paymentString = sc.next();
			PaymentEnum pay = PaymentEnum.valueOf(paymentString.toUpperCase());
			selectPayment(pay);
		} else {
			System.out.println("\n\n _______________________________________________________________");
			System.out.println("\n\n                            Payment                             \n");
			System.out.println("\n No stock! Payment cancelled.");
			System.out.print("\n\n Enter with 0 to continue: ");
		}
		sc.next();
	}

	public static void creditMethod() {
		java.sql.Date dateTime = new java.sql.Date(new java.util.Date().getTime());
		Double totalPrice = shoppingService.getTotalPrice();
		SaleServiceController saleService = new SaleServiceController();

		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                        Payment - Credit                      \n");
		System.out.print(" Card number: ");
		String number = sc.next();
		sc.nextLine();

		System.out.print(" Name in the card: ");
		String name = sc.nextLine();

		System.out.print(" Expiretion date the card. (xx/xx/xxxx): ");
		String date = sc.next();

		System.out.println("\n Total for payment: R$" + String.format("%.2f", totalPrice));

		System.out.print("\n Confirm payment (y/n)? ");
		String confirmation = sc.next();

		if (confirmation.equalsIgnoreCase("y")) {
			saleService.histortic(PaymentEnum.CREDIT, null, totalPrice, dateTime, cpf);
			saleService.takeOutOfStock();
			System.out.println("\n Approved payment!");
		} else {
			System.out.println("\n Cancelled payment!");
		}

		System.out.print("\n\n Enter with 0 to continue: ");
	}

	public static void debitMethod() {
		java.sql.Date dateTime = new java.sql.Date(new java.util.Date().getTime());
		Double totalPrice = shoppingService.getTotalPrice();
		SaleServiceController saleService = new SaleServiceController();

		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                        Payment - debit                      \n");
		System.out.print(" Card number: ");
		/*Integer number =*/ sc.nextInt();
		sc.nextLine();

		System.out.print(" Name in the card: ");
		/*String name =*/ sc.nextLine();

		System.out.print(" Expiretion date the card. (xx/xx/xxxx): ");
		/*String date =*/ sc.next();

		System.out.println("\n Total for payment: R$" + String.format("%.2f", totalPrice));

		System.out.print("\n Confirm payment (y/n)? ");
		String confirmation = sc.next();

		if (confirmation.equalsIgnoreCase("y")) {
			saleService.histortic(PaymentEnum.DEBIT, null, totalPrice, dateTime, cpf);
			saleService.takeOutOfStock();
			System.out.println("\n Approved payment!");
		} else {
			System.out.println("\n Cancelled payment!");
		}

		System.out.print("\n\n Enter with 0 to continue: ");
	}

	public static void moneyMethod() {
		java.sql.Date dateTime = new java.sql.Date(new java.util.Date().getTime());
		Double totalPrice = shoppingService.getTotalPrice();
		SaleServiceController saleService = new SaleServiceController();

		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                         Payment - money                      \n");

		System.out.println("\n Total for payment: R$" + String.format("%.2f", totalPrice));

		System.out.print("\n Confirm payment (y/n)? ");
		String confirmation = sc.next();

		if (confirmation.equalsIgnoreCase("y")) {
			saleService.histortic(PaymentEnum.MONEY, null, totalPrice, dateTime, cpf);
			saleService.takeOutOfStock();
			System.out.println("\n Approved payment!");
		} else {
			System.out.println("\n Cancelled payment!");
		}

		System.out.print("\n\n Enter with 0 to continue: ");
	}

	public static void pixMethod() {
		java.sql.Date dateTime = new java.sql.Date(new java.util.Date().getTime());
		Double totalPrice = shoppingService.getTotalPrice();
		SaleServiceController saleService = new SaleServiceController();

		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                           Payment - pix                      \n");

		System.out.print(" Enter pix key: ");
		String keyPix = sc.next();

		System.out.println("\n Total for payment: R$" + String.format("%.2f", totalPrice));

		System.out.print("\n Confirm payment (y/n)? ");
		String confirmation = sc.next();

		if (confirmation.equalsIgnoreCase("y")) {
			saleService.histortic(PaymentEnum.PIX, keyPix, totalPrice, dateTime, cpf);
			saleService.takeOutOfStock();
			System.out.println("\n Approved payment!");
		} else {
			System.out.println("\n Cancelled payment!");
		}

		System.out.print("\n\n Enter with 0 to continue: ");
	}

	public static void selectPayment(PaymentEnum pay) {
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
			moneyMethod();
			break;
		}
		case PIX: {
			pixMethod();
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + pay);
		}
	}
}