<%@ page import="java.util.*, com.gestionplanning.Seance" %>

<html>
<head>
<title>Seances</title>
</head>

<body>
<jsp:include page="navbar.jsp"/>
<h2>Liste des Séances</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Date</th>
<th>Heure Début</th>
<th>Heure Fin</th>
</tr>

<%
List<Seance> list = (List<Seance>) request.getAttribute("seances");

if(list != null){
for(Seance s : list){
%>

<tr>
<td><%= s.getIdSeance() %></td>
<td><%= s.getDateSeance() %></td>
<td><%= s.getHeureDebut() %></td>
<td><%= s.getHeureFin() %></td>
</tr>

<%
}
}
%>

</table>

</body>
</html>