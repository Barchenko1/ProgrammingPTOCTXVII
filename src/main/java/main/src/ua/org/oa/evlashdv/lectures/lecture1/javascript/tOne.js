function sumTo(n) {
    if (n == 1) return 1;
    return n + sumTo(n - 1);
}

console.log(sumTo(10000));
var lastName
var myObj= {
    name:"Pasha",
    secondName:null,
    lastName:lastName
};
delete myObj.lastName
console.log(myObj);