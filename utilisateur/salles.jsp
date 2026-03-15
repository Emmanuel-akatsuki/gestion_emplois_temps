<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelisations.Salle" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Salles - Planning App</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/utilisateur/style.css">
</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="main">
    <div class="header">
        <h2>Liste des Salles de Classe</h2>
    </div>

    <button class="action-btn add">Ajouter une Salle</button>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom de la Salle</th>
            <th>Capacité</th>
            <th>Type</th>
            <th>Bâtiment</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Salle> sallesList = (List<Salle>) request.getAttribute("salles");

            if(sallesList != null && !sallesList.isEmpty()){
                for(Salle s : sallesList){
        %>
        <tr>
            <td><%= s.getIdSalle() %></td>
            <td><%= s.getNomSalle() %></td>
            <td><%= s.getCapacite() %> places</td>
            <td><%= s.getTypeSalle() %></td>
            <td><%= s.getBatiment() %></td>
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
            <td colspan="6" style="text-align:center;">Aucune salle enregistrée.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
