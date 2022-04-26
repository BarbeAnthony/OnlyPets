let isliked = true;
let heart = $(".fat-solid");

  $('.fat-solid').contextmenu(function () {
   
    if (isliked) {
        heart.removeClass("unlike");
        heart.addClass("like");
    }
    else {
        heart.removeClass("like");
        heart.addClass("unlike");
    }
    isliked = !isliked;
    return false;
    
});
