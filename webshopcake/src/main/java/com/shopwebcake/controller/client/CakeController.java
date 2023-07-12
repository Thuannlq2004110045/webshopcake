package com.shopwebcake.controller.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopwebcake.model.Cake;
import com.shopwebcake.model.Category;
import com.shopwebcake.service.ICakeService;
import com.shopwebcake.service.impl.CakeService;
import com.shopwebcake.service.impl.CategoryService;


@WebServlet (urlPatterns = {"/cake-detail"})
public class CakeController extends HttpServlet {
	ICakeService cakeService = new CakeService();
	CategoryService categoryService = new CategoryService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cakeId = req.getParameter("cakeId");
		Cake cakeDetail = cakeService.get(Integer.parseInt(cakeId));
		cakeDetail.setCurrencyPrice(cakeService.currencyPrice(cakeDetail.getPrice()));
		req.setAttribute("cakeDetail", cakeDetail); 
		
		
		List<Cake> listCakeDetail = new ArrayList<Cake>();
		listCakeDetail = cakeService.getAll();
		for (Cake cake : listCakeDetail ) {
			String curPrice =  cakeService.currencyPrice(cake.getPrice());
			cake.setCurrencyPrice(curPrice);	
			
		
		req.setAttribute("listCakeDetail", listCakeDetail); 
		

		
		}
	
	req.getRequestDispatcher("views/client/cakeDetail.jsp").forward(req, resp);

}
}
