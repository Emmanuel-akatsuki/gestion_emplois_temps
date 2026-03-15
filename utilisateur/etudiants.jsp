<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelisations.Etudiant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Étudiants</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/utilisateur/style.css">
</head>

<body>
<jsp:include page="navbar.jsp"/>

<div class="main">
    <div class="header">
        <h2>Liste des Étudiants</h2>
    </div>

    <button class="action-btn add">Ajouter Étudiant</button>

    <table border="1">
        <thead>
        <tr>
            <th>Matricule</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Niveau</th>
            <th>Filière</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Etudiant> list = (List<Etudiant>) request.getAttribute("etudiants");

            if(list != null && !list.isEmpty()){
                for(Etudiant e : list){
        %>
        <tr>
            <td><%= e.getMatricule() %></td>
            <td><%= e.getNom() %></td>
            <td><%= e.getPrenom() %></td>
            <td><%= e.getNiveau() %></td>
            <td><%= e.getFiliere() %></td>
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
            <td colspan="6" style="text-align:center;">Aucun étudiant trouvé.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
