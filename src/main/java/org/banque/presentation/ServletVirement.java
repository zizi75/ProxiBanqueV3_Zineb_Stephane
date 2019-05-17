package org.banque.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.banque.model.Client;
import org.banque.model.Compte;
import org.banque.service.BanqueService;
import org.banque.service.BanqueServiceCompte;
import org.banque.service.BanqueServiceCompteImpl;
import org.banque.service.BanqueServiceImpl;

/**
 * Servlet permettant d'effectuer un virement qui sera persité dans la BDD simplement en répondant
 *  au formulaire de la jsp précédent "ClientCree.jsp"
 */
@WebServlet("/ServletVirement")
public class ServletVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BanqueServiceCompte bsc = new BanqueServiceCompteImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVirement() {
		super();
		// TODO Auto-generated constructor stub
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

		String mt = request.getParameter("montant");
		String id1 = request.getParameter("idCompte1");
		String id2 = request.getParameter("idCompte2");

//		Long idcompte = Long.valueOf(compte_id);
		Double montant = Double.valueOf(mt);
		Long idcompte1 = Long.valueOf(id1);
		Long idcompte2 = Long.valueOf(id2);


		bsc.virerCompte_A_vers_B(idcompte1, idcompte2, montant);
		
//		Compte compte = bsc.chercherCompteParId(idcompte2);
//
//		request.setAttribute("compte", compte);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("ClientCree.jsp");
		requestdispatcher.forward(request, response);

		doGet(request, response);
	}

}
