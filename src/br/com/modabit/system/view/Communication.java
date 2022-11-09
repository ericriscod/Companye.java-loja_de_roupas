package br.com.modabit.system.view;

import java.util.Scanner;

import br.com.modabit.system.enumeration.Category;
import br.com.modabit.system.enumeration.Color;
import br.com.modabit.system.enumeration.Department;
import br.com.modabit.system.enumeration.Size;
import br.com.modabit.system.enumeration.Type;
import br.com.modabit.system.model.Product;
import br.com.modabit.system.model.Stock;

public class Communication {

	private Scanner sc = new Scanner(System.in);

	Stock stock;

	public Communication() {
		stock = new Stock();
		System.out.println("\n               Welcome to the MODABIT_STORE");
		start();
		selection(sc.nextInt());
	}

	private void start() {
		System.out.println("\n Select an option:");
		System.out.println("\n 1-- Register product.");
		System.out.println("\n 2-- List of products(stock).");
		System.out.println("\n 3-- Shopping.");
		System.out.println("\n 4-- Check cart.");
		System.out.println("\n 5-- Payment.");
		System.out.println("\n 7-- Leave.");
		System.out.print("\n Response: ");
	}

	private void registerProduct() {
		System.out.println("\n\n               REGISTER PRODUCT");
		System.out.println("\n Type availability (CLASSIC, NO-CLASSIC).");
		System.out.print(" Product type: ");
		Type type = Type.valueOf(sc.next());

		System.out.println("\n Size availability (P, M, G, GG).");
		System.out.print(" Product size: ");
		Size size = Size.valueOf(sc.next());

		System.out.println("\n Color availability (WHITE, BLACK, GREY, BLUE, YELLOW, GREEN).");
		System.out.print(" Product color: ");
		Color color = Color.valueOf(sc.next());

		System.out.println("\n Category availability (SHIRTS, BLOUSE, PANTS, SHORTS).");
		System.out.print(" Product color: ");
		Category category = Category.valueOf(sc.next());

		System.out.println("\n Department availability (SPORT, BATH, SOCIAL, SLEEP, DAY_BY_DAY).");
		System.out.print(" Product color: ");
		Department department = Department.valueOf(sc.next());

		System.out.print("\n Product price: ");
		Double price = sc.nextDouble();

		System.out.print("\n Product quantity: ");
		Integer quantity = sc.nextInt();

		Product product = new Product(type, size, color, category, department, price, quantity);

		if (stock.increaseProduct(product))
			System.out.println("\n Increased product in stock!");
		else {
			System.out.println("\n Fault!");
		}

	}

	private void selection(Integer select) {
		switch (select) {
		case 1: {
			registerProduct();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + select);
		}
	}

}
