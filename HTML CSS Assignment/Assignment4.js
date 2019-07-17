var img1 = document.getElementById("img1");
var img2 = document.getElementById("img2");
var img3 = document.getElementById("img3");
var img4 = document.getElementById("img4");

var img_array = document.getElementsByTagName("img");

var div2 = document.getElementById("dynamic-div");
img_array[0].addEventListener('mouseover', () => {
    for (var i = 1; i <= 3; i++) {
        img_array[i].src = img_array.length + 1 + ".jpg";
        let img = document.createElement('img');
        img.src = img_array.length+ 4 + ".jpg";
        img.className = "img-all"
        div2.appendChild(img);
    }
    
});
img1.addEventListener('mouseout', () => {
    for (var i = 1; i <= 3; i++) {
        img_array[i].src = i +1+ ".jpg";
    }
    div2.innerHTML = "";
});