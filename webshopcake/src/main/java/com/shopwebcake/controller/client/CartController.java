package com.shopwebcake.controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopwebcake.model.Item;
import com.shopwebcake.util.CurrencyPrice;

@WebServlet(urlPatterns = { "/view-cart" })
public class CartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart"); // Lay hashMapCart tu session
		HashMap<Integer, Item> hashMapCart = (HashMap<Integer, Item>) obj;

		if(hashMapCart == null){
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/cart.jsp");
			dispatcher.forward(req, resp);
		}else{
			// Định dạng tiền tệ các item trong hashMapCart
			// Set set = hashMapCart.keySet();
			for (Object key : hashMapCart.keySet()) {
				CurrencyPrice curPrice = new CurrencyPrice();
				String string = curPrice.curPrice(hashMapCart.get(key).getUnitPrice());
				hashMapCart.get(key).setCurrencyPrice(string);
	
			}
	
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/cart.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
