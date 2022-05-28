package com.poly.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.ManagerDAO;
import com.poly.dao.ProductTypeDAO;
import com.poly.model.Manager;
import com.poly.model.ProductType;
import com.poly.model.Products;

/**
 * Servlet implementation class ProductType
 */
@WebServlet({"/ProductType","/ProductType/create","/ProductType/update","/ProductType/delete"})
public class ProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    int count;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductTypeDAO productTypeDAO=new ProductTypeDAO();
		List<ProductType> list =productTypeDAO.findAll();
		request.setAttribute("productType", list);  
		count=list.size();
		request.setAttribute("size_productType", count-1);
		request.getRequestDispatcher("/views/ProductType.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriString=request.getRequestURI();
		ProductTypeDAO managerDAO=new ProductTypeDAO();
		ProductType manager =new ProductType();
		try {
			BeanUtils.populate(manager, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uriString.contains("create")) {
			managerDAO.create(manager);doGet(request, response);
		}else if(uriString.contains("update")) {
			managerDAO.update(manager);doGet(request, response);
		}else if(uriString.contains("delete")) {
			String user=request.getParameter("username");	
			managerDAO.remove(user); doGet(request, response);
		}
	}

}
