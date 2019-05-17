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
import org.banque.persistence.BanqueDAO;
import org.banque.service.BanqueService;
import org.banque.service.BanqueServiceCompte;
import org.banque.service.BanqueServiceCompteImpl;
import org.banque.service.BanqueServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet précédent donc "AfficherClientRecherche.jsp" donnant les caractéristiques du 
 * client en fonction de l'id rentré par l'utlisateur.
 * 
 * elle effectue donc une recherche dans la BDD grâce à bs de la classe BanqueServiceImpl
 * 
 * et envoie les infos à "AfficherClientRecherche.jsp"  avec le request.setAttribute("client", client)
 */
@WebServlet("/ServletAfficherClient")
public class ServletAfficherClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BanqueService bs = new BanqueServiceImpl();

	private static final Logger LOGGER = LoggerFactory.getLogger(ServletAfficherClient.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAfficherClient() {
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

		String idClient = request.getParameter("idclient");

		Long idclientlong = Long.valueOf(idClient);
		Client client = new Client();

		client = bs.chercherClient(idclientlong);

		LOGGER.info("client à chercher en BDD " + client);

		request.setAttribute("client", client);

		RequestDispatcher requestdispatcher = request.getRequestDispatcher("AfficherClientRecherche.jsp");
		requestdispatcher.forward(request, response);

		doGet(request, response);
	}

}
