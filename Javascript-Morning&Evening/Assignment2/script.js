

document.getElementById("even").onclick = function(){
	reset(); 
	showEven() ; 
}; 
document.getElementById("multiple").onclick = function(){
	reset() ; 
	show5sMultiple() ; 
};
document.getElementById("reset").onclick = function(){
	reset() ; 
};

function showEven(){
	let divArray = document.getElementsByClassName("division") ; 
	for(let i = 1 ; i < divArray.length ; i+=2){
		divArray[i].style.backgroundColor = "red" ; 
	}
};

function reset(){
	let divArray = document.getElementsByClassName("division") ; 
	for(let i = 0 ; i < divArray.length ; i++){
		divArray[i].style.backgroundColor = "white" ; 
	}
};

function show5sMultiple(){
	let divArray = document.getElementsByClassName("division") ; 
	for(let i=4;i<divArray.length;i+=5){
		divArray[i].style.backgroundColor='red';
	}
	
};

