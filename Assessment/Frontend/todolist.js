
//Adds the task to the table by generating dynamic rows and columns and adding to a table
function addTask() {
    var tr = document.createElement("tr");//create a row
    tr.style.cursor = "pointer";//set the cursor of that row to pointer
    tr.addEventListener('click', function (e) {  //adding the event listener to on click of the task to change it to done
        if (e.target) { // This gets the clicked target
            let text = e.target.textContent.strike(); //get the text of the clicked element and strike through
            e.target.innerHTML = "<span class='fa fa-check'></span>" + text; //setting the element's updated value
        }
    });
    var td1 = document.createElement("td");//create column element 1
    td1.textContent = title.value; //setting the value of column 1 as the text in text box
    var td2 = document.createElement("td");//create column element 2
    td2.innerHTML = `<span>&times;</span>`;//setting the value of column 2 as "X"
    td2.addEventListener('click', function (e) { //adding the event listener to onclick of the "X" to delete that row
        if (e.target) {
            let row = e.target.parentElement.parentElement; //get the row to be deleted
            e.target.parentElement.parentElement.parentElement.removeChild(row);//delete the row from the table
        }
    });
    tr.appendChild(td1);//append the column1 to table row
    tr.appendChild(td2);//append the column2 to table row
    document.getElementById("tasktable").appendChild(tr);////append the row to table
}
