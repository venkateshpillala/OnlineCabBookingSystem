package com.cab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cab.dto.BookedCabs;
import com.cab.dto.Car;
import com.cab.dto.User;
import com.cab.persistence.IUserDao;
import com.cab.persistence.UserDaoImple;


@WebServlet("/cancel")
public class CancelBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session = null;
	IUserDao userDao = null;
	RequestDispatcher reqDisp = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String carNumber = request.getParameter("carNumber");
		String time = request.getParameter("time");
		
		session = request.getSession(false);
		Car car = (Car)session.getAttribute("car");
		User user = (User)session.getAttribute("user");
		
		userDao = new UserDaoImple();
		
		String result = userDao.cancelBooking(username, carNumber, time);
		request.setAttribute("result", result);
		reqDisp = request.getRequestDispatcher("./cancelBooking.jsp");
		reqDisp.forward(request, response);
	
	}

}
