<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de création ou recherche d'un client</title>
</head>
<body>

	<form method="post" action="ServletCreerOuChercherClient">

		<fieldset>
			<legend>Formulaire de création d'un client</legend>
			<p />
			Nom : <input type="text" name="nom"
				placeholder="Entrez le nom du nouveau client" />

			<p />
			Prénom : <input type="text" name="prenom"
				placeholder="Entrez son prénom" />
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
			solde : <input type="solde" name="solde"
				placeholder="solde" />


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
			Id client (numéro d'identification du client) : <input type="text"
				name="idclient"
				placeholder="Entrez le numéro d'identification du client" />




		</fieldset>

		<input type="reset" value="Annuler" /> <input type="submit"
			value="Valider" />

	</form>


</body>
</html>