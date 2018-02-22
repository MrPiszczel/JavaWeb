package servlety;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BazaDanych.DataBase;

@WebServlet("/ContentQuestion")
public class ContentQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String subject = request.getParameter("subject");
		String answer1 = request.getParameter("answer1");
		String answer2 = request.getParameter("answer2");
		String answer3 = request.getParameter("answer3");
		String answer4 = request.getParameter("answer4");
		String trueAnswer = request.getParameter("trueAnswer");

		DataBase db = new DataBase();
		db.addQuestion(subject, answer1, answer2, answer3, answer4, trueAnswer);

		
		response.sendRedirect("welcome.jsp");

	}
}
