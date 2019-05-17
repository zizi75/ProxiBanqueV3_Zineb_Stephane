<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'authentification du conseiller</title>
</head>
<body>

	<h1>Bienvenue au conseiller BroxiBanque !</h1>
	<h2>Pour vous connectez, veuillez renseigner vos identifiants
		ci-dessous :</h2>


	<form method="post" action="ServletLogin">

		<fieldset>

			<p />
			Login : <input type="text" name="login"
				placeholder="Veuillez entrer votre logn" />
			<p />
			Mot de passe : <input type="password" name="mdp"
				placeholder="Veuillez entrer votre mot de passe" />
			<p />
		</fieldset>

		<input type="submit" value="Envoyer" />

	</form>




</body>
</html>