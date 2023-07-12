package com.shopwebcake.service.impl;

import java.util.List;

import com.shopwebcake.dao.impl.CategoryDao;
import com.shopwebcake.model.Category;
import com.shopwebcake.service.ICategoryService;

public class CategoryService implements ICategoryService {
CategoryDao categoryDao = new CategoryDao();

	

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryDao.get(id);
	}

	@Override
	public Category get(String name) {
		// TODO Auto-generated method stub
		return categoryDao.get(name);
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryDao.getAll();
	}

	

}
