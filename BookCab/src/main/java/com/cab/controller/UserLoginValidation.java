package com.cab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cab.dto.User;
import com.cab.service.UserServiceImple;


@WebServlet("/userlogin")
public class UserLoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher reqDisp = null;
	User user = null;
	HttpSession session = null;
	
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			user = new UserServiceImple().getUserDetails(username);		
			
			session = request.getSession();
			
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				session.setAttribute("user", user);
				reqDisp = request.getRequestDispatcher("./UserLoginSuccess.jsp");
				reqDisp.forward(request, response);			
		
		}

}
