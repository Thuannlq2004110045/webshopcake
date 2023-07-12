package com.shopwebcake.dao;

import java.util.List;

import com.shopwebcake.model.Category;




public interface ICategoryDao {
	Category get(int id);

	Category get(String name);

	List<Category> getAll();
}
