package org.banque.service;

import java.util.List;

import org.banque.model.Client;
import org.banque.model.Compte;

public interface BanqueServiceCompte {

	public void creerComptet(Long idClient, Double solde);

	public Compte chercherCompteParId(Long idCompte);

	public void modifierCompte(Long idCompte, Double solde);

	public void supprimerCompte(Long idCompte);

	public void retirerCompte(Long idCompte, Double montant);

	public void crediterCompte(Long idCompte, Double montant);

	public void virerCompte_A_vers_B(Long idCompte1, Long idCompte2, Double montant);

}
