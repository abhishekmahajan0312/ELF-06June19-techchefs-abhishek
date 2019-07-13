
function validateForm() {
    let myEmail = document.forms[0].email.value;
    // let myPassword = document.forms[0].password.value;
    // let myConfirmPassword = document.forms[0].confirm_password.value;
    console.log(myEmail);
    if (myEmail.length >= 6) {

        let password = document.forms[0].password.value;
        let confirmPassword = document.forms[0].confirm_password.value;
        if (password.length>=6 && confirmPassword.length>=6 && password === confirmPassword ) {
            document.getElementById("myButton").disabled = false;
        }
        else{
            document.getElementById("myButton").disabled = true;
        }
    }
    else{
        document.getElementById("myButton").disabled = true;
    }
}

// let button = document.getElementById("myButton");