<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
	<c:url value="/app/options/edit/password" var="urlEdit"/>
<%-- Fim da declaração --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TNB - Password change</title>
</head>
<body>

		<%-- Verificar se foram enviados erros --%>
		
		<c:if test="${not empty errors5}">
			<div style="background-color: red; color: white">
				<%-- Faz um laço percorrendo cada erro --%>
				<c:forEach items="${errors5}" var="errors5">
					<p>${errors5}</p>
				</c:forEach>
			</div>
		</c:if>

<c:url value="/user/save" var="urlSave"/>
	<form method="post" action="${urlEdit}">
		<label>
			Old Password
			<input type="password" name="oldPassword" autofocus="autofocus">
		</label><br><br>
		<label>
			New password
			<input type="password" name="password">
		</label><br><br>
		<label>
			Confirm password
			<input type="password" name="confirmation">
		</label><br>
		<button type="submit">Save</button>
	</form>
</body>
</html>