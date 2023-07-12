package com.shopwebcake.controller.client;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopwebcake.model.Cake;
import com.shopwebcake.model.Cart;
import com.shopwebcake.model.Item;
import com.shopwebcake.service.ICakeService;
import com.shopwebcake.service.impl.CakeService;
import com.shopwebcake.util.CurrencyPrice;

@WebServlet(urlPatterns = { "/edit-to-cart" })
public class CartEditController extends HttpServlet {
    ICakeService cakeService = new CakeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Object obj = httpSession.getAttribute("cart");
        CurrencyPrice currencyPrice = new CurrencyPrice();
        HashMap<Integer, Item> hashMapCart = (HashMap<Integer, Item>) obj; // Giỏ hàng k null thì cast về dạng Map

        httpSession.setAttribute("cart", hashMapCart);
        String cakeId = req.getParameter("cakeId");
        String stringQuantity = req.getParameter("quantity");
        System.out.println(stringQuantity);
        int quantity = Integer.parseInt(stringQuantity);
        Cake cake = cakeService.get(Integer.parseInt(cakeId));
        cake.setCurrencyPrice(cakeService.currencyPrice(cake.getPrice()));
        Item item = new Item();
        item.setQuantity(quantity);
        item.setUnitPrice(quantity * cake.getPrice());
        item.setCake(cake);

        Item existedCartItem = hashMapCart.get(Integer.valueOf(cakeId));// Lay item co key la cakeId trong hashMapCart
        existedCartItem.setQuantity(quantity);
        existedCartItem.setUnitPrice(item.getUnitPrice());
        existedCartItem.setCurrencyPrice(currencyPrice.curPrice(existedCartItem.getUnitPrice()));
        httpSession.setAttribute("cart", hashMapCart); // set hashMapCart vao session

        long totalPrice = 0;
        Cart cart = (Cart) httpSession.getAttribute("cartPrice");
        for (Item value : hashMapCart.values()) {
            totalPrice += value.getUnitPrice();
        }

        cart.setTotalPrice(totalPrice);
        String stringTotal = currencyPrice.curPrice(totalPrice);
        httpSession.setAttribute("total", stringTotal);

        resp.sendRedirect(req.getContextPath() + "/view-cart");
    }

}