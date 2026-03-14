<%@ page import="java.util.*, com.gestionplanning.Enseignant" %>

<html>
<head>
<title>Gestion des Enseignants</title>
</head>

<body>

<h2>Liste des Enseignants</h2>

<table border="1">

<tr>
<th>Matricule</th>
<th>Nom</th>
<th>Prénom</th>
<th>Spécialité</th>
<th>Grade</th>
<th>Email</th>
</tr>

<%
List<Enseignant> list = (List<Enseignant>) request.getAttribute("enseignants");

if(list != null){
for(Enseignant e : list){
%>

<tr>
<td><%= e.getMatricule() %></td>
<td><%= e.getNom() %></td>
<td><%= e.getPrenom() %></td>
<td><%= e.getSpecialite() %></td>
<td><%= e.getGrade() %></td>
<td><%= e.getEmail() %></td>
</tr>

<%
}
}
%>

</table>

</body>
</html>