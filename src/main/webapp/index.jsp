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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" >
    <!-- Icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="stylesheets/style.css">
    <title> OnlyPets</title>
</head>
<body>


    <nav class=" navbar-nav-scroll navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp">
            <img src="images/logo.png" alt="" width="50" height="45">
            OnlyPets</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto">
            <li>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Rechercher" aria-label="Search">
                    <button class="btn " type="submit">Rechercher</button>
                </form>
            </li>
            <c:if test="${not empty sessionScope.email}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       Bonjour, <c:out  value="${email}"/>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item" href="#">Mon Compte</a>
                      <a class="dropdown-item" href="#">Se déconnecter</a>
                      <form class="dropdown-item" method="POST" action="Servlet_Logout">
                        <input type="submit" value="Logout"/>
                    </form>
                    </div>
                </li>
            </c:if>
            <c:if test="${empty sessionScope.email}">
                <li class="nav-item " >
                    <a  class="nav-link " href= "jsp_files/user_login.jsp"> User login </a>
                </li>  
            </c:if>
            
          </ul>
         
        </div>
      </nav>
      
      <a href="jsp_files/new_user.jsp">New User</a>
      <a href="jsp_files/new_post.jsp">New Post</a>
      <a href="jsp_files/new_pet.jsp">New Pets</a>




      <div class="container-fluid">
        <!-- Content here -->
        <div class="row">
            <div class="col-3"> 
                <h1> Filters </h1>

                <form method="get" action="" id="filter">
                    <label for="espece"> Espèce </label> <br>
                    <select id="espece" class="form-select" multiple aria-label="selector">
                        <option value="" > --selection--</option>
                        <option value="chats"> Chats</option>
                        <option value="chiens"> Chiens</option>
                        <option value="NAC">NAC</option>
                        <option value="oiseaux"> Oiseaux</option>
                        <option value="poissons"> Poissons</option>
                        <option value="reptiles">Reptiles</option>
                        <option value="autres"> Autres </option>
                      </select>
                      
                      <button > Joyeux Anniversaire </button>
                      

                      <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="recent" id="recent">
                        <label class="form-check-label" for="recent">
                        Les plus récents
                        </label>
                        <input class="form-check-input" type="checkbox" value="ancien" id="ancien">
                        <label class="form-check-label" for="ancien">
                         Les plus anc
                        <input class="form-check-input" type="checkbox" value="croissant" id="croissant">
                        <label class="form-check-label" for="croissant">
                        de A à Z
                        </label>
                        <input class="form-check-input" type="checkbox" value="decroissant" id="decroissant">
                        <label class="form-check-label" for="decroissant">
                         de Z à A
                        </label>
                        <input class="form-check-input" type="checkbox" value="aimer" id="aimer">
                        <label class="form-check-label" for="aimer">
                         Les plus likés
                        </label>
                        <input class="form-check-input" type="checkbox" value="moin_aimer" id="moin_aimer">
                        <label class="form-check-label" for="moin_aimer">
                         Les moins likés
                        </label>
                        </div>
                      
                      <input type="submit" value="Filter" name="filtrer" id="filtrer">
                </form>

            </div>
            <div class="col-9">
                <h1> Feed </h1>
                <div class="post card">
                    <h5 class="card-title">Ceci est un premier post</h5>
                    <p class="card-text" > patrick</p>
                    <img src="..." class="card-img-top" alt="Photo animal introuvable">
                    <div class="card-body">
                        <i class="unlike fa-solid fa-heart"></i>
                        <p> 10k </p>
                    </div>
                </div>

                <div class="post card">
                    <h5 class="card-title">Ceci est un second post</h5>
                    <p class="card-text" > gerard </p>
                    <img src="..." class="card-img-top" alt="Photo animal introuvable">
                    <div class="card-body">
                        <i class="unlike fa-solid fa-heart"></i>
                        <p> 2k </p>
                    </div>
                </div>

            </div>
        </div>
    </div>














    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



    <script src="./javascripts/script.js"></script>
    <script src="https://kit.fontawesome.com/6e8aeeb9e3.js" crossorigin="anonymous"></script>
    <!-- Boostrap js library -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" ></script>
</body>
</html>