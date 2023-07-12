package com.shopwebcake.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.setCharacterEncoding("UTF-8");
        if(session != null && session.getAttribute("account")!=null){
            resp.getWriter().write("success");
            session.setAttribute("total", null); 
            session.setAttribute("quantity", null);
			session.setAttribute("cartPrice", null);
			session.setAttribute("cart", null);
        }
        else{
            resp.getWriter().write("fail");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
