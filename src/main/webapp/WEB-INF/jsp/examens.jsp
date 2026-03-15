<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Examens - Planning App</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .modal { display: none; position: fixed; z-index: 1; left: 0; top: 0; width: 100%; height: 100%; overflow: auto; background-color: rgba(0,0,0,0.4); }
        .modal-content { background-color: #fefefe; margin: 10% auto; padding: 20px; border: 1px solid #888; width: 60%; border-radius: 8px; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; }
        .form-group input, .form-group select { width: 100%; padding: 8px; box-sizing: border-box; }
    </style>
</head>

<body>
<div class="sidebar"><jsp:include page="navbar.jsp"/></div>

<div class="main">
    <div class="header">
        <h2>Liste des Examens</h2>
    </div>

    <c:if test="${user.role == 'admin' || user.role == 'planif' || user.role == 'enseignant'}">
        <button class="action-btn add" onclick="document.getElementById('addModal').style.display='block'">Programmer un Examen</button>
    </c:if>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Cours</th>
            <th>Salle</th>
            <th>Type</th>
            <th>Session</th>
            <th>Date Début</th>
            <th>Date Fin</th>
            <c:if test="${user.role == 'admin' || user.role == 'planif'}">
                <th>Actions</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="ex" items="${examens}">
                <tr>
                    <td>${ex.idExamen}</td>
                    <td>${ex.cours.intitule}</td>
                    <td>${ex.salle.nomSalle}</td>
                    <td>${ex.typeExamen}</td>
                    <td>${ex.session}</td>
                    <td>${ex.dateDebut}</td>
                    <td>${ex.dateFin}</td>
                    <c:if test="${user.role == 'admin' || user.role == 'planif'}">
                        <td>
                            <button class="action-btn delete" onclick="if(confirm('Annuler cet examen ?')) window.location.href='${pageContext.request.contextPath}/ExamenAction/delete?id=${ex.idExamen}'">Annuler</button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            <c:if test="${empty examens}">
                <tr>
                    <td colspan="8" style="text-align:center;">Aucun examen programmé.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>

<c:if test="${user.role == 'admin' || user.role == 'planif' || user.role == 'enseignant'}">
    <div id="addModal" class="modal">
        <div class="modal-content">
            <h3>Programmer un Examen</h3>
            <form action="${pageContext.request.contextPath}/ExamenAction" method="post">
                <div class="form-group">
                    <label>Cours</label>
                    <select name="cours.idCours" required>
                        <c:forEach var="c" items="${coursList}">
                            <option value="${c.idCours}">${c.intitule}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Salle</label>
                    <select name="salle.idSalle" required>
                        <c:forEach var="s" items="${salleList}">
                            <option value="${s.idSalle}">${s.nomSalle}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Type d'Examen</label>
                    <select name="typeExamen">
                        <option value="CC">Contrôle Continu (CC)</option>
                        <option value="SN">Session Normale (SN)</option>
                        <option value="RATTRAPAGE">Rattrapage</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Session</label>
                    <input type="text" name="session" placeholder="ex: Juin 2024" required>
                </div>
                <div class="form-group">
                    <label>Date Début (yyyy-mm-dd)</label>
                    <input type="date" name="dateDebut" required>
                </div>
                <div class="form-group">
                    <label>Date Fin (yyyy-mm-dd)</label>
                    <input type="date" name="dateFin" required>
                </div>
                <div class="form-group">
                    <label>Heure Début (HH:mm:ss)</label>
                    <input type="text" name="heureDebut" placeholder="08:00:00" required>
                </div>
                <div class="form-group">
                    <label>Heure Fin (HH:mm:ss)</label>
                    <input type="text" name="heureFin" placeholder="11:00:00" required>
                </div>
                <button type="submit" class="action-btn add">Enregistrer</button>
                <button type="button" class="action-btn" onclick="document.getElementById('addModal').style.display='none'">Annuler</button>
            </form>
        </div>
    </div>
</c:if>

</body>
</html>
