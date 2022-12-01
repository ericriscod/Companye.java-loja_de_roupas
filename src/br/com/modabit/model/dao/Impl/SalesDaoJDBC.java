package br.com.modabit.model.dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.modabit.model.dao.SaleDao;
import br.com.modabit.model.db.DbConnection;
import br.com.modabit.model.db.DbException;
import br.com.modabit.model.entities.Sale;
import br.com.modabit.model.enums.PaymentEnum;

public class SalesDaoJDBC implements SaleDao {

	private Connection conn;

	public SalesDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Sale sale) {
		PreparedStatement st = null;

		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO tbl_sales (Method, Payment_Value, PixKey, Moment, CPF) VALUES (?, ?, ?, ?, ?);");

			st.setString(1, sale.getMethod().toString());
			st.setDouble(2, sale.getPriceTotal());
			st.setString(3, sale.getPixKey());
			st.setDate(4, (Date) sale.getMoment());
			st.setString(5, sale.getCpf());
			st.execute();

			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new DbException(e1.getMessage());
			}
			throw new DbException(e.getMessage());
		} finally {
			DbConnection.closeStatement(st);
		}

	}

	@Override
	public List<Sale> findAll() {
		List<Sale> listSale = new ArrayList<>();
		Sale sale = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn.setAutoCommit(false);

			st = conn.prepareStatement("SELECT * FROM tbl_sales;");
			rs = st.executeQuery();

			while (rs.next()) {
				sale = new Sale();
				sale.setMethod(PaymentEnum.valueOf(rs.getString("Method")));
				sale.setPriceTotal(rs.getDouble("Payment_Value"));
				sale.setPixKey(rs.getString("PixKey"));
				sale.setMoment(rs.getDate("Moment"));
				sale.setCpf(rs.getString("CPF"));
				listSale.add(sale);
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new DbException(e1.getMessage());
			}
			throw new DbException(e.getMessage());
		}
		return listSale;
	}

}
