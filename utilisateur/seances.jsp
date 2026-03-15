<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelisations.Seance" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Séances - Planning App</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/utilisateur/style.css">
</head>

<body>
<jsp:include page="navbar.jsp"/>

<div class="main">
    <div class="header">
        <h2>Liste des Séances de Cours</h2>
    </div>

    <button class="action-btn add">Ajouter une Séance</button>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Jour</th>
            <th>Heure Début</th>
            <th>Heure Fin</th>
            <th>Cours (ID)</th>
            <th>Salle (ID)</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Seance> list = (List<Seance>) request.getAttribute("seances");

            if(list != null && !list.isEmpty()){
                for(Seance s : list){
        %>
        <tr>
            <td><%= s.getIdSeance() %></td>
            <td><%= s.getJour() %></td>
            <td><%= s.getHeureDebut() %></td>
            <td><%= s.getHeureFin() %></td>
            <td><%= s.getIdCours() %></td>
            <td><%= s.getIdSalle() %></td>
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
            <td colspan="7" style="text-align:center;">Aucune séance planifiée.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
