package com.cab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cab.dto.Admin;
import com.cab.service.AdminServiceImple;


@WebServlet("/adminlogin")
public class AdminLoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher reqDisp = null;
	Admin admin = null;
	HttpSession session = null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		admin = new AdminServiceImple().getAdminDetails(username);		
		
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		session.setAttribute("admin", admin);
		reqDisp = request.getRequestDispatcher("./AdminLoginSuccess.jsp");
		reqDisp.forward(request, response);			
		
	
	}

}
