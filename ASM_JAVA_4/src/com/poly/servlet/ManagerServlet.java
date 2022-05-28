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
import com.poly.model.Manager;

/**
 * Servlet implementation class Manager
 */
@WebServlet({"/Manager","/Manager/create","/Manager/update","/Manager/delete"})
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    int begin=0;
    int end=0;
    int count=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ManagerDAO managerDAO=new ManagerDAO();
		List<Manager> list =managerDAO.findAll();
		request.setAttribute("manager", list);  
		count=list.size();
		
		try {
			int page=Integer.parseInt(request.getParameter("page"));
			begin=page*5-5;
			double count_real=count;
			double soTrang=count_real/5;
			if(soTrang>page) {
				end=page*5-1;
			}else {
				end=count-1;
			}
			request.setAttribute("begin", begin);
		}catch (Exception e) {
			request.setAttribute("begin", 0);
			if(list.size()>5) {
				end=4;
			}
		}
		System.out.println(begin);
		System.out.println(end);
		request.setAttribute("end", end);
		request.setAttribute("size", count);
		int page_count=(count/5)+1;
		request.setAttribute("page_count",page_count);
		request.getRequestDispatcher("/views/CRUD.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uriString=request.getRequestURI();
		ManagerDAO managerDAO=new ManagerDAO();
		Manager manager =new Manager();
		try {
			BeanUtils.populate(manager, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uriString.contains("create")) {
			managerDAO.insert(manager);doGet(request, response);
		}else if(uriString.contains("update")) {
			managerDAO.update(manager);doGet(request, response);
		}else if(uriString.contains("delete")) {
			String user=request.getParameter("username");	
			managerDAO.delete(user); doGet(request, response);
		}else if(uriString.contains("page")) {
			request.setAttribute("end", end);request.getRequestDispatcher("/views/CRUD.jsp").forward(request, response);
		}
		
	}

}
