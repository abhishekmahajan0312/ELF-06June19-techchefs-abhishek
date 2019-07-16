new Promise((res,rej)=>{
    const items = [{id:1,name:'Abhishek'},{id:2,name:'Megha'}];
    if(items.length>0){
        res(items);
    }
    else{
        rej("rejected");
    }
});

promise.then((data)=>{
    console.log(data);
}).catch((reason)=>{
    console.log(reason);
});
