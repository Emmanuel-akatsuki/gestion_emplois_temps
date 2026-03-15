<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelisations.Examen" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Examens</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/utilisateur/style.css">
</head>

<body>
<jsp:include page="navbar.jsp"/>

<div class="main">
    <div class="header">
        <h2>Liste des Examens</h2>
    </div>

    <button class="action-btn add">Programmer un Examen</button>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Session</th>
            <th>Type</th>
            <th>Date Début</th>
            <th>Date Fin</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%

            List<Examen> list = (List<Examen>) request.getAttribute("examens");

            if(list != null && !list.isEmpty()){
                for(Examen e : list){
        %>
        <tr>
            <td><%= e.getIdExamen() %></td>
            <td><%= e.getSession() %></td>
            <td><%= e.getTypeExamen() %></td>
            <td><%= e.getDateDebut() %></td>
            <td><%= e.getDateFin() %></td>
            <td>
                <button class="action-btn edit">Modifier</button>
                <button class="action-btn delete">Annuler</button>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="6" style="text-align:center;">Aucun examen programmé.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
