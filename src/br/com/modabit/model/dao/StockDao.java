package br.com.modabit.model.dao;

import java.util.List;

import br.com.modabit.model.entities.Items;
import br.com.modabit.model.entities.Stock;

public interface StockDao {
		
	void insert(Items items);
	void update(Items stock);
	void deleteById(Integer id);
	List <Items> findAll();
}
