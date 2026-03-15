<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>Planning App</h2>

<a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>

<c:if test="${user.role == 'admin' || user.role == 'planif' || user.role == 'enseignant' || user.role == 'etudiant'}">
    <a href="${pageContext.request.contextPath}/CoursAction">Cours</a>
</c:if>

<c:if test="${user.role == 'admin' || user.role == 'planif'}">
    <a href="${pageContext.request.contextPath}/EnseignantAction">Enseignants</a>
</c:if>

<c:if test="${user.role == 'admin' || user.role == 'planif' || user.role == 'etudiant'}">
    <a href="${pageContext.request.contextPath}/SalleAction">Salles</a>
</c:if>

<c:if test="${user.role == 'admin' || user.role == 'planif'}">
    <a href="${pageContext.request.contextPath}/EtudiantAction">Etudiants</a>
</c:if>

<c:if test="${user.role == 'admin' || user.role == 'planif' || user.role == 'etudiant' || user.role == 'enseignant'}">
    <a href="${pageContext.request.contextPath}/PlanningList">Planning</a>
</c:if>

<c:if test="${user.role == 'admin' || user.role == 'planif' || user.role == 'enseignant' || user.role == 'etudiant'}">
    <a href="${pageContext.request.contextPath}/SeanceAction">Séances</a>
</c:if>

<c:if test="${user.role == 'admin' || user.role == 'planif' || user.role == 'enseignant'}">
    <a href="${pageContext.request.contextPath}/ExamenAction">Examens</a>
</c:if>

<a href="${pageContext.request.contextPath}/logout" style="color: #ff4d4d; margin-top: 20px;">Déconnexion</a>
