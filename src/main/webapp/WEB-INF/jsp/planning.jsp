<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Planning - Gestion Emplois Temps</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .modal { display: none; position: fixed; z-index: 1; left: 0; top: 0; width: 100%; height: 100%; overflow: auto; background-color: rgba(0,0,0,0.4); }
        .modal-content { background-color: #fefefe; margin: 15% auto; padding: 20px; border: 1px solid #888; width: 50%; border-radius: 8px; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; }
        .form-group input { width: 100%; padding: 8px; box-sizing: border-box; }
        @media print {
            .sidebar, .action-btn { display: none; }
            .main { margin-left: 0; }
        }
    </style>
</head>

<body>

<div class="sidebar"><jsp:include page="navbar.jsp"/></div>

<div class="main">
    <div class="header">
        <h2>Liste des Plannings</h2>
        <div>
            <c:if test="${user.role != 'etudiant'}">
                <button class="action-btn add" onclick="document.getElementById('addModal').style.display='block'">Ajouter un Planning</button>
            </c:if>
            <button class="action-btn print" onclick="window.print()">Imprimer</button>
        </div>
    </div>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Libellé</th>
            <th>Semestre</th>
            <th>Année Académique</th>
            <c:if test="${user.role != 'etudiant'}">
                <th>Actions</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${plannings}">
                <tr>
                    <td>${p.idPlanning}</td>
                    <td>${p.libelle}</td>
                    <td>${p.semestre}</td>
                    <td>${p.anneeAcad}</td>
                    <c:if test="${user.role != 'etudiant'}">
                        <td>
                            <button class="action-btn delete" onclick="if(confirm('Supprimer ?')) window.location.href='${pageContext.request.contextPath}/PlanningList/delete?id=${p.idPlanning}'">Supprimer</button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            <c:if test="${empty plannings}">
                <tr>
                    <td colspan="5" style="text-align:center;">Aucun planning trouvé.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>

<c:if test="${user.role != 'etudiant'}">
    <div id="addModal" class="modal">
        <div class="modal-content">
            <h3>Ajouter un Planning</h3>
            <form action="${pageContext.request.contextPath}/PlanningList" method="post">
                <div class="form-group">
                    <label>Libellé</label>
                    <input type="text" name="libelle" required>
                </div>
                <div class="form-group">
                    <label>Semestre</label>
                    <input type="text" name="semestre" required>
                </div>
                <div class="form-group">
                    <label>Année Académique</label>
                    <input type="text" name="anneeAcad" required>
                </div>
                <div class="form-group">
                    <label>Date Début (yyyy-mm-dd)</label>
                    <input type="date" name="dateDebut" required>
                </div>
                <div class="form-group">
                    <label>Date Fin (yyyy-mm-dd)</label>
                    <input type="date" name="dateFin" required>
                </div>
                <button type="submit" class="action-btn add">Enregistrer</button>
                <button type="button" class="action-btn" onclick="document.getElementById('addModal').style.display='none'">Annuler</button>
            </form>
        </div>
    </div>
</c:if>

</body>
</html>
