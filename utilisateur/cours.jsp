<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelisations.Cours" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Cours</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/utilisateur/style.css">
</head>
<body>

<div class="sidebar">
    <jsp:include page="navbar.jsp"/>

    <h2>Planning App</h2>
    <%-- Correction des liens de navigation --%>
    <a href="${pageContext.request.contextPath}/PlanningAction">Dashboard</a>
    <a href="${pageContext.request.contextPath}/CoursAction">Cours</a>
    <a href="${pageContext.request.contextPath}/EnseignantAction">Enseignants</a>
    <a href="${pageContext.request.contextPath}/SalleAction">Salles</a>
    <a href="${pageContext.request.contextPath}/EtudiantAction">Etudiants</a>
    <a href="${pageContext.request.contextPath}/PlanningAction">Planning</a>
    <a href="${pageContext.request.contextPath}/SeanceAction">Séances</a>
    <a href="${pageContext.request.contextPath}/ExamenAction">Examens</a>
</div>

<div class="main">
    <div class="header">
        <h1>Gestion des Cours</h1>
    </div>

    <button class="action-btn add">Ajouter un Cours</button>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Intitule</th>
            <th>Code</th>
            <th>Type</th>
            <th>Crédit</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Cours> coursList = (List<Cours>) request.getAttribute("coursList");

            if(coursList != null && !coursList.isEmpty()){
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
        } else {
        %>
        <tr>
            <td colspan="6" style="text-align:center;">Aucun cours disponible.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

</body>
</html>
