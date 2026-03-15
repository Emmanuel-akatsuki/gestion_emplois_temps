<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Séances - Planning App</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .modal { display: none; position: fixed; z-index: 1; left: 0; top: 0; width: 100%; height: 100%; overflow: auto; background-color: rgba(0,0,0,0.4); }
        .modal-content { background-color: #fefefe; margin: 5% auto; padding: 20px; border: 1px solid #888; width: 60%; border-radius: 8px; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; }
        .form-group input, .form-group select { width: 100%; padding: 8px; box-sizing: border-box; }
    </style>
</head>

<body>
<div class="sidebar"><jsp:include page="navbar.jsp"/></div>

<div class="main">
    <div class="header">
        <h2>Liste des Séances de Cours</h2>
    </div>

    <c:if test="${user.role != 'etudiant'}">
        <button class="action-btn add" onclick="document.getElementById('addModal').style.display='block'">Ajouter une Séance</button>
    </c:if>

    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Jour</th>
            <th>Heure Début</th>
            <th>Heure Fin</th>
            <th>Cours</th>
            <th>Enseignant</th>
            <th>Salle</th>
            <c:if test="${user.role != 'etudiant'}">
                <th>Actions</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="s" items="${seances}">
                <tr>
                    <td>${s.idSeance}</td>
                    <td>${s.jour}</td>
                    <td>${s.heureDebut}</td>
                    <td>${s.heureFin}</td>
                    <td>${s.cours.intitule}</td>
                    <td>${s.enseignant.nom}</td>
                    <td>${s.salle.nomSalle}</td>
                    <c:if test="${user.role != 'etudiant'}">
                        <td>
                            <button class="action-btn delete" onclick="if(confirm('Supprimer cette séance ?')) window.location.href='${pageContext.request.contextPath}/SeanceAction/delete?id=${s.idSeance}'">Supprimer</button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            <c:if test="${empty seances}">
                <tr>
                    <td colspan="8" style="text-align:center;">Aucune séance planifiée.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>

<c:if test="${user.role != 'etudiant'}">
    <div id="addModal" class="modal">
        <div class="modal-content">
            <h3>Ajouter une Séance</h3>
            <form action="${pageContext.request.contextPath}/SeanceAction" method="post">
                <div class="form-group">
                    <label>Planning</label>
                    <select name="planning.idPlanning" required>
                        <c:forEach var="p" items="${plannings}">
                            <option value="${p.idPlanning}">${p.libelle} (${p.anneeAcad})</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Cours</label>
                    <select name="cours.idCours" required>
                        <c:forEach var="c" items="${coursList}">
                            <option value="${c.idCours}">${c.intitule}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Enseignant</label>
                    <select name="enseignant.idEnseignant" required>
                        <c:forEach var="ens" items="${enseignants}">
                            <option value="${ens.idEnseignant}">${ens.nom} ${ens.prenom}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Salle</label>
                    <select name="salle.idSalle" required>
                        <c:forEach var="sl" items="${salles}">
                            <option value="${sl.idSalle}">${sl.nomSalle} (${sl.batiment})</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>Jour</label>
                    <select name="jour">
                        <option value="lundi">Lundi</option>
                        <option value="mardi">Mardi</option>
                        <option value="mercredi">Mercredi</option>
                        <option value="jeudi">Jeudi</option>
                        <option value="vendredi">Vendredi</option>
                        <option value="samedi">Samedi</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Heure Début (HH:mm:ss)</label>
                    <input type="text" name="heureDebut" placeholder="08:00:00" required>
                </div>
                <div class="form-group">
                    <label>Heure Fin (HH:mm:ss)</label>
                    <input type="text" name="heureFin" placeholder="10:00:00" required>
                </div>
                <button type="submit" class="action-btn add">Enregistrer</button>
                <button type="button" class="action-btn" onclick="document.getElementById('addModal').style.display='none'">Annuler</button>
            </form>
        </div>
    </div>
</c:if>

</body>
</html>
