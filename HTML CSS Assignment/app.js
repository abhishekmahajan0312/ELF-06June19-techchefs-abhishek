// var a = 10;
// console.log(a);
// var b = a;
// console.log(b);
// b=20;
// console.log(a);
// console.log(b);

var person = {
                name:"Abhishek",
                age:25,
                eyeColor: 'blue',
                getFullName : function(){
                    return this.name;
                },
                address : {
                    city: "Bangalore",
                    state: "KArnataka",
                    
                    pincode: 560068
                },
                hobbies : ['sleeping','oversleeping',null,'watching tv']
};
// console.log(person.getFullName());
// console.log("Pincode::: "+person.address.pincode);
// console.log("hobbies::"+person.hobbies);
// console.log(person.hobbies[2]);
// console.log("Name::::"+person.name);
// var person1 = person;
// console.log("P1 Name=="+person1.name);
// person1["name"] = "Megha";
// console.log("P Name="+ person["name"]);
// console.log("P1 Name"+person1.name);

var hobbies = ['cricket','volleyball','football','reading books'];
hobbies["test"] = "some text";
document.getElementById('demo').innerHTML = hobbies;
hobbies.forEach((val,index) => {
    console.log("value"+val);
    console.log(index);    
});
var library = [{
    id : 1,
    author: 'Bill Gates',
    name: 'Bill'
},
{
    id:2,
    author:'Steve Jobs',
    name: 'Apple'
},
{
    id:3,
    author:'Narayana',
    name:"Infosys"
}

];

// for(var val of hobbies){
//     console.log('hobbies=='+val);
// }

// for(var index in hobbies){
//     console.log("hobbies=================="+hobbies[index]);
//     console.log("index=================="+index);
    
// }
// for(var index in person){
//     // console.log("Name:::::::::"+person[index].name);
//     console.log("Age::::::::::"+person[index]);
// }
// console.log("========for of loop start==============");
// console.time("forin");
// for(var i in hobbies){
//     var a = [];
// }
// console.timeEnd("forin")



// console.log("Object1==="+ library[0].author);
// console.log("Object1 Name==="+library[1].name)

// function alertMessage(val,number){
//     alert(`this is normal function value is = ${val} number= ${number}`);
// }
// (function(){
//     alert("this is IIFE");
// }());
// (function(){
//     alert("this is IIFE1111111111111");
// })(); 

// alertMessage("aa",12);
// varkey();
// function varkey(){
//     a=20;
//     console.log(a);
// }
// console.log(a);



// function letKey(){
//     let b=20;
//     console.log(b);
// }
// console.log(b);


// function constKey(){
//     const c = 30;
//     console.log(c);
// }
// console.log(c);

// fnname();//It will execute as it is even before declaring the function  
// function fnname(){
//     console.log("aaaa");
// }

// var fnname1 = function(){
//     console.log("bbb");
// };
// fnname1();// If called before function ie line123 then it will throw an error. It is treated like a variable not function

var a = {};
// console.log(typeof hobbies);


// hobbies.shift();
// console.log(hobbies);

// hobbies.unshift("hello");
// console.log(hobbies);
// hobbies.splice(0,2,"gggg","hhh");


// console.log(hobbies.join("--"));
// console.log(hobbies.indexOf('cricket'));

//Callback Function

// function first(){
//     setTimeout(()=>{
//         console.log("this is first");
//     },0);
    
// }
// function second(){
//     console.log("this is second");
// }
// first();
// second();


// function first(sec){
//     setTimeout(()=>{
//         console.log("this is first");
//         sec();
//     },0);
    
// }
// function second(){
//     console.log("this is second");
// }
// first(second);

const items = [
    {
        id :1,
        name : 'book',
        price :200
    },
    {
        id :2,
        name : 'pen',
        price :100
    },
    {
        id :3,
        name : 'bag',
        price :600
    },

    {
        id :4,
        name : 'shirt',
        price :1000
    },
    {
        id :5,
        name : 'laptop',
        price :25000
    }
    
];
console.log(items);

let mappedIds = items.map((value) => {
    return value.id;
});
 
console.log(mappedIds);

console.log(items);

// let filterValues = items.filter((value) => {
//     return value.price>200;
// });
//OR
// filterValues = items.filter((value) => value.price>200);
// console.log(filterValues);