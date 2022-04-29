// TODO : MAKE LIKE WORK FOR EACH POST
$(document).ready(function(){
    // LIKER POST
    $("#heart").click(function(){
      if($("#heart").hasClass("liked")){
        $("#heart").html('<i class="fa fa-heart-o fa-2xl" aria-hidden="true"></i>');
        $("#heart").removeClass("liked");
      }else{
        $("#heart").html('<i class="fa fa-heart fa-2xl" aria-hidden="true"></i>');
        $("#heart").addClass("liked");
      }
    });

  });

 