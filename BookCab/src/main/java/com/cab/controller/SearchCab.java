package com.cab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cab.dto.Car;
import com.cab.service.*;

@WebServlet("/search")
public class SearchCab extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 ICabService cab = null;
	 HttpSession session = null;
	 List <Car> search= null;
	 RequestDispatcher reqDisp = null;
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fromAddress = request.getParameter("fromaddress");
		String toAddress = request.getParameter("toaddress");
		
		cab = new CabServiceImple();
		session = request.getSession(false);
		search = cab.searchCab(fromAddress, toAddress);
		
		request.setAttribute("search", search);
		reqDisp = request.getRequestDispatcher("./availableCabs.jsp");
		reqDisp.forward(request, response);
	
	}

}
