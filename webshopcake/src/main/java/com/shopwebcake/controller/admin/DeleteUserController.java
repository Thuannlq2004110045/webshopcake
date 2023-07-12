package com.shopwebcake.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopwebcake.service.IUserService;
import com.shopwebcake.service.impl.UserService;

@WebServlet(urlPatterns = {"/delete-user"})
public class DeleteUserController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId =  req.getParameter("userId");
        IUserService userService = new UserService();
        userService.delete(Integer.parseInt(userId));
		resp.sendRedirect(req.getContextPath() + "/admin-user-list");
    }
}
