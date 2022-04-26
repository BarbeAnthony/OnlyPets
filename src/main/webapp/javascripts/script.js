function likeColor(heart){
    if (heart.style.color == 
}


// Variable for storing the current
        // background color
        let isliked = true;
  
        // Get the div that has to be
        // toggled
        let heart = $(".fat-solid");
  
        $('.fat-solid').contextmenu(function () {

            // Add and remove class depending
            // on the variable
            if (isliked) {
                heart.removeClass("unlike");
                heart.addClass("like");
            }
            else {
                heart.removeClass("like");
                heart.addClass("unlike");
            }
  
            // Toggle the background color variable
            isliked = !isliked;
  
            return false;
        });