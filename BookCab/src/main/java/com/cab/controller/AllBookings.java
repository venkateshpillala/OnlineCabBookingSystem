package com.cab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cab.dto.BookedCabs;
import com.cab.service.AdminServiceImple;
import com.cab.service.IAdminService;

@WebServlet("/allbookings")
public class AllBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<BookedCabs> bookedCabs = null;
	IAdminService adminService = null;
	RequestDispatcher reqDisp = null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		adminService = new AdminServiceImple();		
		bookedCabs = adminService.allBookings();	
		
		request.setAttribute("bookedCabs",bookedCabs);
		reqDisp = request.getRequestDispatcher("./AllBookings.jsp");
		reqDisp.forward(request, response);
		
	}

}
