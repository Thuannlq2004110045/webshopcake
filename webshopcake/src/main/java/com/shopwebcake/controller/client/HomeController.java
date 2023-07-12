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
import com.shopwebcake.service.ICakeService;
import com.shopwebcake.service.impl.CakeService;

@WebServlet(urlPatterns = { "/trangchu" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -3174806044336963125L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICakeService cakeService = new CakeService();
		List<Cake> listCakeDetail = new ArrayList<Cake>();
		listCakeDetail = cakeService.getAll(); // Lấy list allCake
		for (Cake cake : listCakeDetail) {
			String curPrice = cakeService.currencyPrice(cake.getPrice());
			cake.setCurrencyPrice(curPrice);

			req.setAttribute("listCakeDetail", listCakeDetail);
		}

		List<Cake> cakeSearchByCategory = cakeService.searchByCategory(4); // Lấy listcake bằng categoryId

		for (Cake cake : cakeSearchByCategory) {
			String curPrice = cakeService.currencyPrice(cake.getPrice());
			cake.setCurrencyPrice(curPrice); // Định dạng tiền tệ
			req.setAttribute("cakeSearchByCategory1", cakeSearchByCategory);

		}

		RequestDispatcher rd = req.getRequestDispatcher("views/client/home.jsp");
		rd.forward(req, resp);

	}

}
