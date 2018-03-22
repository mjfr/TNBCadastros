<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
	<c:url value="/app/anime/form" var="urlForm"/>
	<c:url value="/app/anime/list" var="urlListA"/>
<%-- Fim da declaração --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TNB - Animes</title>
</head>
	<body>
		<c:import url="../templates/loggedHead.jsp"/>
		<ul>
			<li><a href="${urlForm}">Add an anime!</a></li>
			<li><a href="${urlListA}">Animes list</a></li>
		</ul>
	</body>
</html>