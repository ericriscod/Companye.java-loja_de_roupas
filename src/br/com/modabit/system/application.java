package br.com.modabit.system;

import java.util.Locale;

import br.com.modabit.system.view.Communication;

public class application {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Communication communication = new Communication();
	}

}
