package org.banque.persistence;

import java.util.List;

import org.banque.model.Client;
import org.banque.model.Compte;

public interface BanqueDAO {

// Opérations concernant le client	
	public void sauvegarder(Client client);

	public Client chercherParId(Long idClient);

	public void modifierClient(Long idClient, String nouveauNom);

	public void supprimerClient(Long idClient);

	public List<Client> afficherTousClients();


}
