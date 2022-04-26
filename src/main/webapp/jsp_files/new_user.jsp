
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="../images/logo.png" />
    <title>Créer un compte</title>
</head>
<body>
<h1> Formulaire d'inscription </h1>
<form action="../Servlet_Create_Account" method="post">
    <h2> Mes identifiants </h2>
    <div>
        <label for="username"> Pseudo </label>
        <input type="text" name="username" id="username" required="required">
    </div>
    <div>
        <label for="email"> Email </label>
        <input type="email" name="email" id="email" required="required">
    </div>
    <div>
        <label for="password1"> Mot de passe (8 characters minimum)
            <input type="password" name="password1" id="password1" minlength="8" value="" class="form-control" required="required" ></label>
        <br>
        <label for="password1"> Confirmation du mot de passe
            <input type="password" name="password2" id="password2" minlength="8" value="" class="form-control" required="required" disabled="true"></label>
        <div class="alert" id="password_alert" role="alert"> Mot de passe non identique</div>
    </div>
    <div>
        <input type="submit" value=" Valider ">
    </div>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="../javascripts/new_user.js"></script>
</body>
</html>