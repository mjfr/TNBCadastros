<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
		<c:url value="/app/game/form" var="urlEdit"/>
		<c:url value="/app/game/delete" var="urlDelete"/>
		<c:url value="/logout" var="urlLogout"/>
<%-- Fim da declaração --%>

<!DOCTYPE html>
<html>
<head>
<title>TNB - Games' List</title>
</head>
	<body>
		<c:import url="../templates/loggedHead.jsp"/>
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>Category</td>
					<td>Register Date</td>
					<td>Options</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${games}" var="game">
					<tr>
						<td>${game.name}</td>
						<td>${game.category}</td>
						<td>${game.registerDate}</td>
						<td>
							<a href="${urlDelete}?id=${game.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>