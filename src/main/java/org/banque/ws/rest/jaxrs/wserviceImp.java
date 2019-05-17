package org.banque.ws.rest.jaxrs;

import java.util.List;

import javax.ws.rs.core.Response;

import org.banque.model.Client;
import org.banque.service.BanqueService;
import org.banque.service.BanqueServiceImpl;

public class wserviceImp implements wservice {

	private BanqueService bs = new BanqueServiceImpl();

	public wserviceImp() {
	}

	@Override
	public Client afficherClient(String id) {
		Long longId = Long.valueOf(id);

		// System.out.println("get client" + longId);
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

}
