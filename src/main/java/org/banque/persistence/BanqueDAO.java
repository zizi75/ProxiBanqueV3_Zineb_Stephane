package org.banque.persistence;

import java.util.List;

import org.banque.model.Client;
import org.banque.model.Compte;

/**
 * @author Zineb et Stephane Interface effectuant les op�rations de persistance relatives aux Clients :
 *  sauvegarder dans la base de donn�es, rechercher Par Id, modifier un client, supprimer un client ou lister l'ensemble des clients
 *
 */
public interface BanqueDAO {

// Op�rations concernant le client	
	public void sauvegarder(Client client);

	public Client chercherParId(Long idClient);

	public void modifierClient(Long idClient, String nouveauNom);

	public void supprimerClient(Long idClient);

	public List<Client> afficherTousClients();


}
