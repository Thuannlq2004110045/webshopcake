package com.shopwebcake.controller.client;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopwebcake.model.Cart;
import com.shopwebcake.model.Item;
import com.shopwebcake.util.CurrencyPrice;

@WebServlet(urlPatterns = { "/remove-item" })
public class RemoveItemController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");// Doc tu Session ra
		String cakeId = req.getParameter("cakeId");
		if (obj != null) {
			HashMap<Integer, Item> hashMapCart = (HashMap<Integer, Item>) obj;

			Item item = hashMapCart.get(Integer.parseInt(cakeId));// lay item de cap nhat totalPrice

			Cart cart = (Cart) httpSession.getAttribute("cartPrice");
			long totalPrice = cart.getTotalPrice();
			totalPrice = totalPrice - item.getUnitPrice();
			cart.setTotalPrice(totalPrice);
			httpSession.setAttribute("cart", hashMapCart);

			CurrencyPrice currencyPrice = new CurrencyPrice();
			String stringTotal = currencyPrice.curPrice(totalPrice);
			httpSession.setAttribute("total", stringTotal);
			hashMapCart.remove(Integer.parseInt(cakeId));
			httpSession.setAttribute("cart", hashMapCart); // Cap nhat lai Session
		}
		resp.sendRedirect(req.getContextPath() + "/view-cart");
	}

}
