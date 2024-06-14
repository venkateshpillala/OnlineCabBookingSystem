package com.cab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cab.dto.*;
import com.cab.service.UserServiceImple;

@WebServlet("/userregistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User user = null;
	RequestDispatcher reqDisp = null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		user = new User();
		
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setDOB(request.getParameter("DOB"));
		user.setGender(request.getParameter("gender"));
		user.setAddress(request.getParameter("address"));
		user.setUserNumber(request.getParameter("number"));
		
		String result = new UserServiceImple().insertUser(user);
		
		if("success".equals(result)) {
			reqDisp = request.getRequestDispatcher("./User.html");
			reqDisp.forward(request, response);
		}
	
	}

}
