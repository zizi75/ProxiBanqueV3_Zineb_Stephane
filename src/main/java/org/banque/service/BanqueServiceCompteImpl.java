package org.banque.service;

import java.util.List;

import org.banque.model.Compte;
import org.banque.persistence.BanqueDAO;
import org.banque.persistence.BanqueDAOCompte;
import org.banque.persistence.BanqueDAOImpl;
import org.banque.persistence.BanqueDAOImplCompte;

public class BanqueServiceCompteImpl implements BanqueServiceCompte {

//	public BanqueServiceCompteImpl() {
//		super();
//	}
	private BanqueDAOCompte dao = new BanqueDAOImplCompte();

	@Override
	public void creerCompte(Compte compte) {
		if (compte != null) {
			dao.sauvegarderCompte(compte);
		}
	}

	@Override
	public Compte chercherCompteParId(Long idCompte) {

		return dao.chercherCompteParIdDAO(idCompte);
	}

	@Override
	public void modifierCompte(Long idCompte, Double nouveauSolde) {
		dao.modifierCompteDAO(idCompte, nouveauSolde);

	}

	@Override
	public void supprimerCompte(Long idCompte) {
		dao.supprimerCompteDAO(idCompte);

	}

	@Override
	public void retirerCompte(Long idCompte, Double montant) {

		BanqueServiceCompte bsc = new BanqueServiceCompteImpl();
		Compte compte = chercherCompteParId(idCompte);
		compte.setSolde(compte.getSolde() - montant);
		bsc.modifierCompte(idCompte, compte.getSolde());

	}

	@Override
	public void crediterCompte(Long idCompte, Double montant) {
		
		BanqueServiceCompte bsc = new BanqueServiceCompteImpl();
		Compte compte = chercherCompteParId(idCompte);
		compte.setSolde(compte.getSolde() + montant);
		bsc.modifierCompte(idCompte, compte.getSolde());

	}

	@Override
	public void virerCompte_A_vers_B(Long idCompte1, Long idCompte2, Double montant) {

		BanqueServiceCompte bsc = new BanqueServiceCompteImpl();
		bsc.retirerCompte(idCompte1, montant);
		bsc.crediterCompte(idCompte2, montant);

	}

	@Override
	public List<Compte> afficherListeCompte() {
		List<Compte> liste = dao.afficherTousComptes();
		return liste;
	}

}
