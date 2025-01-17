package com.cab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cab.dto.Admin;
import com.cab.service.AdminServiceImple;
import com.cab.service.IAdminService;

@WebServlet("/changepassword")
public class AdminPasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher reqDisp = null;
	IAdminService adminService = null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String old1 = request.getParameter("old");
		String new1 = request.getParameter("new");
		String new2 = request.getParameter("again");
		
		adminService = new AdminServiceImple();
		Admin admin = adminService.getAdminDetails("admin");
		
		String old2 = admin.getPassword();
		
		request.setAttribute("new1", new1);
		request.setAttribute("new2", new2);
		request.setAttribute("old1", old1);
		request.setAttribute("old2", old2);
		
		reqDisp = request.getRequestDispatcher("./passwordChanged.jsp");
		reqDisp.forward(request, response);
		
	}

}
