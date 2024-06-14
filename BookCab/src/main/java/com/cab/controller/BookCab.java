package com.cab.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

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
import com.cab.service.CabServiceImple;
import com.cab.service.ICabService;
import com.cab.service.IUserService;
import com.cab.service.UserServiceImple;

@WebServlet("/book")
public class BookCab extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ICabService cabService = null;
    HttpSession session = null;
    RequestDispatcher reqDisp = null;
    IUserService userService = null;
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession(false);
		cabService = new CabServiceImple();
		
		String carNumber = request.getParameter("carNumber");
		Car car = cabService.getCarDetails(carNumber);
		User user = (User)session.getAttribute("user");

		userService = new UserServiceImple();
		String time = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
		String result = userService.bookingSuccess(user, car, time);
		
		request.setAttribute("result", result);
		
		if("success".equals(result)) {			
			BookedCabs booked = userService.getBookedCabDetails(user, car, time);
			session.setAttribute("booked", booked);
		}
		
		reqDisp = request.getRequestDispatcher("./BookingStatus.jsp");
		reqDisp.forward(request, response);
	}

}
