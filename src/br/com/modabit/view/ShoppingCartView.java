package br.com.modabit.view;

import java.util.List;
import java.util.Scanner;

import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.ShoppingCart;
import br.com.modabit.model.service.ShoppingService;

public class ShoppingCartView {
	
    private ShoppingCart shopping = null;
    private List<Items> shop = null;
	private Scanner sc = null;

	public ShoppingCartView() {
		sc = new Scanner(System.in);
		shopping = new ShoppingCart();
		shop = shopping.getlist();
		ShoppingCart();
	}

	private void ShoppingCart() {
		Integer option = -1;
		while(option != 4) {
			System.out.println("\n\n _______________________________________________________________");
			System.out.println("\n\n                        Shopping Cart  \n");
			System.out.println("                       Select an option:");
			System.out.println("\n                | 1-- Insert into cart.        |");
			System.out.println("                | 2-- Remove from cart.        |");
			System.out.println("                | 3-- List cart.               |");
			System.out.println("                | 4-- Back.                    |");

			System.out.print("\n                 Response: ");
			option = sc.nextInt();
			selectShopping(option);
		}
		
	}
	
	private void selectShopping(Integer option) {
		switch (option) {
		case 1: {
			insertIntoCart();
			break;
		}
		case 2:{
			removeFromCart();
			break;
		}
		case 3:{
			listCart();
			break;
		}
		case 4:{
			new MenuView();
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
		
		shopping.getlist().add(new ShoppingService().addItem(id));		
		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}
	
	private void removeFromCart() {
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                    Shopping Cart - Remove ");
		System.out.print("\n Enter the product id: ");
		Integer id = sc.nextInt();
		
		shopping.getlist().remove(new ShoppingService().addItem(id));
		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}

	private void listCart() {
		System.out.println();
		for(Items item : shop) {
			System.out.println(item.toString());
		}
		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}
}
