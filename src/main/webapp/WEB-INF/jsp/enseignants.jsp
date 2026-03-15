<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Enseignants - Planning App</title>
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
        <h2>Liste des Enseignants</h2>
    </div>

    <c:if test="${user.role == 'admin' || user.role == 'planif'}">
        <button class="action-btn add" onclick="document.getElementById('addModal').style.display='block'">Ajouter un Enseignant</button>
    </c:if>

    <table border="1">
        <thead>
        <tr>
            <th>Matricule</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Spécialité</th>
            <th>Grade</th>
            <th>Email</th>
            <c:if test="${user.role == 'admin' || user.role == 'planif'}">
                <th>Actions</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="ens" items="${enseignants}">
                <tr>
                    <td>${ens.matricule}</td>
                    <td>${ens.nom}</td>
                    <td>${ens.prenom}</td>
                    <td>${ens.specialite}</td>
                    <td>${ens.grade}</td>
                    <td>${ens.email}</td>
                    <c:if test="${user.role == 'admin' || user.role == 'planif'}">
                        <td>
                            <button class="action-btn delete" onclick="if(confirm('Supprimer ?')) window.location.href='${pageContext.request.contextPath}/EnseignantAction/delete?id=${ens.idEnseignant}'">Supprimer</button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            <c:if test="${empty enseignants}">
                <tr>
                    <td colspan="7" style="text-align:center;">Aucun enseignant trouvé.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>

<c:if test="${user.role == 'admin' || user.role == 'planif'}">
    <div id="addModal" class="modal">
        <div class="modal-content">
            <h3>Ajouter un Enseignant</h3>
            <form action="${pageContext.request.contextPath}/EnseignantAction" method="post">
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
                    <label>Spécialité</label>
                    <input type="text" name="specialite">
                </div>
                <div class="form-group">
                    <label>Grade</label>
                    <input type="text" name="grade">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email">
                </div>
                <button type="submit" class="action-btn add">Enregistrer</button>
                <button type="button" class="action-btn" onclick="document.getElementById('addModal').style.display='none'">Annuler</button>
            </form>
        </div>
    </div>
</c:if>

</body>
</html>
