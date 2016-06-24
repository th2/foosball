<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<title>Foosball Manager</title>
  	<link rel="stylesheet" type="text/css" href="theme.css">
</head><body>
 
<h1>Kickerturniere</h1>

<c:if test="${not empty message}">
	<br/><c:out value="${message}" /><br/>
</c:if>	

<ul>
	<c:choose>
		<c:when test="${not empty tournamentList}">
			<c:forEach var="listValue" items="${tournamentList}">
				<a href="${listValue.getName()}">
					<li class="tournamentListItem">
						<span class="name">${listValue.getName()}</span>
						<span class="status">${listValue.getStatus()}</span>
						<span class="players">0</span>
					</li>
				</a>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<li class="tournamentListItem">No current tournaments.</li>
		</c:otherwise>
	</c:choose>
	<li class="tournamentListInput">
		<form method="post"> 	
			<input type="text" name="newTournament" value="Mein Turnier" size="50" />
			<input type="submit" value="add" />
		</form>
	</li>
</ul>	

<p><a href="/foosball/addgreeting.html">Add tournament</a><br/>

Stand: <c:out value="<%=new java.util.Date()%>" />

</body></html>
