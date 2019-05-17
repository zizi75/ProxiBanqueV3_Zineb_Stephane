package org.banque.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet permettant au conseiller de se loguer à l'application, à la suite de "PageLogin.jsp".
 * 
 * le mot de passe est "admin" comme le nom de l'utilisateur. A l'issue de ce login, on se retrouve sur la page
 * 
 * "CreerClientOuChercher.jsp"
 * 
 * ou à défaut "PageLoginErreur.jsp" pour recommencer le login
 * 
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String name = "admin";
	private static final String pass = "admin";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("login");
		String pass = request.getParameter("mdp");

		RequestDispatcher requestDispatcher;
		doGet(request, response);

		if ((name.equals(nom)) && (pass.equals(pass))) {
			requestDispatcher = request.getRequestDispatcher("CreerClientOuChercher.jsp");
		} else {
			requestDispatcher = request.getRequestDispatcher("PageLoginErreur.jsp");
		}
		requestDispatcher.forward(request, response);

		doGet(request, response);
	}
}
