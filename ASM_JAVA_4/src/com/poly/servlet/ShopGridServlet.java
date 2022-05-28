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

@WebServlet("/Shop-Grid")
public class ShopGridServlet extends HttpServlet{
	ProductsDAO pddao = new ProductsDAO();
	Products products = new Products();
	ImagePlus imagePlus = new ImagePlus();
	ImagePlusDAO ipdao = new ImagePlusDAO();
	ProductTypeDAO pdtdao = new ProductTypeDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		loadMenu(req, resp);
		String menu = req.getParameter("MenuItems");
		loadMenu(req, resp);
		System.out.println(menu);
		loadItems(req, resp);
		req.getRequestDispatcher("/shop_grid.jsp").forward(req, resp);
	}
	
	public void loadMenu(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.setAttribute("Menu", pdtdao.findAll());
	}
	
	public void loadItems(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String typeId = req.getParameter("idProductType");
		System.out.println(typeId);
		req.setAttribute("ItemByMenu", pddao.findByMenu(typeId));
	}
}
