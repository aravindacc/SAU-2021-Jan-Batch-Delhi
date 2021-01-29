function highlightEven(){
    reset();
    var evenNumber = 2;
    while(evenNumber <= 20){
        document.getElementById(evenNumber).style.backgroundColor = "#4CAF50";
        evenNumber += 2;
    }
}

function highlightMultipleOf5(){
    reset();
    var multipleOf5 = 5;
    while(multipleOf5 <= 20){
        document.getElementById(multipleOf5).style.backgroundColor = "#008CBA";
        multipleOf5 += 5;
    }
}

function reset(){
    var itr = 1;
    while(itr <= 20){
        document.getElementById(itr).style.backgroundColor = "rgba(255, 255, 255, 0.8)";
        itr += 1;
    }
}