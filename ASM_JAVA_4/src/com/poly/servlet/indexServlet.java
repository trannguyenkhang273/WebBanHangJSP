package com.poly.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.ImagePlusDAO;
import com.poly.dao.ProductTypeDAO;
import com.poly.dao.ProductsDAO;
import com.poly.model.ImagePlus;
import com.poly.model.Products;
@WebServlet({"/index","","/item"})
public class indexServlet extends HttpServlet{
	ProductsDAO pddao = new ProductsDAO();
	Products products = new Products(); 
	ImagePlus imagePlus = new ImagePlus();
	ImagePlusDAO ipdao = new ImagePlusDAO();
	ProductTypeDAO pdtdao = new ProductTypeDAO();
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String uri = req.getRequestURI();
//		System.out.println(uri);
//		req.setAttribute("items", pddao.findAll());
//		req.getRequestDispatcher("/index.jsp").forward(req, resp);
//	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
//		String uri1 = uri.substring("/ASMjava4/".length(), uri.lastIndexOf("/"));
//		System.out.println(uri1);
		loadMenu(req, resp);
		if(uri.equals("/ASM_JAVA_4/")||uri.contains("index")) {
			this.Index(req, resp);
		}
		else if(uri.contains("item")) {	
			this.Items(req, resp);
		}
	}
	
	
	public void loadMenu(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setAttribute("MenuItems", pdtdao.findAll());
	}
	
	public void Index(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String uri = req.getRequestURI();
//		String id = uri.substring(uri.lastIndexOf("/")+1);
		
		req.setAttribute("items", pddao.findAll());
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	public void Items(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String name = req.getParameter("idProduct") ;
		System.out.println(name);
		products = pddao.findByid(name);
		req.setAttribute("form", products);
		if(ipdao.findByIdProduct(name).size()!=0) {
			req.setAttribute("imagesPlus", ipdao.findByIdProduct(name));
		}
		req.getRequestDispatcher("/details.jsp").forward(req, resp);
	}
	
	
	
}
