<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
		<c:url value="/app/anime/form" var="urlEdit"/>
		<c:url value="/app/anime/delete" var="urlDelete"/>
		<c:url value="/logout" var="urlLogout"/>
<%-- Fim da declaração --%>

<!DOCTYPE html>
<html>
<head>
<title>TNB - Animes' List</title>
</head>
	<body>
		<c:import url="../templates/loggedHead.jsp"/>
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>Register Date</td>
					<td>Options</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${animes}" var="anime">
					<tr>
						<td>${anime.name}</td>
						<td>${anime.registerDate}</td>
						<td>
							<a href="${urlDelete}?id=${anime.id}">Delete</a>
							<a href="${urlEdit}?id=${anime.id}">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>