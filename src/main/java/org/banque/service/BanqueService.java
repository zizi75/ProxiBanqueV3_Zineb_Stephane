package org.banque.service;

import java.util.List;

import org.banque.model.Client;

/**
 * @author Zineb et Stephane Interface de la couche m�tier relayant l'ensemble des op�rations de l'interface DAO :
 * creer, chercher, modifier, supprimer un Client ou encore de les lister
 *
 */
public interface BanqueService {

	public void creerClient(Client client);

	public Client chercherClient(Long idClient);

	public void modifierClient(Long idClient, String nouvNom);

	public void supprimerClient(Long idClient);

	public List<Client> afficherListe();

}
