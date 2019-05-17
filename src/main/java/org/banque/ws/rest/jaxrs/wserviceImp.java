package org.banque.ws.rest.jaxrs;

import java.util.List;

import javax.ws.rs.core.Response;

import org.banque.model.Client;
import org.banque.model.Compte;
import org.banque.service.BanqueService;
import org.banque.service.BanqueServiceCompte;
import org.banque.service.BanqueServiceCompteImpl;
import org.banque.service.BanqueServiceImpl;

public class wserviceImp implements wservice {

	private BanqueService bs = new BanqueServiceImpl();

	public wserviceImp() {
	}

	@Override
	public Client afficherClient(String id) {
		Long longId = Long.valueOf(id);

		Client client = bs.chercherClient(longId);
		return client;
	}

	@Override
	public Response creerClient(Client client) {
		bs.creerClient(client);
		return Response.ok(client).build();
	}

	@Override
	public List<Client> afficherListClients() {

		List<Client> liste = bs.afficherListe();
		return liste;
	}

	@Override
	public Response supprimerClient(String idClient) {
		Long longId = Long.valueOf(idClient);
		bs.supprimerClient(longId);
		return Response.ok().build();
	}

	@Override
	public Response modifierClient(Client updatedclient) {
		Response response = null;
		Client client = bs.chercherClient(updatedclient.getIdClient());
		if (client != null) {
			bs.modifierClient(updatedclient.getIdClient(), updatedclient.getNom());
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}

	private BanqueServiceCompte bsc = new BanqueServiceCompteImpl();

	@Override
	public Compte afficherCompte(String id) {
		Long longId = Long.valueOf(id);

		Compte compte = bsc.chercherCompteParId(longId);

		return compte;

	}

	@Override
	public List<Compte> afficherListComptes() {
		List<Compte> liste = bsc.afficherListeCompte();
		return liste;
	}

	@Override
	public Response creerCompte(Compte compte) {
		bsc.creerCompte(compte);
		return Response.ok(compte).build();
	}

	@Override
	public Response supprimerCompte(String idcompte) {
		Long longIdCompte = Long.valueOf(idcompte);
		bsc.supprimerCompte(longIdCompte);
		return Response.ok().build();
	}

	@Override
	public Response modifierCompte(Compte updatedcompte) {
		Response response = null;
		Compte compte = bsc.chercherCompteParId(updatedcompte.getIdCompte());
		if (compte != null) {
			bsc.modifierCompte(updatedcompte.getIdCompte(), updatedcompte.getSolde());
			response = Response.ok().build();
		} else
			response = Response.notModified().build();
		return null;
	}

	@Override
	public Response retirerCompte(Compte compte, String mt) {
		Double montant = Double.valueOf(mt);
		Long idcompte = compte.getIdCompte();
		bsc.retirerCompte(idcompte, montant);
		return null;
	}

	@Override
	public Response crediterCompte(String id, String mt) {
		Double montant = Double.valueOf(mt);
		Long idcompte = Long.valueOf(id);
		bsc.crediterCompte(idcompte, montant);
		return null;
	}

	@Override
	public Response virerCompte(String id1, String id2, String mt) {
		Double montant = Double.valueOf(mt);
		Long idcompte1 = Long.valueOf(id1);
		Long idcompte2 = Long.valueOf(id2);
		bsc.virerCompte_A_vers_B(idcompte1, idcompte2, montant);
		return null;
	}

}
