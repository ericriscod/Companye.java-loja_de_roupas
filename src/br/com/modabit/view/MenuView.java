package br.com.modabit.view;

import java.util.Scanner;

public class MenuView {

	private Scanner sc = new Scanner(System.in);

	public MenuView() {
		startMenu();
	}

	private void startMenu() {
		System.out.println("\n----------------> Welcome to the MODABIT_STORE <----------------");
		System.out.println("\n                       Select an option:");
		System.out.println("\n                | 1-- Register product.        |");
		System.out.println("                | 2-- List of products(stock). |");
		System.out.println("                | 3-- Shopping.                |");
		System.out.println("                | 4-- Check cart.              |");
		System.out.println("                | 5-- Payment.                 |");
		System.out.println("                | 7-- Leave.                   |");
		
		System.out.print("\n                 Response: ");

		new SelectionView(sc.nextInt());
	}
}
