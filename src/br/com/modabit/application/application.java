package br.com.modabit.application;

import java.sql.Connection;
import java.util.Locale;

import br.com.modabit.db.DbConnection;
import br.com.modabit.model.dao.DaoFactory;
import br.com.modabit.model.dao.StockDao;
import br.com.modabit.model.dao.Impl.StockDaoJDBC;
import br.com.modabit.view.CommunicationUserView;

public class application {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		//Iniciando conexão com MySQL.
		Connection conn = DbConnection.getConnection();	
		
		//Instânciando "Communication" para interação com o usuário
		CommunicationUserView communication = new CommunicationUserView();
		
		//Fechando conexão com o banco de dados.
		DbConnection.closeConnection();
	}
	
	

}
