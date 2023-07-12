package com.shopwebcake.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopwebcake.model.Cake;
import com.shopwebcake.service.ICakeService;
import com.shopwebcake.service.impl.CakeService;
import com.shopwebcake.service.impl.CategoryService;

@WebServlet(urlPatterns = { "/admin-product-list" })
public class ProductListController extends HttpServlet {
	ICakeService cakeService = new CakeService();
	CategoryService cateService = new CategoryService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Cake> proList = cakeService.getAll();
		req.setAttribute("proList", proList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-product.jsp");
		dispatcher.forward(req, resp);
	}

}
