<%@ page import="java.util.*, com.gestionplanning.Etudiant" %>

<html>
<head>
<title>Gestion des Etudiants</title>
</head>

<body>

<h2>Liste des Etudiants</h2>

<table border="1">

<tr>
<th>Matricule</th>
<th>Nom</th>
<th>Prénom</th>
<th>Niveau</th>
<th>Filière</th>
</tr>

<%
List<Etudiant> list = (List<Etudiant>) request.getAttribute("etudiants");

if(list != null){
for(Etudiant e : list){
%>

<tr>
<td><%= e.getMatricule() %></td>
<td><%= e.getNom() %></td>
<td><%= e.getPrenom() %></td>
<td><%= e.getNiveau() %></td>
<td><%= e.getFiliere() %></td>
</tr>

<%
}
}
%>

</table>

</body>
</html>