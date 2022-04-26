<%--
  Created by IntelliJ IDEA.
  User: ayse
  Date: 25/04/2022
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<br>
<form action="../Servlet_Login" method="post">
    <label for="email"> Saisir une adresse email :</label> <input type="email" id="email" name="email">
    <br>
    <label for="password"> Saisir un mot de passe :</label> <input type="password" id="password" name="password">
    <br>
    <input type="submit" value="valider">
</form>

</body>
</html>
