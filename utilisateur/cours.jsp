<%@ page import="java.util.*, com.gestionplanning.Cours" %>

<html>

<head>

<title>Cours</title>

<link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="sidebar">

<h2>Planning App</h2>

<a href="dashboard.jsp">Dashboard</a>
<a href="cours">Cours</a>
<a href="enseignants">Enseignants</a>
<a href="salles">Salles</a>
<a href="etudiants">Etudiants</a>
<a href="planning">Planning</a>
<a href="seances">Séances</a>
<a href="examens">Examens</a>

</div>

<div class="main">

<div class="header">

<h1>Gestion des Cours</h1>

</div>
<button class="action-btn add">Ajouter Cours</button>
<table>

<tr>
<th>ID</th>
<th>Intitulé</th>
<th>Code</th>
<th>Type</th>
<th>Crédit</th>
<th>Actions</th>
</tr>

<%

List<Cours> coursList = (List<Cours>) request.getAttribute("coursList");

if(coursList != null){
for(Cours c : coursList){
%>

<tr>

<td><%= c.getIdCours() %></td>
<td><%= c.getIntitule() %></td>
<td><%= c.getCodeMatiere() %></td>
<td><%= c.getTypeCours() %></td>
<td><%= c.getCredit() %></td>

<td>

<button class="action-btn edit">Modifier</button>

<button class="action-btn delete">Supprimer</button>

</td>

</tr>

<%
}
}
%>

</table>
</div>

</body>

</html>