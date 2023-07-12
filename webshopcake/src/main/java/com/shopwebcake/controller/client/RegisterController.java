package com.shopwebcake.controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopwebcake.service.IUserService;
import com.shopwebcake.service.impl.UserService;
import com.shopwebcake.util.Constant;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String gmail = req.getParameter("gmail");
		String fullName = req.getParameter("fullName");

		IUserService userService = new UserService();
		String thongBao = "";

		if (userService.checkExistEmail(gmail)) {
			thongBao = "Gmai đã được sử dụng! Dùng Gmail khác!";
			req.setAttribute("thongBao", thongBao);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
		}
		if (userService.checkExistUsername(userName)) {
			thongBao = "Tên đăng nhập đã được sử dụng! Dùng tên đăng nhập khác!";
			req.setAttribute("thongBao", thongBao);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);

		} else {
			userService.register(userName, password, fullName, 0, gmail);

			thongBao = "Đăng kí thành công";
			req.setAttribute("thongBao", thongBao);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);

		}
	}
}
