<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Cours</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .modal { display: none; position: fixed; z-index: 1; left: 0; top: 0; width: 100%; height: 100%; overflow: auto; background-color: rgba(0,0,0,0.4); }
        .modal-content { background-color: #fefefe; margin: 15% auto; padding: 20px; border: 1px solid #888; width: 50%; border-radius: 8px; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; }
        .form-group input, .form-group select { width: 100%; padding: 8px; box-sizing: border-box; }
    </style>
</head>
<body>

<div class="sidebar">
    <jsp:include page="navbar.jsp"/>
</div>

<div class="main">
    <div class="header">
        <h1>Gestion des Cours</h1>
    </div>

    <c:if test="${user.role != 'etudiant'}">
        <button class="action-btn add" onclick="document.getElementById('addModal').style.display='block'">Ajouter un Cours</button>
    </c:if>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Intitule</th>
            <th>Code</th>
            <th>Type</th>
            <th>Crédit</th>
            <c:if test="${user.role != 'etudiant'}">
                <th>Actions</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${coursList}">
                <tr>
                    <td>${c.idCours}</td>
                    <td>${c.intitule}</td>
                    <td>${c.codeMatiere}</td>
                    <td>${c.typeCours}</td>
                    <td>${c.credit}</td>
                    <c:if test="${user.role != 'etudiant'}">
                        <td>
                            <button class="action-btn delete" onclick="if(confirm('Supprimer ?')) window.location.href='${pageContext.request.contextPath}/CoursAction/delete?id=${c.idCours}'">Supprimer</button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            <c:if test="${empty coursList}">
                <tr>
                    <td colspan="6" style="text-align:center;">Aucun cours disponible.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>

<c:if test="${user.role != 'etudiant'}">
    <div id="addModal" class="modal">
        <div class="modal-content">
            <h3>Ajouter un Cours</h3>
            <form action="${pageContext.request.contextPath}/CoursAction" method="post">
                <div class="form-group">
                    <label>Intitulé</label>
                    <input type="text" name="intitule" required>
                </div>
                <div class="form-group">
                    <label>Code Matière</label>
                    <input type="text" name="codeMatiere" required>
                </div>
                <div class="form-group">
                    <label>Type</label>
                    <select name="typeCours">
                        <option value="CM">CM</option>
                        <option value="TD">TD</option>
                        <option value="TP">TP</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Volume Horaire (ex: 30:00:00)</label>
                    <input type="text" name="volumeHoraire" placeholder="HH:mm:ss">
                </div>
                <div class="form-group">
                    <label>Crédits</label>
                    <input type="number" name="credit" required>
                </div>
                <button type="submit" class="action-btn add">Enregistrer</button>
                <button type="button" class="action-btn" onclick="document.getElementById('addModal').style.display='none'">Annuler</button>
            </form>
        </div>
    </div>
</c:if>

</body>
</html>
