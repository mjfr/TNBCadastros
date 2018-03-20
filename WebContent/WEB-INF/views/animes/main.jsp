<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
	<c:url value="/app/anime/form" var="urlForm"/>
<%-- Fim da declaração --%>

<!DOCTYPE html>
<html>
<head>
<title>TNB - Animes</title>
</head>
	<body>
		<c:import url="../templates/loggedHead.jsp"/>
		<a href="${urlForm}">Add an anime!</a>
	</body>
</html>