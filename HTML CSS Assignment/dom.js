/* let name = document.getElementById("name");
console.log(name);
console.log(name.textContent);
name.style.color = 'brown';

var classCollection = document.getElementsByClassName('demo');
console.log(classCollection);
classCollection[0].style.fontSize = '40px';
classCollection[1].style.display = 'none';

document.getElementById("myButton").className = "button";
document.getElementById("myButton").classList = 'button button1';

var querySelect = document.querySelector("p");
console.log(querySelect);

var querySelectAll = document.querySelectorAll("p");
console.log(querySelectAll);

let input = document.createElement('input');
document.body.appendChild(input);
// name.parentElement.parentElement.appendChild(input);
var demoClass = document.getElementsByClassName('demo');
console.log("By Class Name:"+demoClass.length);

var demoClass1 = document.querySelectorAll(".demo");
console.log("querySelector:"+demoClass1.length);


//write the no of elements in each array(values match)
console.log("Number of elements with querySelectorAll = "+demoClass1.length);
console.log("Number of elements with getElementsByClassName = "+demoClass.length);

//change one elements class to blue
document.getElementById("pele").className = "blue";

//write the no of elements in each array(values differ)
console.log("Number of elements with querySelectorAll = "+demoClass1.length);
console.log("Number of elements with getElementsByClassName = "+demoClass.length);

document.getElementById("div1").innerHTML = "<input type='text'>";

 */

// window.onload = function(){
//     document.getElementById('myButton').textContent = "Dont Click";
// }

// let button = document.getElementById("myButton");
// // button.onclick = function createNewElement(){
// //     document.getElementById("div1").innerHTML = "<a href='https://google.com'>Anchor Tag</a>";
// // }
// button.addEventListener('click',()=>{
//     document.getElementById("div1").innerHTML = "<a href='https://google.com'>Anchor Tag</a>";
// });

var john = {
    name:"john",
    age:25,
    presentation: function(style,message){
        if(style === 'formal'){
            console.log("Hi "+this.name+ " good "+message);
        }
        else{
            console.log("Hey "+this.name+" "+message);
        }

    }
};
john.presentation('formal','Morning');

var mike= {
    name:"mike",
    age:26
};
// john.presentation.call(mike,'friendly','Evening'); //Call for string parameters
// john.presentation.apply(mike,['friendly','Evening']); // Call for array Parameters

var johnFormal = john.presentation.bind(mike,'formal'); //this will not invoke itself as call and apply. To call we have to execute next line
johnFormal('Night');