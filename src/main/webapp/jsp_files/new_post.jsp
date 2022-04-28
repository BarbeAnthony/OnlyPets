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
    <link rel="stylesheet" href="stylesheets/style.css">
    <link rel="stylesheet" href="stylesheets/formulaire.css">
    <title id="mainTitle"> Nouveau Post </title>
</head>


<body class="background-new-post">

<section class=" text-center text-lg-start">

    <div class="card mb-3">
        <div class="row g-0 d-flex align-items-center">
            <div class="col-lg-8">
                <div class="card-body py-5 px-md-5">
                    <div class="px-5 ms-xl-4">
                        <i class="fa-solid fa-paw fa-2x me-3 pt-5 mt-xl-4"></i>
                        <a href="index.jsp" class="h1 fw-bold mb-0  color-new-post">oNLYpETS</a>
                    </div>

                    <form action="Servlet_Submit_New_Post" method="post">
                        <h1> Nouveau Post </h1>
                        <div  class="row form-outline mb-4">
                            <label for="title"> Titre du post</label> <br>
                            <input type="text" id="title" name="title" required="required">
                        </div  >
                        <br>
                        <% System.out.println("Liste : "+ request.getAttribute("petList"));%>
                        <div class="row form-outline mb-4" >
                            <label for="petID"> Nom de l'animal</label> <br>
                            <select id="petID" name="petID">

                                <c:forEach items="${petList}" var="pet">
                                    <option value="<c:out value='${pet.petID}'></c:out>"><c:out value="${pet.name}"></c:out></option>
                                </c:forEach>

                            </select>
                        </div>
                        <br>
                        <div  class="row form-outline mb-4">
                            <label for="photo"> URL de l'image </label> <br>
                            <input type="text" id="photo" name="photo" required="required">
                            <p> Veillez héberger votre image sur <a href="https://www.zupimages.net/" target="_blank" class="link-info  color-new-post">ce site.</a> Puis copier l'url ci-dessus.</p>
                        </div>
                        <div  class="row form-outline mb-4">
                            <label for="description"> Description du post </label>
                            <br>
                            <textarea id="description" name="description" rows="6" cols="30"></textarea>
                        </div>
                        <div class="pt-1 mb-4">
                            <input class="btn btn-info btn-lg btn-block background-new-post color-new-post" type="submit" value="Valider"></input>
                        </div>

                    </form>

                </div>
            </div>

            <div class="col-lg-4 d-none d-lg-flex">
                <img src="images/lapin_jaune.jpg" alt="new user dog pictures"
                     class="w-100 h-100 rounded-t-5 rounded-tr-lg-0 rounded-bl-lg-5" />
            </div>
        </div>
    </div>
</section>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



<script src="https://kit.fontawesome.com/6e8aeeb9e3.js" crossorigin="anonymous"></script>
<!-- Boostrap js library -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="javascripts/new_user.js"></script>


</body>
</html>
