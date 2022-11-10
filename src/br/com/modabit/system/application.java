package br.com.modabit.system;

import java.sql.Connection;
import java.util.Locale;

import br.com.modabit.system.db.DB;
import br.com.modabit.system.view.Communication;

public class application {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Connection conn = DB.getConnection();	
		Communication communication = new Communication();
		DB.closeConnection();
		
	}

}
