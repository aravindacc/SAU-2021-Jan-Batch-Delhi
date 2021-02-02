let input = document.getElementById("inp");
let result = document.getElementById("res");
let swapBu = document.getElementById("swapBu");

swapBu.addEventListener('click', ()=>{
    let word = input.value;
    let res = '';

    for (let c of word) {
        res += c===c.toUpperCase() ? c.toLowerCase() :c.toUpperCase();
    }

    result.value = res;
});