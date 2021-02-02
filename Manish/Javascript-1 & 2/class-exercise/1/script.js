let aleartBu = document.getElementById("alertBu");
let redirectBu = document.getElementById("redirectBu");
let n1 = document.getElementById("n1");
let n2 = document.getElementById("n2");
let result = document.getElementById("result");
let resultBu = document.getElementById("resultBu")

// functionality 1- alert
aleartBu.addEventListener('click', ()=>{
    alert("Hello world")
});

// fuctionality 2 - redirect
redirectBu.addEventListener('click', ()=>{
    alert("Thanks for visiting the website..\nRedirecting to google.")
    window.open("https://www.google.com","_self");
});

// functionality 3 - sum
resultBu.addEventListener('click', ()=>{
    let a = n1.value;   
    let b = n2.value;
    result.value = parseInt(a) + parseInt(b);
});
