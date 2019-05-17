<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de validation de cr�ation du client</title>
</head>
<body>
	Votre nouveau client ProxiBanque a �t� cr��, Merci !!

	<h1>Voici les donn�es de votre nouveau client cr�e et son compte
		associ�</h1>

	Nom du client : ${client.nom}
	</p>
	Pr�nom du client : ${client.prenom}
	</p>
	Adresse du client : ${client.adresse}
	</p>
	Email du client : ${client.email}
	</p>
	Compte client : ${client.compte}

	</p>
	</p>
	</p>

	<form method="post" action="ServletCreerOuChercherClient">

		<fieldset>
			<legend>Formulaire de cr�ation d'un client</legend>
			<p />
			Nom : <input type="text" name="nom"
				placeholder="Entrez le nom du nouveau client" />

			<p />
			Pr�nom : <input type="text" name="prenom"
				placeholder="Entrez son pr�nom" />
			<p />
			Adresse : <input type="text" name="adresse"
				placeholder="Entrez son adresse" />
			<p />
			Email : <input type="email" name="email"
				placeholder="Entrez son email" />

			<p />
			<!-- 			compte_id : <input type="compte_id" name="compte_id" -->
			<!-- 				placeholder="compte_id" /> -->

			<!-- 			<p /> -->
			solde : <input type="solde" name="solde" placeholder="solde" />


		</fieldset>

		<input type="reset" value="Annuler" /> <input type="submit"
			value="Valider" />


	</form>
	</p>
	</p>
	</p>


	<form method="post" action="ServletAfficherClient">

		<fieldset>
			<legend>Formulaire de recherche d'un client</legend>
			<p />
			Id client (num�ro d'identification du client) : <input type="text"
				name="idclient"
				placeholder="Entrez le num�ro d'identification du client" />

		</fieldset>

		<input type="reset" value="Annuler" /> <input type="submit"
			value="Valider" />

	</form>
	<form method="post" action="ServletVirement">

		<fieldset>
			<legend>Effectuer un virement compte1 � compte2</legend>
			<p />
			idCompte1: <input type="text" name="idCompte1"
				placeholder="id compte � d�biter" />

			<p />
			idCompte2: <input type="text" name="idCompte2"
				placeholder="id compte � cr�diter" />
				
				<p />
			Montant � virer: <input type="text"
				name="montant"
				placeholder="montant � virer" />

				

		</fieldset>

		<input type="reset" value="Annuler" /> <input type="submit"
			value="Valider" />

	</form>


</body>
</html>