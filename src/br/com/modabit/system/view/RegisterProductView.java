package br.com.modabit.system.view;

import java.util.Scanner;

import br.com.modabit.system.enumeration.Category;
import br.com.modabit.system.enumeration.Color;
import br.com.modabit.system.enumeration.Department;
import br.com.modabit.system.enumeration.Size;
import br.com.modabit.system.enumeration.Type;
import br.com.modabit.system.model.Items;
import br.com.modabit.system.model.Product;

public class RegisterProductView {
	
	private Scanner sc;
	
	public RegisterProductView() {
		sc = new Scanner(System.in);
		registerProduct();
	}
	
	private void registerProduct() {
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                      REGISTER PRODUCT");
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

		Product product = new Product(type, size, color, category, department, price);
		
		Items items = new Items(product, price, quantity);

	}
	
	public void closeScanner() {
		sc.close();
	}

}
