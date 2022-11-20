package br.com.modabit.view;

import java.util.Scanner;

import br.com.modabit.controller.service.ShoppingCartServiceController;

public class ShoppingCartView {

	private static ShoppingCartServiceController shoppingService = new ShoppingCartServiceController();
	private static Scanner sc = new Scanner(System.in);;

	public static void ShoppingCartMenu() {
		Integer option = -1;
		while (option != 5) {
			System.out.println("\n\n _______________________________________________________________");
			System.out.println("\n\n                        Shopping Cart  \n");
			System.out.println("                       Select an option:");
			System.out.println("\n                | 1-- Insert into cart         |");
			System.out.println("                | 2-- Remove from cart         |");
			System.out.println("                | 3-- List cart                |");
			System.out.println("                | 4-- Payment                  |");
			System.out.println("                | 5-- Back                     |");

			System.out.print("\n                 Response: ");
			option = sc.nextInt();
			selectShopping(option);
		}

		System.out.println("\n Returning...\n\n");
	}

	private static void selectShopping(Integer option) {
		switch (option) {
		case 1: {
			insertIntoCart();
			break;
		}
		case 2: {
			removeFromCart();
			break;
		}
		case 3: {
			listCart();
			break;
		}
		case 4: {
			new PaymentView().paymentMethod();
			break;
		}
		case 5: {
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}

	private static void insertIntoCart() {
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                    Shopping Cart - Insert ");

		System.out.print("\n Enter the product id: ");
		Integer id = sc.nextInt();

		System.out.print(" Enter with amont: ");
		Integer amont = sc.nextInt();

		Integer add = shoppingService.addItem(id, amont);

		switch (add) {
		case 1:
			System.out.println(" Successfully inseted!");
			break;
		case 2: {
			System.out.println("\n Successfully updated!");
			break;
		}

		case 3: {
			System.out.println("\n Insertion failure!");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + add);
		}

		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}

	private static void removeFromCart() {
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                    Shopping Cart - Remove ");
		System.out.print("\n Enter the product id: ");
		Integer id = sc.nextInt();

		Boolean isRemoved = null;

		isRemoved = shoppingService.removeItem(id);

		if (isRemoved) {
			System.out.println("\n Successfully removed!");
		} else {
			System.out.println("\n Removal failed!");
		}
		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}

	private static void listCart() {
		Double total = 0d;
		Boolean isEmpty = true;
		
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                   Shopping Cart - ListItems \n");
		
		for(int i=0 ; i<shoppingService.getShoppingList().size(); i++) {
			System.out.println(shoppingService.getShoppingList().get(i));
			total += shoppingService.getShoppingList().get(i).subTotal();
			shoppingService.insertTotalPrice(total);
			isEmpty = false;
		}

		System.out.println("\n Shopping cart total: R$" + String.format("%.2f", total));

		if(isEmpty) {
			System.out.println("\n Cart is empty!");
		}

		System.out.println("\n\n _______________________________________________________________");

		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}
}
