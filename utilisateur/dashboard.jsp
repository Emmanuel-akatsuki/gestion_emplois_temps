<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Planning App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/utilisateur/style.css">

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <style>
        body{ margin:0; font-family:Arial; background:#f4f6f9; }
        .sidebar{ width:230px; height:100vh; background:#1f2d3d; color:white; position:fixed; padding-top:20px; }
        .sidebar h2{ text-align:center; margin-bottom:30px; }
        .sidebar a{ display:block; color:white; padding:12px 20px; text-decoration:none; }
        .sidebar a:hover{ background:#3c4b5d; }
        .main{ margin-left:230px; padding:20px; }
        .header{ display:flex; justify-content:space-between; align-items:center; }
        .cards{ display:grid; grid-template-columns:repeat(auto-fit,minmax(200px,1fr)); gap:20px; margin-top:20px; }
        .card{ background:white; padding:20px; border-radius:8px; box-shadow:0 2px 8px rgba(0,0,0,0.1); text-align:center; }
        .card h3{ margin:0; font-size:22px; }
        .card p{ color:gray; }
        .charts{ display:grid; grid-template-columns:1fr 1fr; gap:20px; margin-top:30px; }
        .chart-box{ background:white; padding:20px; border-radius:8px; box-shadow:0 2px 8px rgba(0,0,0,0.1); }
        @media(max-width:900px){ .sidebar{ width:100%; height:auto; position:relative; } .main{ margin-left:0; } .charts{ grid-template-columns:1fr; } }
    </style>
</head>

<body>

<div class="sidebar">

    <jsp:include page="navbar.jsp"/>

    <h2>Application de planning</h2>

    <%-- Liens corrigés pointant vers les Actions du web.xml --%>
    <a href="${pageContext.request.contextPath}/PlanningAction">Dashboard</a>
    <a href="${pageContext.request.contextPath}/CoursAction">Cours</a>
    <a href="${pageContext.request.contextPath}/EnseignantAction">Enseignants</a>
    <a href="${pageContext.request.contextPath}/SalleAction">Salles</a>
    <a href="${pageContext.request.contextPath}/EtudiantAction">Etudiants</a>
    <a href="${pageContext.request.contextPath}/PlanningAction">Planning</a>
    <a href="${pageContext.request.contextPath}/SeanceAction">Séances</a>
    <a href="${pageContext.request.contextPath}/ExamenAction">Examens</a>
</div>

<div class="main">
    <div class="header">
        <h1>Dashboard</h1>
    </div>

    <div class="cards">
        <div class="card">
            <h3>${cours != null ? cours : 0}</h3>
            <p>Cours</p>
        </div>
        <div class="card">
            <h3>${enseignants != null ? enseignants : 0}</h3>
            <p>Enseignants</p>
        </div>
        <div class="card">
            <h3>${salles != null ? salles : 0}</h3>
            <p>Salles</p>
        </div>
        <div class="card">
            <h3>${etudiants != null ? etudiants : 0}</h3>
            <p>Étudiants</p>
        </div>
    </div>

    <div class="charts">
        <div class="chart-box">
            <h3>Répartition des Cours</h3>
            <canvas id="coursChart"></canvas>
        </div>
        <div class="chart-box">
            <h3>Utilisation des Salles</h3>
            <canvas id="salleChart"></canvas>
        </div>
    </div>
</div>

<script>
    const coursChart = new Chart(
        document.getElementById('coursChart'),
        {
            type: 'pie',
            data: {
                labels: ['CM', 'TD', 'TP'],
                datasets: [{
                    data: [${cm != null ? cm : 0}, ${td != null ? td : 0}, ${tp != null ? tp : 0}],
                    backgroundColor: ['#3498db', '#2ecc71', '#f39c12']
                }]
            }
        }
    );

    const salleChart = new Chart(
        document.getElementById('salleChart'),
        {
            type: 'bar',
            data: {
                labels: ['Salles'],
                datasets: [{
                    label: 'Total',
                    data: [${salles != null ? salles : 0}],
                    backgroundColor: '#3498db'
                }]
            },
            options: { responsive: true }
        }
    );
</script>

</body>
</html>
