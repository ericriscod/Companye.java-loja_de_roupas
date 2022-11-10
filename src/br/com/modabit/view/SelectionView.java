package br.com.modabit.view;

public class SelectionView {

	public SelectionView(Integer option) {
		selection(option);
	}

	private void selection(Integer select) {
		switch (select) {
		case 1: {
			RegisterProductView register = new RegisterProductView();
			register.closeScanner();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + select);
		}
	}

}
