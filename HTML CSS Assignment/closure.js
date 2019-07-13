function counter(){
    var count =0;
    function getCount(){
        count++;
        return count;
    }
    return getCount;
}

var count2 = counter();
let value = count2();
console.log(value);
value = count2();
console.log(value);

var dwightSalary = (function(){
    var salary = 60000;
    function changeBy(amount){
        salary+=amount;
    }
    return{
        raise: function(){
            changeBy(5000);
        },
        lower: function(){
            changeBy(-5000);
        },
        currentAmount: function(){
            return salary;
        }

    };
})();

alert(dwightSalary.currentAmount());

dwightSalary.raise();
alert(dwightSalary.currentAmount());
dwightSalary.lower();
alert(dwightSalary.currentAmount());