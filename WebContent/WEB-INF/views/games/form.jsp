<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Declaração de URLs --%>
	<c:url value="/app/game/save" var="urlSave"/>
<%-- Fim da declaração --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TNB Games register</title>
</head>
	<body>
		<c:import url="../templates/loggedHead.jsp"/>
		
		<div>
			<form method="post" action="${urlSave}">
				<input type="hidden" name="id" value="${game.id}">
				<label>
					Name
					<input type="text" name="name" value="${game.name}">
				</label>
				<label>
					Category
					<select name="category">
						<option value="SHOOTER">Shooter</option>
						<option value="RPG">RPG</option>
						<option value="PLATFORM">Platform</option>
						<option value="SPORTS">Sports</option>
						<option value="HACKANDSLASH">Hack'n Slash</option>
						<option value="OTHER">Other</option>
					</select>
				</label>
				<button type="submit">Save</button>
				<button type="reset">Clear</button>
			</form>
		</div>
	</body>
</html>