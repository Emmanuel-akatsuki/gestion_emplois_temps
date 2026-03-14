<%@ page import="java.util.*, com.gestionplanning.Planning" %>

<html>
<head>
    <link rel="stylesheet" href="css/style.css">
<title>Planning</title>
</head>

<body>

<h2>Liste des Plannings</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Libellé</th>
<th>Semestre</th>
<th>Année Académique</th>
</tr>

<%
List<Planning> list = (List<Planning>) request.getAttribute("plannings");

if(list != null){
for(Planning p : list){
%>

<tr>
<td><%= p.getIdPlanning() %></td>
<td><%= p.getLibelle() %></td>
<td><%= p.getSemestre() %></td>
<td><%= p.getAnneeAcad() %></td>
</tr>

<%
}
}
%>

</table>
<button class="action-btn print" onclick="printProgramme()">
Imprimer Programme
</button>
<script>

function printProgramme(){

window.print();

}

</script>
</body>
</html>