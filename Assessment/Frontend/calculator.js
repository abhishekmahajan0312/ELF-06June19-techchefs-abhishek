var result = document.getElementById("result");//Get the Html element by id result
//Determines button clicked via id and append the appropriate value/expression in text field
function appendToDisplay(id) 
{
    result.value += id; //Append the value/expression to the text field
}//End of Function

// Clears calculator input screen
function clearScreen() {
    result.value = "";
}

// Calculates input values with the use of javascript eval() method
function calculate() {
    try {
        var input = eval(result.value);
        result.value = input;
    } catch (err) {
        result.value = "Error";
    }
}