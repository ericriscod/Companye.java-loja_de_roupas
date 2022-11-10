package br.com.modabit.application;

import java.sql.Connection;
import java.util.Locale;

import br.com.modabit.db.DbConnection;
import br.com.modabit.view.Communication;

public class application {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Connection conn = DbConnection.getConnection();	
		Communication communication = new Communication();
		DbConnection.closeConnection();
	}

}
