package com.shopwebcake.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shopwebcake.model.Cake;
import com.shopwebcake.model.Category;
import com.shopwebcake.service.ICakeService;
import com.shopwebcake.service.impl.CakeService;
import com.shopwebcake.service.impl.CategoryService;

@WebServlet("/add-product")
public class AddProductController extends HttpServlet {
	String nameCake;
	long price;
	String content;
	int categoryId;
	String thumnail;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CategoryService categoryService = new CategoryService();
		req.setAttribute("categories", categoryService.getAll());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-product.jsp");
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
				String webappPath = getServletContext().getRealPath("/") + "template/client/images";
				List<FileItem> items = upload.parseRequest(req);
				for (FileItem item : items) {
					if (!item.isFormField()) {
						String fileName = item.getName();
						thumnail = fileName;
						File uploadDir = new File(webappPath);
						if (!uploadDir.exists()) {
							uploadDir.mkdir();
						}
						File file = new File(uploadDir + File.separator + fileName);
						item.write(file);
					} else {
						if (item.getFieldName().equals("name")) {
							nameCake = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("price")) {
							price = Long.parseLong(item.getString("UTF-8"));
						}
						if (item.getFieldName().equals("content")) {
							content = item.getString("UTF-8");
						}
						if (item.getFieldName().equals("categoryId")) {
							categoryId = Integer.parseInt(item.getString("UTF-8"));
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				thongBao = "Thêm thất bại";
			}

		} else {
			req.setAttribute("thongBao", "Chưa thêm ảnh");
			return;
		}

		Cake cake = new Cake();
		cake.setCakeName(nameCake);
		cake.setPrice(price);
		cake.setContent(content);
		cake.setThumbnail(thumnail);
		Category category = new Category();
		category.setCategoryId(categoryId);
		cake.setCategory(category);
		ICakeService cakeService = new CakeService();
		thongBao = "Thêm thành công";
		try {
			cakeService.insert(cake);
		} catch (Exception e) {
			thongBao = "Thêm thất bại";
		}
		req.setAttribute("thongBao", thongBao);
		doGet(req, resp);
	}

}
