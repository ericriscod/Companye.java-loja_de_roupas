package br.com.modabit.model.dao;

import br.com.modabit.db.DbConnection;
import br.com.modabit.model.dao.Impl.StockDaoJDBC;

public class DaoFactory {
	
 public static StockDao createStockDao() {
	 return new StockDaoJDBC(DbConnection.getConnection());
 }
}
