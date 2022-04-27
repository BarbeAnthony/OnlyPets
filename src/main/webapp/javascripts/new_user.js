$(document).ready(function (){
    check_email_valid();
    check_password();
});

$("#submit").on("click", function (){
    console.log("submited");
});

$("#valider").on("click", function (){
    console.log("validate activated");
    $("form#myForm :input").each(function (){
        console.log("inside the each loop");
        if($(this).val()==""){
            console.log("should return empty");
            var text = $(this).parentElement.innerText+" is empty";
            error.text(text);
        }else {
            console.log("this"+$(this).val());
        }
    });
});

function check_password() {
    console.log("ok fonction check");
    var pass1 = $("#password1");
    var pass2 = $("#password2");
    var alert = $("#password_alert");
    pass1.on('input',function (){
        if (pass1.val().length >=8){
            pass2.prop("disabled", false);
    }else {
            pass2.prop("disabled", true);
        }
    })
    pass2.on('input', function (){
        if (pass2.val()==pass1.val()){
            console.log("ok equal");
            pass2.css("border", "2px solid green");
            pass1.css("border", "2px solid green");
            alert.css("display", "none");
        } else {
            pass2.css("border", "2px solid red");
            pass1.css("border", "2px solid red");
            alert.css("display", "block");
        }
    })
}

function check_email_valid(){
    console.log("ok email fonction check");
    var reg_email = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/; ///^\S+@\S+\.\S+$/
    var email = $("#email");
    email.on('input', function(){
        if(reg_email.test(String(email.val()).toLowerCase())){
            console.log(email.val());
            $("#email").css("border", "2px solid green");
        } else{
            console.log(email.val());
            $("#email").css("border", "2px solid red");
        }
    });




    function email_unique() {

    }

}