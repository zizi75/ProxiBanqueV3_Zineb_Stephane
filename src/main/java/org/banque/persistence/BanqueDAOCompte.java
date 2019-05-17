package org.banque.persistence;

import java.util.List;

import org.banque.model.Compte;

/**
 * @author Zineb et Stephane Interface effectuant les opérations de persistance relatives aux comptes :
 * sauvegarder dans la base de données, chercher Compte Par Id, supprimer Compte ou lister les comptes
 *
 */
public interface BanqueDAOCompte {

	// Opérations concernant le compte

		public void sauvegarderCompte(Compte compte);

		public Compte chercherCompteParIdDAO(Long IdCompte);

		public void modifierCompteDAO(Long idCompte, Double nouveauSolde);

		public void supprimerCompteDAO(Long idCompte);

		public List<Compte> afficherTousComptes();

	
}
