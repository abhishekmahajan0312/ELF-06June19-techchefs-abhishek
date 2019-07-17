var btn = document.getElementById("add");
var table = document.getElementById("tbody");
btn.addEventListener("click",()=>{
    document.getElementById("div-table").style.display = "block";
    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
    td1.textContent = document.getElementById("department-id").value;
    var td2 = document.createElement("td");
    td2.textContent = document.getElementById("department-name").value;
    tr.appendChild(td1);
    tr.appendChild(td2);
    document.getElementById("tbody").appendChild(tr);
});