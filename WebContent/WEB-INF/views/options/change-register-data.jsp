<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
	<c:url value="/app/options/edit/data" var="urlEdit"/>
<%-- Fim da declaração --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TNB - Data change</title>
</head>
<body>


	<form method="post" action="${urlEdit}">
		<label>
			Name
			<input type="text" name="name" autofocus="autofocus" value="${user.name}">
		</label><br>
		<label>
			Birthday
			<input type="date" name="birthday" value="${user.birthday}">
		</label><br>
		<button type="submit">Save</button>
	</form>
</body>
</html>