package br.com.modabit.view;

import java.util.Scanner;

public class CommunicationUserView {

	MenuView menu = new MenuView();

	public CommunicationUserView() {
		Integer option = -1;
		Scanner sc = null;

		while (option != 7) {
			sc = new Scanner(System.in);
			option = menu.startMenu();
			menu.selection(option);;

			if (option != 7) {
				System.out.print("\n\n Enter with 0 to continue: ");
				sc.next();
				System.out.println("\n\n");
			} else {
				System.out.println("Thank you!");
			}
		}

		sc.close();

	}

}
