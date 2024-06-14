package com.cab.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cab.dto.BookedCabs;
import com.cab.service.IUserService;
import com.cab.service.UserServiceImple;


@WebServlet("/mybookings")
public class MyBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService userService = null;
	List<BookedCabs> myBookings = null;
	RequestDispatcher reqDisp = null;
	HttpSession session = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession(false);
		String username = request.getParameter("username");
		
		userService = new UserServiceImple();
		
		myBookings = userService.myBookings(username);
		
		request.setAttribute("books", myBookings);
		reqDisp = request.getRequestDispatcher("./MyBookings.jsp");
		reqDisp.forward(request, response);
	
	}

}
