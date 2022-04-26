<%--
  Created by IntelliJ IDEA.
  User: ayse
  Date: 25/04/2022
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="../images/logo.png" />
    <title> Post </title>
</head>
<body>
<h1> Création d'un Post </h1>

<form action="../Servlet_New_Post" method="post">
    <div><label for="title"> Titre du post</label> <input type="text" id="title" name="post" required="required">
    </div>
    <br>
    <div><label for="petID"> Nom de l'animal</label> <input type="text" id="petID" name="post-animal" required="required">
    </div>
    <br>
    <div><label for="photo"> URL de l'image </label> <input type="text" id="photo" name="post-image" required="required">
    </div>
    <div>
        <label for="description"> Description du post </label>
        <br>
        <textarea id="description" name="description" rows="6" cols="30"></textarea>
    </div>

</form>

</body>
</html>
