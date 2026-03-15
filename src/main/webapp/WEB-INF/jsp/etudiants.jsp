<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Étudiants</title>
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
        <h2>Liste des Étudiants</h2>
    </div>

    <button class="action-btn add" onclick="document.getElementById('addModal').style.display='block'">Ajouter Étudiant</button>

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
            <c:forEach var="e" items="${etudiants}">
                <tr>
                    <td>${e.matricule}</td>
                    <td>${e.nom}</td>
                    <td>${e.prenom}</td>
                    <td>${e.niveau}</td>
                    <td>${e.filiere}</td>
                    <td>
                        <button class="action-btn delete" onclick="if(confirm('Supprimer ?')) window.location.href='${pageContext.request.contextPath}/EtudiantAction/delete?id=${e.idEtudiant}'">Supprimer</button>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty etudiants}">
                <tr>
                    <td colspan="6" style="text-align:center;">Aucun étudiant trouvé.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>

<div id="addModal" class="modal">
    <div class="modal-content">
        <h3>Ajouter un Étudiant</h3>
        <form action="${pageContext.request.contextPath}/EtudiantAction" method="post">
            <div class="form-group">
                <label>Matricule</label>
                <input type="text" name="matricule" required>
            </div>
            <div class="form-group">
                <label>Nom</label>
                <input type="text" name="nom" required>
            </div>
            <div class="form-group">
                <label>Prénom</label>
                <input type="text" name="prenom" required>
            </div>
            <div class="form-group">
                <label>Niveau</label>
                <input type="text" name="niveau" required>
            </div>
            <div class="form-group">
                <label>Filière</label>
                <input type="text" name="filiere" required>
            </div>
            <button type="submit" class="action-btn add">Enregistrer</button>
            <button type="button" class="action-btn" onclick="document.getElementById('addModal').style.display='none'">Annuler</button>
        </form>
    </div>
</div>

</body>
</html>
