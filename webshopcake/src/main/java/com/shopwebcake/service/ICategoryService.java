package com.shopwebcake.service;

import java.util.List;

import com.shopwebcake.model.Category;

public interface ICategoryService {

	

	Category get(int id);
	
	Category get(String name);

	List<Category> getAll();

	
}

