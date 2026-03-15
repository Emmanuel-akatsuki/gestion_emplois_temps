<%@ page import="java.util.*, com.gestionplanning.Examen" %>

<html>
<head>
<title>Examens</title>
</head>

<body>
<jsp:include page="navbar.jsp"/>

<h2>Liste des Examens</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Date</th>
<th>Type</th>
</tr>

<%
List<Examen> list = (List<Examen>) request.getAttribute("examens");

if(list != null){
for(Examen e : list){
%>

<tr>
<td><%= e.getIdExamen() %></td>
<td><%= e.getDateExamen() %></td>
<td><%= e.getTypeExamen() %></td>
</tr>

<%
}
}
%>

</table>

</body>
</html>