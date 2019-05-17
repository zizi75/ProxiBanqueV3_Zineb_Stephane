<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultat de recherche client</title>
</head>
<body>
	<h1>Voici les données de votre client recherché</h1>

	<%-- <c:forEach items="${client}" var="u"> --%>
	<p />
	Nom du client : ${client.nom}
	<%-- </c:forEach> --%>
</p>Prénom du client : ${client.prenom}
</p>Adresse du client : ${client.adresse}
</p>Email du client : ${client.email}
</p>Compte client : ${client.compte}
</body>
</html>