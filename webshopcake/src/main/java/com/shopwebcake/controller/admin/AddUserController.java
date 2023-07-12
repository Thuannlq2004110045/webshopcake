package com.shopwebcake.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shopwebcake.model.User;
import com.shopwebcake.service.IUserService;
import com.shopwebcake.service.impl.UserService;

@WebServlet(urlPatterns = {"/add-user"})
public class AddUserController extends HttpServlet{
    IUserService userService = new UserService();
    private  String userName;
	private String password;
	private String fullName;
	private int roleId;
	private String gmail;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-user.jsp");
		dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		String thongBao = "";
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> items = upload.parseRequest(req);
				for (FileItem item : items) {
					if (item.getFieldName().equals("username")) {
						userName = item.getString("UTF-8");
                        System.out.println(userName);
					}
					if (item.getFieldName().equals("password")) {
						password = item.getString("UTF-8");
                        System.out.println(password);
					}
					if (item.getFieldName().equals("fullname")) {
						fullName = item.getString("UTF-8");
                        System.out.println(fullName);
					}
					if (item.getFieldName().equals("roleid")) {
						roleId = Integer.parseInt(item.getString("UTF-8"));
                        System.out.println(roleId);
					}
					if (item.getFieldName().equals("email")) {
						gmail = item.getString("UTF-8");
                        System.out.println(gmail);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				thongBao = "Thêm thất bại";
			}
		}
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setFullName(fullName);
		user.setRoleId(roleId);
        user.setGmail(gmail);
		IUserService userService = new UserService();
		thongBao = "Thêm thành công";

		try {
			userService.insert(user);
            System.out.println("đã thêm user vào data");
		} catch (Exception e) {
			thongBao = "Thêm thất bại";
		}
		req.setAttribute("thongBao", thongBao);
		doGet(req, resp);
    }
}
