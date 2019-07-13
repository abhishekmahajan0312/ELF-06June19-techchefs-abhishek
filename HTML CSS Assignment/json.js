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

var jsonLibrary = JSON.stringify(library);
console.log(jsonLibrary);

var objLibrary = JSON.parse(jsonLibrary);
console.log(objLibrary);

function getFactorial(){
    let n = prompt("Enter the Number");
    alert(factorial(n));
}
function factorial(n)
{
    if(n===0 || n === 1)
    {
        return 1;
    }
    return n*factorial(n-1);
}