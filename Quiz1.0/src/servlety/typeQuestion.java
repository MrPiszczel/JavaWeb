package servlety;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BazaDanych.DataBase;
import Klasy.Pytania;

@WebServlet("/typeQuestion")
public class typeQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataBase dataBase = new DataBase();
		TypedQuery<Pytania> createQuery = dataBase.check().createQuery("SELECT q FROM Pytania q", Pytania.class);
		List<Pytania> resultList = createQuery.getResultList();
		List<Pytania> listQuestion = new ArrayList<>();

		for (Pytania pytania : resultList) {

			Pytania question = new Pytania();
			question.setId(pytania.getId());
			question.setQuestion(pytania.getQuestion());

			listQuestion.add(question);

		}

		request.setAttribute("list", listQuestion);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("welcome.jsp");
		requestDispatcher.forward(request, response);

	}

}
