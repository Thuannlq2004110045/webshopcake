package com.shopwebcake.controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopwebcake.model.User;
import com.shopwebcake.service.IUserService;
import com.shopwebcake.service.impl.UserService;
import com.shopwebcake.util.Constant;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);// Trả về session hiện tại

		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/trangchu");
			return;
		}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/trangchu");
					return;
				}
			}
		}

		req.getRequestDispatcher("views/client/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password"); // Lấy userName và pass từ req

		String alertMsg = "";

		IUserService service = new UserService();

		User user = service.login(userName, password); // Lấy user từ db

		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			session.setAttribute("fullname", user.getFullName()); // Nếu user khác null thì tạo session và set user và fullName vào session
																	
			if (user.getRoleId() == 1) {
				resp.sendRedirect(req.getContextPath() + "/admin-trangchu");// userId bằng 1 thì trả về trang admin
			} else {
				resp.sendRedirect(req.getContextPath() + "/trangchu"); // userId bằng 2 thì trả về trang client
			}

		} else {
			alertMsg = "Tên đăng nhập hoặc mật khẩu không đúng!"; // user bằng null trả về lỗi ra client
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("views/client/login.jsp").forward(req, resp);
		}
	}
}
