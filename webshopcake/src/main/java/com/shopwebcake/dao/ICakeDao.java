package com.shopwebcake.dao;

import java.util.List;

import com.shopwebcake.model.Cake;



public interface ICakeDao {
	void insert(Cake cake);

	void edit(Cake cake);

	void delete(int id);
	
	String currencyPrice(long price);

	Cake get(int id);

	List<Cake> getAll();

	
	List<Cake> searchByCategory(int categoryId);
	
	List<Cake> searchByName(String cakeName);

}
