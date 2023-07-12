package com.shopwebcake.service;

import java.util.List;

import com.shopwebcake.model.Cart;

public interface ICartService {
	void insert(Cart cart);

	void edit(Cart cart);

	void delete(int id);

	Cart get(int id);
	
	List<Cart> getAll();

	
}


