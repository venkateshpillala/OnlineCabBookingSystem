package com.cab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cab.service.*;
import com.cab.dto.*;


@WebServlet("/cabregistration")
public class CabRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher reqDisp = null;
	Car car = null;
	ICabService cabService = null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		car = new Car();
		
		car.setCarNumber(request.getParameter("carnumber"));
		car.setDriverName(request.getParameter("drivername"));
		car.setCarColour(request.getParameter("carcolour"));
		car.setFromAddress(request.getParameter("fromaddress"));
		car.setToAddress(request.getParameter("toaddress"));
		car.setCarType(request.getParameter("cartype"));
		car.setDriverNumber(request.getParameter("drivernumber"));
		
		cabService = new CabServiceImple();
		String result = cabService.addCar(car);
		
		request.setAttribute("result", result);
		
		reqDisp = request.getRequestDispatcher("./carAdded.jsp");
		reqDisp.forward(request, response);
		
	}

}
