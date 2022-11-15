package br.com.modabit.model.dao;

import java.util.List;

import br.com.modabit.model.entities.Sale;

public interface SaleDao {
	void insert(Sale sale);
	List<Sale> findAll();
}
