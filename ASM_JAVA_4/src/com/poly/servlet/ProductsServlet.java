package com.poly.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.ManagerDAO;
import com.poly.dao.ProductsDAO;
import com.poly.model.Manager;
import com.poly.model.Products;

/**
 * Servlet implementation class ProductsServlet
 */@MultipartConfig
@WebServlet({"/Products","/Products/create","/Products/update","/Products/delete"})
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    int count=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductsDAO managerDAO=new ProductsDAO();
		List<Products> list =managerDAO.findAll();
		request.setAttribute("products", list);  
		count=list.size();
		request.setAttribute("size_products", count-1);
		request.getRequestDispatcher("/views/Products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriString=request.getRequestURI();
		ProductsDAO managerDAO=new ProductsDAO();
		Products manager =new Products();
		try {
			BeanUtils.populate(manager, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uriString.contains("create")) {
			Part part=request.getPart("images_flie");
			String namePcturnString=part.getSubmittedFileName();
			manager.setImages(namePcturnString);
			managerDAO.create(manager);
			doGet(request, response);
		}else if(uriString.contains("update")) {
			managerDAO.update(manager);doGet(request, response);
		}else if(uriString.contains("delete")) {
			String user=request.getParameter("username");	
			managerDAO.remove(user); doGet(request, response);
		}
		doGet(request, response);
	}

}
