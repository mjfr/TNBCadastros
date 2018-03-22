<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
	<c:url value="/app/game/form" var="urlForm"/>
	<c:url value="/app/game/list" var="urlListG"/>
<%-- Fim da declaração --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TNB - Games</title>
</head>
	<body>
		<c:import url="../templates/loggedHead.jsp"/>
		<ul>
			<li><a href="${urlForm}">Add a game!</a></li>
			<li><a href="${urlListG}">Games list</a></li>
		</ul>
	</body>
</html>