package com.poly.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.dao.BillDAO;
import com.poly.dao.BillDetailsDAO;
import com.poly.dao.ProductsDAO;
import com.poly.model.Bill;
import com.poly.model.BillDetails;
import com.poly.model.Products;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet({"/cart","/cart/create","/cart/update","/cart_remove"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String urlString=req.getRequestURI();
    	String maSP=req.getParameter("cart");
    	
    	ProductsDAO productsDAO=new ProductsDAO();
		BillDAO billDAO=new BillDAO();
		BillDetailsDAO billDetailsDAO=new BillDetailsDAO();
		
		Bill bill=new Bill();
		bill=new Bill("tho123",0,"","","",false) ;
		try {
			bill=billDAO.findByUser("tho123");
			if(urlString.contains("cart_remove")) {
	    		BillDetails products=billDetailsDAO.findByProdcut(maSP, bill.getBillId());
	    		billDetailsDAO.delete(products.getBillDetailsId());
	    	}else {
	    		billDetailsDAO.insert(new BillDetails(bill.getBillId(), maSP, 1, 10000));
	    	}
		} catch (Exception e) {
			e.printStackTrace();
			billDAO.insert(bill);
		} 
		
    	
    	
		
		
		
		
		 
		
		List<Products> list=productsDAO.findByidBill(bill.getBillId());
		req.setAttribute("size", list.size()); 
		
		req.setAttribute("cart_detail", list); 
		
		req.getRequestDispatcher("/shop_cart.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doPost(req, resp);
    }
	

}
