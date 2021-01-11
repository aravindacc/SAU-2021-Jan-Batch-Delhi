function highlightEven(){
	let divisions = document.getElementsByClassName("division") ; 
	for(let i = 0 ; i < divisions.length ; i++){
		if(i%2 === 1)
			divisions[i].style.backgroundColor = "yellow" ; 
	}
};

function reset(){
	let divisions = document.getElementsByClassName("division") ; 
	for(let i = 0 ; i < divisions.length ; i++){
		divisions[i].style.backgroundColor = "white" ; 
	}
};

function highlightMutiple(){
	let divisions = document.getElementsByClassName("division") ; 
	let i = 1 ; 
	while(true){
		if(i*5-1 < divisions.length)
			divisions[i*5-1].style.backgroundColor = "yellow" ;
		else 
			break;
		i++ ; 
	}
};


document.getElementById("even").onclick = function(){
	reset(); 
	highlightEven() ; 
}; 
document.getElementById("multiple").onclick = function(){
	reset() ; 
	highlightMutiple() ; 
};
document.getElementById("reset").onclick = function(){
	reset() ; 
};