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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" >
    <link rel="stylesheet" href="./stylesheets/style.css">
    <title id="mainTitle"> oNLYpETS</title>
</head>
<body>


    <nav class=" navbar-nav-scroll navbar navbar-expand-lg navbar-light ">
        <div>
        <a class="navbar-brand" href="index.jsp"  id="titleLogo">
            <img src="images/logo.png" alt="" width="50" height="45">
            oNLYpETS 
        </a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto">
            <li>
                <form class="d-flex" id="search">
                    <input class="form-control me-2" type="search" placeholder="Rechercher" aria-label="Search">
                    <button class="btn " id="researchbtn" type="submit"><i class="fa fa-search"></i></button>
                </form>
            </li>
            <c:if test="${not empty sessionScope.email}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       Bonjour, <c:out  value="${email}"/>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item" href="#">Mon Compte</a>
                      <form class="dropdown-item" method="POST" action="Servlet_Logout">
                        <input type="submit" value="Logout"/>
                    </form>
                    </div>
                </li>
            </c:if>
            <!-- TODO : CHECK IF COOKIE EXIST-->
            <c:if test="${empty sessionScope.email}">
                <li class="nav-item ">
                    <a  class="nav-link"  href= "jsp_files/user_login.jsp"> User login </a>
                </li>  
            </c:if>
            
          </ul>
         
        </div>
      </nav>
      

      <div class="container-fluid">
        <!-- Content here -->
        <div class="row">
            <div id="filtercol" class="col-3"> 
                <h1> Filters </h1>

                <form method="get" action="" id="filter">
                    <label for="espece"> Espèce </label> <br>
                    <select id="espece" class="form-select form-select-sm" multiple aria-label=".form-select-sm example">
                        <option disabled> -- Selection --</option>
                        <option value="chats"> Chats</option>
                        <option value="chiens"> Chiens</option>
                        <option value="NAC">NAC</option>
                        <option value="oiseaux"> Oiseaux</option>
                        <option value="poissons"> Poissons</option>
                        <option value="reptiles">Reptiles</option>
                        <option value="autres"> Autres </option>
                      </select>
                      <br>
                      <button id="birthday"> Joyeux Anniversaire </button>
                      

                      <div id="filter_specifique" class="form-check">
                        <input class="form-check-input" class="radio" type="checkbox" value="recent" id="recent">
                        <label class="form-check-label" for="recent">
                        Les plus récents
                        </label>
                          <br>
                        <input class="form-check-input" class="radio" type="checkbox" value="ancien" id="ancien">
                        <label class="form-check-label" for="ancien">
                         Les plus anciens
                        </label>
                          <br>
                        <input class="form-check-input" class="radio" type="checkbox" value="croissant" id="croissant">
                        <label class="form-check-label" for="croissant">
                        de A à Z
                        </label>
                          <br>
                        <input class="form-check-input" class="radio" type="checkbox" value="decroissant" id="decroissant">
                        <label class="form-check-label" for="decroissant">
                         de Z à A
                        </label>
                          <br>
                        <input class="form-check-input" class="radio" type="checkbox" value="aimer" id="aimer">
                        <label class="form-check-label" for="aimer">
                         Les plus likés
                        </label>
                          <br>
                        <input class="form-check-input" class="radio" type="checkbox" value="moin_aimer" id="moin_aimer">
                        <label class="form-check-label" for="moin_aimer">
                         Les moins likés
                        </label>
                        </div>
                      
                      <input type="submit" value="Filter" name="filtrer" id="filtrer">
                </form>

            </div>
            <div class="col-9" id="feed">
                <h1> Feed </h1>
                <div class=" card">
                    <h5 class="card-title">Ceci est un premier post</h5>
                    <p class="card-text" > patrick - maitre gustave</p>
                    <img src="..." class="card-img-top" alt="Photo animal introuvable">
                    <div class="card-body">
                        <span id="heart"><i class="fa fa-heart-o fa-2xl" aria-hidden="true" ></i> </span>
                        <p id="counter"> 10k </p>
                    </div>
                </div>



                <div class="card">
                    <h5 class="card-title">Ceci est un second post</h5>
                    <p class="card-text" > gerard </p>
                    <img src="..." class="card-img-top" alt="Photo animal introuvable">
                    <div class="card-body">
                        <span id="heart1"><i class="fa fa-heart-o fa-2xl" aria-hidden="true" ></i> </span>
                        <p id="counter"> 2k </p>
                    </div>
                </div>

                <div class="card">
                    <h5 class="card-title">Ceci est un second post</h5>
                    <p class="card-text" > gerard </p>
                    <img src="..." class="card-img-top" alt="Photo animal introuvable">
                    <div class="card-body">
                        <span id="heart1"><i class="fa fa-heart-o fa-2xl" aria-hidden="true" ></i> </span>
                        <p id="counter"> 2k </p>
                    </div>
                </div>

            </div>
        </div>
    </div>


<!-- Footer -->
<footer class="footer text-center text-lg-start text-muted">
    <section
      class="cpr d-flex justify-content-center border-bottom">
      <div>        
        <a href="https://github.com/BarbeAnthony/OnlyPets" class="text-reset">
          <i class="fab fa-github"></i>
        </a>
      </div>
    </section>

  
    <section class="">
      <div class="footer container text-center text-md-start mt-5">
        <!-- Grid row -->
        <div class="row mt-3">
          <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
            <h6 class="text-uppercase fw-bold mb-4">
                <i class="fa-solid fa-paw"></i> OnlyPets
            </h6>
            <p>
              Welcome to the best website of the internet ! Login and start sharing
              pictures of your pets !! Our policy is : " No animal is ever ugly to share ". 
            </p>
          </div>

       
          <div class="footer col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">
             Website
            </h6>
            <p>
              <a href="index.jsp" class="text-reset">Home</a>
            </p>
            <p>
              <a href="./jsp_files/new_user.jsp" class="text-reset"> New User</a>
            </p>
            <p>
              <a href="./jsp_files/new_post.jsp" class="text-reset">New Post </a>
            </p>
            <p>
              <a href="./jsp_files/new_pet.jsp" class="text-reset">New Pet</a>
            </p>
          </div>
        
          <div class="footer col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">
              Contact
            </h6>
            <a href="https://www.linkedin.com/in/anthony-barbe-01404985/" class="lk text-reset">
                <i class="fab fa-linkedin"></i> Anthony
            </a><br>
            <a href="https://www.linkedin.com/in/ayse-ergun-009667171" class="lk text-reset">
                <i class="fab fa-linkedin"></i> Ayse
            </a><br>
              <a href="https://www.linkedin.com/in/elodie-martet-642b95221/" class="lk text-reset">
                <i class="fab fa-linkedin"></i> Elodie
              </a><br>
              <a href="https://www.linkedin.com/in/etienne-jacques-92140119b/" class="lk text-reset">
                <i class="fab fa-linkedin"></i> Etienne
              </a><br>
          </div>
  
        </div>
   
      </div>
    </section>


    <div class="cpr text-center p-4">
      © 2022 Copyright:
      <a class="text-reset fw-bold" href=" ">A²E²</a>
    </div>
  </footer>



  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



  <script src="./javascripts/script.js"></script>
  <script src="https://kit.fontawesome.com/6e8aeeb9e3.js" crossorigin="anonymous"></script>
  <!-- Boostrap js library -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>



</body>
</html>