<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Salles - Planning App</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .modal { display: none; position: fixed; z-index: 1; left: 0; top: 0; width: 100%; height: 100%; overflow: auto; background-color: rgba(0,0,0,0.4); }
        .modal-content { background-color: #fefefe; margin: 15% auto; padding: 20px; border: 1px solid #888; width: 50%; border-radius: 8px; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; }
        .form-group input { width: 100%; padding: 8px; box-sizing: border-box; }
    </style>
</head>

<body>

<div class="sidebar"><jsp:include page="navbar.jsp"/></div>

<div class="main">
    <div class="header">
        <h2>Liste des Salles de Classe</h2>
    </div>

    <c:if test="${user.role != 'etudiant'}">
        <button class="action-btn add" onclick="document.getElementById('addModal').style.display='block'">Ajouter une Salle</button>
    </c:if>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom de la Salle</th>
            <th>Capacité</th>
            <th>Type</th>
            <th>Bâtiment</th>
            <c:if test="${user.role != 'etudiant'}">
                <th>Actions</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="s" items="${salles}">
                <tr>
                    <td>${s.idSalle}</td>
                    <td>${s.nomSalle}</td>
                    <td>${s.capacite} places</td>
                    <td>${s.typeSalle}</td>
                    <td>${s.batiment}</td>
                    <c:if test="${user.role != 'etudiant'}">
                        <td>
                            <button class="action-btn delete" onclick="if(confirm('Supprimer cette salle ?')) window.location.href='${pageContext.request.contextPath}/SalleAction/delete?id=${s.idSalle}'">Supprimer</button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            <c:if test="${empty salles}">
                <tr>
                    <td colspan="6" style="text-align:center;">Aucune salle enregistrée.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>

<c:if test="${user.role != 'etudiant'}">
    <div id="addModal" class="modal">
        <div class="modal-content">
            <h3>Ajouter une Salle</h3>
            <form action="${pageContext.request.contextPath}/SalleAction" method="post">
                <div class="form-group">
                    <label>Nom de la Salle</label>
                    <input type="text" name="nomSalle" required>
                </div>
                <div class="form-group">
                    <label>Capacité</label>
                    <input type="number" name="capacite" required>
                </div>
                <div class="form-group">
                    <label>Type de Salle</label>
                    <input type="text" name="typeSalle" required>
                </div>
                <div class="form-group">
                    <label>Bâtiment</label>
                    <input type="text" name="batiment" required>
                </div>
                <button type="submit" class="action-btn add">Enregistrer</button>
                <button type="button" class="action-btn" onclick="document.getElementById('addModal').style.display='none'">Annuler</button>
            </form>
        </div>
    </div>
</c:if>

</body>
</html>
