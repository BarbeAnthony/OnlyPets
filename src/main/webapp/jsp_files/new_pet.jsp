<%--
  Created by IntelliJ IDEA.
  User: ayse
  Date: 25/04/2022
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="../images/logo.png" />
    <title> Pets </title>
</head>
<body>
<h1> Ajouter un animal </h1>
<form action="../Servlet_Submit_New_Pet" method="post">
    <h2> Les informations </h2>
    <div>
        <label for="name"> Nom de l'animal </label>
        <input type="text" name="name" id="name" required="required">
    </div>
    <div>

        <label for="especeChoice"> Espèce </label>
        <select id="especeChoice" onchange="displayInfo();">
            <option value="chat">Chat</option>
            <option value="chien">Chien</option>
            <option value="NAC">NAC</option>
            <option value="oiseaux">Oiseaux</option>
            <option value="poissons">Poissons</option>
            <option value="reptiles">Reptiles</option>
            <option value="autres">Autres</option>
        </select>
    </div>
    <div>
        <label for="description"> Description de l'animal </label>
        <br>
        <textarea id="description" name="description" rows="6" cols="30"></textarea>
    </div>
    <div>
        <label for="birthbay"> Date d'anniversaire
            <input type="date" name="birthbay" id="birthbay" required="required"></label>
    </div>
    <div>
        <input type="submit" value=" Valider ">
    </div>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="../javascripts/new_user.js"></script>
</body>
</html>
