<%@ page import="java.util.*, com.gestionplanning.Salle" %>

<html>
<head>
<title>Gestion des Salles</title>
</head>

<body>

<h2>Liste des Salles</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Nom</th>
<th>Capacité</th>
<th>Type</th>
<th>Bâtiment</th>
</tr>

<%
List<Salle> salles = (List<Salle>) request.getAttribute("salles");

if(salles != null){
for(Salle s : salles){
%>

<tr>
<td><%= s.getIdSalle() %></td>
<td><%= s.getNomSalle() %></td>
<td><%= s.getCapacite() %></td>
<td><%= s.getTypeSalle() %></td>
<td><%= s.getBatiment() %></td>
</tr>

<%
}
}
%>

</table>

</body>
</html>