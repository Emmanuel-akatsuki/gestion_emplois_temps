<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelisations.Enseignant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Enseignants</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/utilisateur/style.css">
</head>

<body>
<jsp:include page="navbar.jsp"/>

<div class="main">
    <div class="header">
        <h2>Liste des Enseignants</h2>
    </div>

    <button class="action-btn add">Ajouter Enseignant</button>

    <table border="1">
        <thead>
        <tr>
            <th>Matricule</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Spécialité</th>
            <th>Grade</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%

            List<Enseignant> list = (List<Enseignant>) request.getAttribute("enseignants");

            if(list != null && !list.isEmpty()){
                for(Enseignant e : list){
        %>
        <tr>
            <td><%= e.getMatricule() %></td>
            <td><%= e.getNom() %></td>
            <td><%= e.getPrenom() %></td>
            <td><%= e.getSpecialite() %></td>
            <td><%= e.getGrade() %></td>
            <td><%= e.getEmail() %></td>
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
            <td colspan="7" style="text-align:center;">Aucun enseignant trouvé.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
