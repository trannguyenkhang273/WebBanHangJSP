package com.poly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.model.Client;
import com.poly.model.Manager;
@WebServlet("/taikhoan")
public class taikhoanServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Client client = (Client) req.getSession().getAttribute("client");
		
		Manager user = (Manager) req.getSession().getAttribute("user");
		if(client !=null) {
			req.setAttribute("taikhoan", client);
		}else {
			req.setAttribute("taikhoan", user);
		}
		
		req.getRequestDispatcher("/taikhoan.jsp").forward(req, resp);
	}
}
