package com.poly.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.ClientDAO;
import com.poly.dao.ManagerDAO;
import com.poly.model.Client;
import com.poly.model.Manager;
@WebServlet({"/signin","/signup","/signout"})
public class SignInServlet extends HttpServlet{
	
	ManagerDAO managerdao = new ManagerDAO();
	ClientDAO clientdao =  new ClientDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if(url.contains("signin")) {
			doSignin(req, resp);
		}else if(url.contains("signup")) {
			dodangky(req, resp);
		}else if(url.contains("signout")) {
			signout(req, resp);
		}
	}
	
	public void doSignin(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		String method = req.getMethod();
		System.out.println(method);
		if(method.equalsIgnoreCase("POST")) {
			String id = req.getParameter("id");
			String pw = req.getParameter("password");
			try {
				Manager manager = new Manager();
				manager = managerdao.findById(id);
				Client client = new Client();
				client = clientdao.findByid(id);
				if(client!=null) {
					if(!client.getPassword().equals(pw)) {
						req.setAttribute("message", "Sai mật khẩu!");
						req.getRequestDispatcher("/signin.jsp").forward(req, resp);
						}
					else {
						req.setAttribute("message", "Đăng nhập thành công!");
						req.getSession().setAttribute("client", client);
						manager = null;
						req.getSession().setAttribute("user", manager);
						resp.sendRedirect("index");
						return;
						}
				}
				else if(manager!=null) {
					if(!manager.getPassword().equals(pw)) {
						req.setAttribute("message", "Sai mật khẩu!");
						req.getRequestDispatcher("/signin.jsp").forward(req, resp);
					}
					else {
						req.setAttribute("message", "Đăng nhập thành công!");
						if(manager.getRole().equalsIgnoreCase("admin")) {
//							manager.setRole(null);
						}
						req.getSession().setAttribute("user", manager);
						client = null;
						req.getSession().setAttribute("client", client);
						resp.sendRedirect("index");
						return;
					}
				}
				else if(manager==null&&client==null) {
					req.setAttribute("message", "Sai tên đăng nhập!");
					req.getRequestDispatcher("/signin.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				req.setAttribute("message", "Sai tên đăng nhập!");
				req.getRequestDispatcher("/signin.jsp").forward(req, resp);
				System.out.println("2");
			}
			
		}else {
			req.getRequestDispatcher("/signin.jsp").forward(req, resp);
		}
		
	}
	
	public void dodangky(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		String method = req.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			try {
				Client manager = new Client();
				BeanUtils.populate(manager, req.getParameterMap());
				clientdao.create(manager);
				req.setAttribute("message", "Đăng ký thành công!");
			} catch (Exception e) {
				req.setAttribute("message", "Lỗi đăng ký!");
				
			}
		}
		req.getRequestDispatcher("/signup.jsp").forward(req, resp);
		
	}
	
	public void signout(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
		req.setAttribute("message", "Đăng xuất thành công!");
		Client client = new Client();
		client = null;
		req.getSession().setAttribute("client", client);
		Manager manager = new Manager();
		manager = null;
		req.getSession().setAttribute("user", manager);
		resp.sendRedirect("index");
	}
}
