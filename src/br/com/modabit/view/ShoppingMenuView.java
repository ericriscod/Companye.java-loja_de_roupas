package br.com.modabit.view;

import java.util.List;
import java.util.Scanner;

import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.ShoppingCart;
import br.com.modabit.model.service.ShoppingService;

public class ShoppingMenuView {

	private ShoppingService shoppingService = null;
	private List<Items> shop = null;
	private Scanner sc = null;

	public ShoppingMenuView() {
		sc = new Scanner(System.in);
		shoppingService = new ShoppingService();
		shop = shoppingService.shoppingList();
		ShoppingCart();
	}

	private void ShoppingCart() {
		Integer option = -1;
		while (option != 4) {
			System.out.println("\n\n _______________________________________________________________");
			System.out.println("\n\n                        Shopping Cart  \n");
			System.out.println("                       Select an option:");
			System.out.println("\n                | 1-- Insert into cart         |");
			System.out.println("                | 2-- Remove from cart         |");
			System.out.println("                | 3-- List cart                |");
			System.out.println("                | 4-- Back                     |");

			System.out.print("\n                 Response: ");
			option = sc.nextInt();
			selectShopping(option);
		}
		
		System.out.println("\n Returning...\n\n");
	}

	private void selectShopping(Integer option) {
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
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}

	private void insertIntoCart() {
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                    Shopping Cart - Insert ");

		System.out.print("\n Enter the product id: ");
		Integer id = sc.nextInt();

		Integer add = shoppingService.addItem(id);
		
		switch (add) {
		case 1:
			System.out.println(" Successfully inseted!");
			break;
		case 2:{
			System.out.println("\n Successfully updated!");
			break;
		}
		
		case 3:{
			System.out.println("\n Insertion failure!");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + add);
		}

		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}

	private void removeFromCart() {
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                    Shopping Cart - Remove ");
		System.out.print("\n Enter the product id: ");
		Integer id = sc.nextInt();

		Boolean isRemoved = false;

		for (int i = 0; i < shoppingService.shoppingList().size(); i++) {
			if (shoppingService.shoppingList().get(i).getProduct().getId() == id) {
				shoppingService.shoppingList().remove(i);
				System.out.println(" Success!");
				isRemoved = true;
				break;
			}
		}
		if (isRemoved == false) {
			System.out.println("\n Removal failed!");
		}

		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}

	private void listCart() {
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                   Shopping Cart - ListItems \n");
		
		Double total = 0d;
		
		if (shop.size() > 0) {
			for (Items item : shop) {
				System.out.println(item.toString());
				total += item.subTotal();
			}
			
			System.out.println("\nShopping cart total: R$" + String.format("%.2f", total));
			
		} else {
			System.out.println("\n Cart is empty!");
		}
		System.out.println("\n\n _______________________________________________________________");

		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}
}
