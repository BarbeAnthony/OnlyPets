<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="images/logo.png" />

    <!-- Font library -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap" rel="stylesheet">
    <!-- Bootstrap library -->
    <!-- CSS only -->
    <!-- Icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" >
    <link rel="stylesheet" href="stylesheets/style.css">
    <link rel="stylesheet" href="stylesheets/formulaire.css">
    <title id="mainTitle"> Déconnecté</title>
</head>
<body class="background-bye">


<section class=" text-center text-lg-start">

    <div class="card mb-3">
        <div class="row g-0 d-flex align-items-center">

            <div class="col-lg-12">
                <div class="card-body py-5 px-md-5">
                    <div class="px-5 ms-xl-4">
                        <p class="h1 fw-bold mb-0  color-bye"> <i class="fa-solid fa-paw fa-2x me-3 pt-5 mt-xl-4"></i>oNLYpETS</p>
                        <p class="h1 fw-bold mb-0  color-bye"> Vous êtes déconnecter... Max est triste :'( </p>
                        <img src="images/sad.jpg" alt="Login cat pictures"
                             class="w-100 h-100 rounded-t-5 rounded-tr-lg-0 rounded-bl-lg-5" />
                    </div>
                    <div class="pt-1 mb-4">
                        <a href="Servlet_Default_Index" class="btn btn-info btn-lg btn-block background-bye color-bye" >Retour à l'acceuil</a>
                    </div>
                    <div class="pt-1 mb-4">
                        <a href="Servlet_Login" class="btn btn-info btn-lg btn-block background-bye color-bye">Se reconnecter </a>
                    </div>



                </div>
            </div>
        </div>
    </div>
</section>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



<script src="./javascripts/script.js"></script>
<script src="https://kit.fontawesome.com/6e8aeeb9e3.js" crossorigin="anonymous"></script>
<!-- Boostrap js library -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>
</html>