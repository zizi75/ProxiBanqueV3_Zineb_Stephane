package org.banque.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.banque.model.Compte;

public class BanqueDAOImplCompte implements BanqueDAOCompte {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

	// Implémentation des méthodes pour le compte et redéfinition

	@Override
	public void sauvegarderCompte(Compte compte) {

		EntityManager em4 = emf.createEntityManager();
		EntityTransaction txn4 = em4.getTransaction();
		try {
			txn4.begin();
			em4.persist(compte);
			txn4.commit();

		} catch (Exception e) {
			if (txn4 != null) {
				txn4.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em4 != null) {
				em4.close();
			}
		}

	}

	Compte compte = null;

	@Override
	public Compte chercherCompteParIdDAO(Long IdCompte) {

		EntityManager em5 = emf.createEntityManager();
		EntityTransaction txn5 = em5.getTransaction();
		try {
			txn5.begin();
			compte = em5.find(Compte.class, IdCompte);
			txn5.commit();

		} catch (Exception e) {
			if (txn5 != null) {
				txn5.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em5 != null) {
				em5.close();
			}
		}
		return compte;
	}

	@Override
	public void modifierCompteDAO(Long idCompte, Double nouveauSolde) {

		EntityManager em6 = emf.createEntityManager();
		EntityTransaction txn6 = em6.getTransaction();
		try {
			txn6.begin();
			compte = em6.find(Compte.class, idCompte);
			compte.setSolde(nouveauSolde);
			txn6.commit();

		} catch (Exception e) {
			if (txn6 != null) {
				txn6.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em6 != null) {
				em6.close();
			}
		}

	}

	@Override
	public void supprimerCompteDAO(Long idCompte) {

		EntityManager em6 = emf.createEntityManager();
		EntityTransaction txn6 = em6.getTransaction();
		try {
			txn6.begin();
			compte = em6.find(Compte.class, idCompte);
			em6.remove(compte);
			txn6.commit();

		} catch (Exception e) {
			if (txn6 != null) {
				txn6.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em6 != null) {
				em6.close();
			}
		}

	}

	@Override
	public List<Compte> afficherTousComptes() {

		EntityManager em7 = emf.createEntityManager();
		EntityTransaction txn7 = em7.getTransaction();

		List<Compte> listeCompte = new ArrayList<Compte>();

		try {
			txn7.begin();
			TypedQuery<Compte> tqc = em7.createQuery("FROM Compte", Compte.class);
			listeCompte = tqc.getResultList();

			txn7.commit();

		} catch (Exception e) {
			if (txn7 != null) {
				txn7.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em7 != null) {
				em7.close();
			}
		}

		return listeCompte;
	}

}
