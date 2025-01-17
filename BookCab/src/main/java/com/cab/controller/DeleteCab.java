package com.cab.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cab.persistence.AdminDaoImple;
import com.cab.persistence.IAdminDao;


@WebServlet("/deletecab")
public class DeleteCab extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IAdminDao adminDao = null;
	RequestDispatcher reqDisp = null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String carNumber = request.getParameter("cabNumber");
		adminDao = new AdminDaoImple();
		String result = adminDao.removeCab(carNumber);
		request.setAttribute("result",result);
		reqDisp = request.getRequestDispatcher("./deleteCab.jsp");
		reqDisp.forward(request, response);
	
	}

}
