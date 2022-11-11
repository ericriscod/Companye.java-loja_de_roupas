package br.com.modabit.model.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.modabit.db.DbConnection;
import br.com.modabit.db.DbException;
import br.com.modabit.model.dao.StockDao;
import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.Product;
import br.com.modabit.model.entities.Stock;

public class StockDaoJDBC implements StockDao{
	
	private Connection conn;
	
	public StockDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Items items ) {
		PreparedStatement st = null;
		
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement("INSERT INTO tbl_stock"
					+ "(TypeName, Size, Color, Category, Department, Price, Quantity) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?);");
			
			st.setString(1, items.getProduct().getType().toString());
			st.setString(2, items.getProduct().getSize().toString());
			st.setString(3, items.getProduct().getColor().toString());
			st.setString(4, items.getProduct().getCategory().toString());
			st.setString(5, items.getProduct().getDepartment().toString());
			st.setDouble(6, items.getPrice());
			st.setInt(7, items.getQuantity());
			
			int rowsAffected = st.executeUpdate();
			
			conn.commit();
			
			if(rowsAffected < 1) {
				throw new DbException("Error in insert.");
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new DbException(e1.getMessage());
			}
			throw new DbException(e.getMessage());
			
		}
		finally {
			DbConnection.closeStatement(st);
		}
		
	}

	@Override
	public void update(Items items) {
		PreparedStatement st = null;
		
		try {
			
			conn.setAutoCommit(false);
			st = conn.prepareStatement("UPDATE tbl_stock SET Price = ?, Quantity = ?");

			st.setDouble(1, items.getPrice());
			st.setInt(2, items.getQuantity());
			
			int rowsAffeted = st.executeUpdate();
			
			conn.commit();
			
			if(rowsAffeted < 1) {
				throw new DbException("Error in update.");
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new DbException(e1.getMessage());
			}
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Items> findAll() {
		
		List<Items> list = new ArrayList<>();
		Product prod = null;
		Items items = null;
		
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM tbl_stock;");
			
			while(rs.next()) {
				prod = new Product();
				items = new Items();
				
				prod.setType(rs.getString("TypeName"));
				prod.setSize(rs.getString("Size"));
				prod.setColor(rs.getString("Color"));
				prod.setCategory(rs.getString("Category"));
				prod.setDepartment(rs.getString("Department"));
				prod.setPrice(rs.getDouble("Price"));
				items.setProduct(prod);
				items.setId(rs.getInt("Id"));
				items.setPrice(prod.getPrice());
				items.setQuantity(rs.getInt("Quantity"));
				list.add(items);
			}
			
			if(list.size() > 0) {
				Stock stock = new Stock(list);
				
				return list;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DbConnection.closeStatement(st);
			DbConnection.closeResultSet(rs);
		}
		
	}

}
