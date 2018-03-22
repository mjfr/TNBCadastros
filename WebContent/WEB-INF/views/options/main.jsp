<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
	<c:url value="/app/options/edit/data" var="urlNB"/>
	<c:url value="/app/options/edit/password" var="urlPsd"/>
<%-- Fim da declaração --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TNB - Profile Options</title>
</head>
	<body>
		<c:import url="../templates/loggedHead.jsp"/>
		<ul>
			<li><a href="${urlNB}">Edit name / birthday</a></li>
			<li><a href="${urlPsd}">Edit password</a></li>
		</ul>
	</body>
</html>