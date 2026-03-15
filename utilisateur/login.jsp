<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="UTF-8">
    <title>Connexion - Planning App</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style>

        *{
        margin:0;
        padding:0;
        box-sizing:border-box;
        font-family:Arial, Helvetica, sans-serif;
        }

        body{
        height:100vh;
        display:flex;
        justify-content:center;
        align-items:center;
        background:linear-gradient(135deg,#2c3e50,#3498db);
        }

        .login-container{
        background:white;
        padding:40px;
        width:350px;
        border-radius:10px;
        box-shadow:0 10px 25px rgba(0,0,0,0.2);
        text-align:center;
        }

        .login-container h2{
        margin-bottom:25px;
        color:#2c3e50;
        }

        .input-group{
        margin-bottom:20px;
        text-align:left;
        }

        .input-group label{
        font-size:14px;
        color:#555;
        }

        .input-group input{
        width:100%;
        padding:10px;
        margin-top:5px;
        border:1px solid #ccc;
        border-radius:5px;
        font-size:14px;
        }

        .input-group select{
        width:100%;
        padding:10px;
        margin-top:5px;
        border:1px solid #ccc;
        border-radius:5px;
        }

        button{
        width:100%;
        padding:12px;
        border:none;
        background:#3498db;
        color:white;
        font-size:16px;
        border-radius:5px;
        cursor:pointer;
        transition:0.3s;
        }

        button:hover{
        background:#2980b9;
        }

        .footer{
        margin-top:15px;
        font-size:12px;
        color:#888;
        }

    </style>

</head>

<body>

<div class="login-container">

    <h2>Connexion</h2>

    <form action="${pageContext.request.contextPath}/LoginAction" method="post">

    <div class="input-group">

            <label>Login</label>
            <input type="text" name="login" required>

        </div>

        <div class="input-group">

            <label>Mot de passe</label>
            <input type="password" name="password" required>

        </div>

        <div class="input-group">

            <label>Role</label>

            <select name="role">

                <option value="admin">Admin</option>
                <option value="enseignant">Enseignant</option>
                <option value="etudiant">Etudiant</option>

            </select>

        </div>

        <button type="submit">Se connecter</button>

    </form>

    <div class="footer">

        Planning Management System

    </div>

</div>

</body>
</html>
