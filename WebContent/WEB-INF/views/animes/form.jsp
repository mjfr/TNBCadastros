<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
	<c:url value="/app/anime/save" var="urlSave"/>
<%-- Fim da declaração --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TNB Animes register</title>
</head>
	<body>
		<c:import url="../templates/loggedHead.jsp"/>
		
		<div>
			<form method="post" action="${urlSave}">
				<input type="hidden" name="id" value="${anime.id}">
				<label>
					Name
					<input type="text" name="name" value="${anime.name}">
				</label>
				<button type="submit">Save</button>
			</form>
		</div>
	</body>
</html>