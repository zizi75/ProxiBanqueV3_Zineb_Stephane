package org.banque.service;

import org.banque.model.Compte;

public class BanqueServiceCompteImpl implements BanqueServiceCompte{
	
	

	public BanqueServiceCompteImpl() {
		super();
	}
	
	@Override
	public void creerComptet(Long idClient, Double solde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compte chercherCompteParId(Long idCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierCompte(Long idCompte, Double solde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerCompte(Long idCompte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirerCompte(Long idCompte, Double montant) {
	
		Compte compte = chercherCompteParId(idCompte);
		compte.setSolde(compte.getSolde()-montant);
		
	}

	@Override
	public void crediterCompte(Long idCompte, Double montant) {

		Compte compte = chercherCompteParId(idCompte);
		compte.setSolde(compte.getSolde()+montant);
		
	}

	@Override
	public void virerCompte_A_vers_B(Long idCompte1, Long idCompte2, Double montant) {

		BanqueServiceCompte bsc = new BanqueServiceCompteImpl();
		bsc.retirerCompte(idCompte1, montant);
		bsc.crediterCompte(idCompte2, montant);
		
	}

}
