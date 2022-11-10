package br.com.modabit.model.dao;

import java.util.List;

import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.Stock;

public interface StockDao {
		
	void insert(Stock stock);
	void update(Stock stock);
	void deleteById(Integer id);
	List <Items> findAll();
}
