package br.com.modabit.view;

import java.util.List;
import java.util.Scanner;

import br.com.modabit.model.entities.Items;
import br.com.modabit.model.enums.CategoryEnum;
import br.com.modabit.model.enums.ColorEnum;
import br.com.modabit.model.enums.DepartmentEnum;
import br.com.modabit.model.enums.SizeEnum;
import br.com.modabit.model.enums.TypeNameEnum;
import br.com.modabit.model.service.SaleService;
import br.com.modabit.model.service.StockService;

public class MenuView {

	private static Scanner sc = new Scanner(System.in);
	private static StockService stockService = new StockService();
	private static SaleService saleService = new SaleService();
	private static List<Items> list = null;

	public void startMenu() {
		Integer option = 0;
		
		while (option != 5) {
			System.out.println("\n\n----------------> Welcome to the MODABIT_STORE <----------------");
			System.out.println("\n                       Select an option:");
			System.out.println("\n                | 1-- Register product         |");
			System.out.println("                | 2-- Stock list               |");
			System.out.println("                | 3-- Shopping Cart            |");
			System.out.println("                | 4-- Sales historic           |");
			System.out.println("                | 5-- Leave                    |");

			System.out.print("\n                 Response: ");
			option = sc.nextInt();
			selection(option);

		}
		System.out.println("Thank you!\n\n\n");
	}

	private void registerProduct() {
		Integer resultInsert = 0;
		
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                      REGISTER PRODUCT");
		System.out.println("\n Type availability (CLASSIC, NO_CLASSIC).");
		System.out.print(" Product type: ");
		String typeString = sc.next();
		TypeNameEnum type = TypeNameEnum.valueOf(typeString.toUpperCase());

		System.out.println("\n Size availability (P, M, G, GG).");
		System.out.print(" Product size: ");
		String sizeString = sc.next();
		SizeEnum size = SizeEnum.valueOf(sizeString.toUpperCase());

		System.out.println("\n Color availability (WHITE, BLACK, GREY, BLUE, YELLOW, GREEN).");
		System.out.print(" Product color: ");
		String colorString = sc.next();
		ColorEnum color = ColorEnum.valueOf(colorString.toUpperCase());

		System.out.println("\n Category availability (SHIRTS, BLOUSE, PANTS, SHORTS).");
		System.out.print(" Product category: ");
		String categoryString = sc.next();
		CategoryEnum category = CategoryEnum.valueOf(categoryString.toUpperCase());

		System.out.println("\n Department availability (SPORT, BATH, SOCIAL, SLEEP, DAY_BY_DAY).");
		System.out.print(" Product department: ");
		String departmentString = sc.next();
		DepartmentEnum department = DepartmentEnum.valueOf(departmentString.toUpperCase());

		System.out.print("\n Product price: ");
		Double price = sc.nextDouble();

		System.out.print("\n Product quantity: ");
		Integer quantity = sc.nextInt();

		resultInsert =  stockService.insertInStock(stockService.createItem(type, size, color, category, department, price, quantity));
		
		if(resultInsert == 1) {
			System.out.println("\n Successfully updated!");
		}else if(resultInsert == 2){
			System.out.println("\n Successfully inserted!");
		}else {
			System.out.println("\n Insertion failure");
		}
		
		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}
	
	private void listSaleHistoric() {
		Boolean isEmpty = true;
		
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                       Menu - Historic \n");
		
		for(int i=0 ; i<saleService.getListHistoric().size(); i++) {
			System.out.println(saleService.getListHistoric().get(i));
			isEmpty = false;
		}


		if(isEmpty) {
			System.out.println("\n Historic is empty!");
		}

		System.out.println("\n\n _______________________________________________________________");

		System.out.print("\n\n Enter with 0 to continue: ");
		sc.next();
	}

	private void listProduct() {
		System.out.println("\n\n _______________________________________________________________");
		System.out.println("\n\n                   LIST OF PRODUCTS - STOCK" + "\n\n");
		
		list = stockService.getStockList();

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
			ShoppingCartView.ShoppingCartMenu();
			break;
		}
		
		case 4:{
			listSaleHistoric();
			break;
		}

		case 5: {
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + select);
		}
	}
}
