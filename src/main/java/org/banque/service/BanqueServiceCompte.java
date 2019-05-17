package org.banque.service;

import java.util.List;

import org.banque.model.Client;
import org.banque.model.Compte;

/**
 * @author Zineb et Stephane Interface de la couche m�tier relayant l'ensemble des op�rations de l'interface DAO :
 * creer, chercher, modifier, supprimer un Compte, cr�diter ou retirer un montant, effectuer un virement ou encore de lister les comptes
 *
 */
public interface BanqueServiceCompte {

	public void creerCompte(Compte compte);
	
	public List<Compte> afficherListeCompte();

	public Compte chercherCompteParId(Long idCompte);

	public void modifierCompte(Long idCompte, Double solde);

	public void supprimerCompte(Long idCompte);

	public void retirerCompte(Long idCompte, Double montant);

	public void crediterCompte(Long idCompte, Double montant);

	public void virerCompte_A_vers_B(Long idCompte1, Long idCompte2, Double montant);

}
