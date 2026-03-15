<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="UTF-8">
<title>Créer un compte</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<style>

body{
font-family:Arial;
background:linear-gradient(135deg,#1f2d3d,#3498db);
height:100vh;
display:flex;
justify-content:center;
align-items:center;
}

.container{
background:white;
padding:40px;
width:350px;
border-radius:10px;
box-shadow:0 10px 25px rgba(0,0,0,0.2);
}

.container h2{
text-align:center;
margin-bottom:20px;
}

input,select{

width:100%;
padding:10px;
margin-top:10px;
margin-bottom:15px;
border:1px solid #ccc;
border-radius:5px;

}

button{

width:100%;
padding:12px;
background:#3498db;
border:none;
color:white;
font-size:16px;
border-radius:5px;
cursor:pointer;

}

button:hover{

background:#2980b9;

}

.link{

text-align:center;
margin-top:10px;

}

</style>

</head>

<body>

<div class="container">

<h2>Créer un compte</h2>

<form action="../Register" method="post">

<input type="text" name="login" placeholder="Login" required>

<input type="password" name="password" placeholder="Mot de passe" required>

<select name="role">

<option value="etudiant">Etudiant</option>
<option value="enseignant">Enseignant</option>
<option value="planif">Admin</option>

</select>

<button type="submit">Créer un compte</button>

</form>

<div class="link">

<a href="login.jsp">Déjà un compte ? Se connecter</a>

</div>

</div>

</body>
</html>
