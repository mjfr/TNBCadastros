<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
		<c:url value="/app/anime/new" var="urlNewAnime"/>
		<c:url value="/app/game/new" var="urlNewGame"/>
		<c:url value="/logout" var="urlLogout"/>
		<c:url value="/app/main/home" var="urlHome"/>
		<c:url value="/app/option/new" var="urlNewOptions"/>
<%-- Fim da declaração --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
	<body>
	<ul>
		<li><a href="${urlHome}">Home</a></li>
		<li><a href="${urlNewAnime}">Animes session</a></li>
		<li><a href="${urlNewGame}">Games session</a></li>
		<li><a href="${urlNewOptions}">Profile Options</a></li>
		<li><a href="${urlLogout}">Log out</a></li>
	</ul>
	</body>
</html>