
function validateForm() {
    let myEmail = document.forms[0].email.value;
    // let myPassword = document.forms[0].password.value;
    // let myConfirmPassword = document.forms[0].confirm_password.value;
    console.log(myEmail);
    if (myEmail.length >= 6) {
        document.getElementById("email-error").style.display = "none";
        let password = document.forms[0].password.value;
        let confirmPassword = document.forms[0].confirm_password.value;
        if (password.length >= 6 && confirmPassword.length >= 6 && password === confirmPassword) {
            document.getElementById("myButton").disabled = false;
            document.getElementById("cfpassword-error").style.display = "none";
            document.getElementById("password-error").style.display = "none";

        }
        else {
            document.getElementById("email-error").innerHTML = "Email ID must contain atleast 6 characters";
            document.getElementById("myButton").disabled = true;
            document.getElementById("cfpassword-error").style.display = "block";
            document.getElementById("password-error").style.display = "block";
            document.getElementById("password-error").innerHTML="Password must contain atleast 6 characters and must match Confirm Password";
            document.getElementById("cfpassword-error").innerHTML="Password must contain atleast 6 characters and must match Confirm Password";
        }
    }
    else {
        document.getElementById("email-error").style.display = "block";
        document.getElementById("email-error").innerHTML = "Email ID must contain atleast 6 characters";

        document.getElementById("myButton").disabled = true;
    }
}
let tbpassword = document.getElementById("password");
let cbPassword = document.getElementById("cbpassword");
cbPassword.addEventListener('change', () => {
    if (cbPassword.checked === true) {
        tbpassword.type = "text";
    }
    else {
        tbpassword.type = "password";
    }
});
let cftbpassword = document.getElementById("confirm_password");
let cfcbPassword = document.getElementById("cfcbpassword");
cfcbPassword.addEventListener('change', () => {
    if (cfcbPassword.checked === true) {
        cftbpassword.type = "text";
    }
    else {
        cftbpassword.type = "password";
    }
});

function showPassword(){
    if(tbpassword.type==="password")
    {
        tbpassword.type = "text";
    }
    else{
        tbpassword.type = "password";
    }
}

function showConfirmPassword(){
    if(cftbpassword.type==="password")
    {
        cftbpassword.type = "text";
    }
    else{
        cftbpassword.type = "password";
    }
}