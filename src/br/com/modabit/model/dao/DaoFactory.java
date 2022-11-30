package br.com.modabit.model.dao;

import br.com.modabit.model.dao.Impl.SalesDaoJDBC;
import br.com.modabit.model.dao.Impl.StockDaoJDBC;
import br.com.modabit.model.db.DbConnection;

public class DaoFactory {
	
 public static StockDao createStockDao() {
	 return new StockDaoJDBC(DbConnection.getConnection());
 }
 
 public static SaleDao createSaleDao() {
	 return new SalesDaoJDBC(DbConnection.getConnection());
 }
}
