package br.com.modabit.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.Product;
import br.com.modabit.model.enums.Category;
import br.com.modabit.model.enums.Color;
import br.com.modabit.model.enums.Department;
import br.com.modabit.model.enums.Size;
import br.com.modabit.model.enums.TypeName;
import br.com.modabit.model.service.StockService;

public class MenuView {

	private Scanner sc = null;
	private StockService stockService = null;
	private List<Items> list = null;

	public MenuView() {
		stockService = new StockService();
		sc = new Scanner(System.in);
	}

	public void startMenu() {
		Integer option = -1;
		while (option != 7) {
			System.out.println("\n\n----------------> Welcome to the MODABIT_STORE <----------------");
			System.out.println("\n                       Select an option:");
			System.out.println("\n                | 1-- Register product         |");
			System.out.println("                | 2-- Stock list               |");
			System.out.println("                | 3-- Shopping                 |");
			System.out.println("                | 4-- Payment                  |");
			System.out.println("                | 7-- Leave                    |");

			System.out.print("\n                 Response: ");
			option = sc.nextInt();
			if (option != 7) {
				selection(option);
			}

		}
		System.out.println("Thank you!");
	}

	private void registerProduct() {
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                      REGISTER PRODUCT");
		System.out.println("\n Type availability (CLASSIC, NO_CLASSIC).");
		System.out.print(" Product type: ");
		TypeName type = TypeName.valueOf(sc.next());

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

		Items items = new Items(product, quantity);

		// Adicionar ao estoque.
		System.out.println(stockService.insertInStock(items));
		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}

	private void listProduct() {
		list = new ArrayList<>();

		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                   LIST OF PRODUCTS - STOCK" + "\n\n");

		list.addAll(stockService.stockList());
		if (list.size() > 0) {
			for (Items prod : list) {
				System.out.println(prod);
			}
		} else {
			System.out.println("\n Cart is empty!");
		}

		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}

	public void selection(Integer select) {
		switch (select) {
		case 1: {
			registerProduct();
			break;
		}
		case 2: {
			listProduct();
			break;
		}

		case 3: {
			new ShoppingMenuView();
		}

		case 7: {
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + select);
		}
	}
}
