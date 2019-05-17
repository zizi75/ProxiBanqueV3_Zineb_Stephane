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
 * Servlet de création de client ainsi que de son compte associé. A ce niveau de version, cette servlet
 *  est la première visitée par le conseiller à la suite "CreerClientOuChercher.jsp" il sera ensuite redirigé vers 
 *  "ClientCree.jsp" qui est la même page Jsp mais avec une confirmation de création.
 *  
 *  dans ces pages web on peut aussi rechercher un client ou effectuer un virement compte à compte
 */
@WebServlet("/ServletCreerOuChercherClient")
public class ServletCreerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BanqueService bs = new BanqueServiceImpl();
	private BanqueServiceCompte bsc = new BanqueServiceCompteImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCreerClient() {
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

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String email = request.getParameter("email");
//		String compte_id = request.getParameter("compte_id");
		String solde = request.getParameter("solde");

//		Long idcompte = Long.valueOf(compte_id);
		Double sld = Double.valueOf(solde);
		
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setEmail(email);
		
		Compte compte = new Compte();
//		compte.setIdCompte(idcompte);
		compte.setSolde(sld);
		
		client.setCompte(compte);

		bsc.creerCompte(compte);
	
		bs.creerClient(client);
		request.setAttribute("client", client);
		request.setAttribute("compte", compte);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("ClientCree.jsp");
		requestdispatcher.forward(request, response);

		doGet(request, response);
	}

}
