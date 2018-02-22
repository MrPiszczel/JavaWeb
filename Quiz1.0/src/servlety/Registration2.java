package servlety;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BazaDanych.DataBase;




@WebServlet("/Registration2")
public class Registration2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("login");
		String haslo1 = request.getParameter("haslo1");
		String haslo2 = request.getParameter("haslo2");
		
		if(name != "" && haslo1 != "" && haslo1.equals(haslo2)){
			
			DataBase db = new DataBase();
			db.addUser(name, haslo1);
			
			response.sendRedirect("index.jsp");
		}
		else
			response.sendRedirect("registration.jsp");
	
		//System.out.println(name);
		//System.out.println(haslo1 + " " + haslo2);
		
	}
}