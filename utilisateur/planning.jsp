<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelisations.Planning" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Planning - Gestion Emplois Temps</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/utilisateur/style.css">
    <style>
        @media print {
            .sidebar, .action-btn { display: none; }
            .main { margin-left: 0; }
        }
    </style>
</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="main">
    <div class="header">
        <h2>Liste des Plannings</h2>
        <button class="action-btn print" onclick="printProgramme()">
            Imprimer le Programme
        </button>
    </div>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Libellé</th>
            <th>Semestre</th>
            <th>Année Académique</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%

            List<Planning> list = (List<Planning>) request.getAttribute("plannings");

            if(list != null && !list.isEmpty()){
                for(Planning p : list){
        %>
        <tr>
            <td><%= p.getIdPlanning() %></td>
            <td><%= p.getLibelle() %></td>
            <td><%= p.getSemestre() %></td>
            <td><%= p.getAnneeAcad() %></td>
            <td>
                <button class="action-btn edit">Modifier</button>
                <button class="action-btn delete">Supprimer</button>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5" style="text-align:center;">Aucun planning trouvé.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<script>
    function printProgramme(){
        window.print();
    }
</script>
</body>
</html>
