package com.poly.fitler;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.model.Client;
import com.poly.model.Manager;

@WebFilter(filterName = "AuthFilter" , urlPatterns = {"/taikhoan","/Manager","/Manager/*","/cart","/cart_remove"})
public class AuthFilter implements HttpFilter{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String uri = req.getRequestURI();
		Manager user = (Manager) req.getSession().getAttribute("user");
		Client client = (Client) req.getSession().getAttribute("client");
		if(user!=null) {
			System.out.println(1);
			System.out.println("role: "+user.getRole());
			System.out.println(2);
		}
		String error = "";
		try {
			if(user == null && client == null) {
				error = resp.encodeURL("Please login to use this function!");
			}
			else if(uri.contains("cart") || uri.contains("cart_remove")) {
				if(user!=null) {
					error = resp.encodeURL("Please login to use this function!");
				}
				else if(client == null) {
					error = resp.encodeURL("Please login to use this function!");
				}
			}
			else if(uri.contains("Manager")) {
				if(client!=null) {
					error = resp.encodeURL("Please login to use this function!");
				}
				else if(user == null) {
					error = resp.encodeURL("Please login to use this function!");
				}
				else if(user != null) {
					if(!user.getRole().toString().equals("Admin")){
						error = resp.encodeURL("Please login with admin role");
					}
				}
			}
		} catch (Exception e) {
			error = resp.encodeURL("Please login with admin role");
			e.printStackTrace();
		} 
		
		
		if(!error.isEmpty()) {
//			req.setCharacterEncoding("UTF-8");
//			resp.setCharacterEncoding("UTF-8");
//			req.getSession().setAttribute("securi", uri);
			req.getSession().setAttribute("securi", error);
			Client client2 = new Client();
			client = null;
			req.getSession().setAttribute("client", client);
			Manager manager = new Manager();
			manager = null;
			req.getSession().setAttribute("user", manager);
			System.out.println("Error!");
			resp.sendRedirect("signin"+"?message="+resp.encodeURL(error));
			}else {
				error = "";
				System.out.println("No Error!");
				chain.doFilter(req, resp);
			}
	}

	
//	private void asda() {
//		// TODO Auto-generated method stub
//		if(client != null && uri.contains("taikhoan")) {
//		}
//		else if(user == null && client == null) {
//			error = resp.encodeURL("Please login to use this function!");
//		}
//		else if(client==null && uri.contains("cart")) {
//			error = resp.encodeURL("Please login with admin role");
//		}else if((user==null || !user.getRole().toString().equals("null")) && uri.contains("Admin") ) {
//				error = resp.encodeURL("Please login with admin role");
////				
//		}
//		else if(client==null && uri.contains("cart_remove")) {
//			error = resp.encodeURL("Please login with admin role");
//		}else if( uri.contains("Admin") && client != null) {
//			error = resp.encodeURL("Please login with admin role");
////			
//		}
//	}
}
