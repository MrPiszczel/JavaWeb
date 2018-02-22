package servlety;

import java.io.IOException;
import java.util.List;


import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BazaDanych.DataBase;
import Klasy.Uzytkownik;

@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		
		DataBase db = new DataBase();
		TypedQuery<Uzytkownik> query = db.check().createQuery("SELECT n FROM Uzytkownik n", Uzytkownik.class);
		List<Uzytkownik> resultList = query.getResultList();
		
	

		for (Uzytkownik uzytkownik : resultList) {

			if (uname.equals(uzytkownik.getName()) && pass.equals(uzytkownik.getHaslo1())) {

				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
				requestDispatcher.forward(request, response);
			}

		}

	}
}
