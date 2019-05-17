package org.banque.ws.rest.jaxrs;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.banque.model.Client;
import org.banque.model.Compte;

/**
 * @author Zineb et Stephane Interface Webservices donnant les adresses et les méthodes au resteur.
 *  On pourra donc y effectuer l'ensemble des opérations liées aux Clients ou Comptes en utlisant les méthodes PUT, GET, DELETE et POST.
 *  
 *  Cependant, les trois fonctions retirer, crediter ou virer ne sont pas encore opérationnelles à ce niveau de version
 *
 */
@Produces({ "application/xml", "application/json" })
public interface wservice {

	@GET
	@Path("/clients/{id}")
	Client afficherClient(@PathParam("id") String id);

	@GET
	@Path("/clients/")
	List<Client> afficherListClients();

	@POST
	@Path("/clients/")
	Response creerClient(Client client);

	@DELETE
	@Path("/clients/{id}")
	Response supprimerClient(@PathParam("id") String idClient);

	@PUT
	@Path("/clients/")
	Response modifierClient(Client updatedclient);

	@GET
	@Path("/comptes/{id}")
	Compte afficherCompte(@PathParam("id") String id);

	@GET
	@Path("/comptes/")
	List<Compte> afficherListComptes();

	@POST
	@Path("/comptes/")
	Response creerCompte(Compte compte);

	@DELETE
	@Path("/comptes/{id}")
	Response supprimerCompte(@PathParam("id") String idcompte);

	@PUT
	@Path("/comptes/")
	Response modifierCompte(Compte updatedcompte);
	
	@PUT
	@Path("/comptes_retirer/{montant}")
	Response retirerCompte(Compte compte, @PathParam("montant") String montant);
	
	@PUT
	@Path("/comptes_crediter/{id}/{montant}")
	Response crediterCompte(@PathParam("id") String idcompte, @PathParam("montant") String montant);
	
	@PUT
	@Path("/comptes_virer/{id}/{id}/{montant}")
	Response virerCompte(@PathParam("id") String idcompte1,@PathParam("id") String idcompte2, @PathParam("montant") String montant);

	
}
