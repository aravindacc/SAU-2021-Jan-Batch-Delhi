var obj = {} ; 
document.getElementById("submit").onclick = function(event){
	obj['First_Name'] = document.getElementById("fname").value ; 
	obj['Last_Name'] = document.getElementById("lname").value ; 
	obj['Email'] = document.getElementById('email').value ; 
	obj['city'] = document.getElementById('city').value ; 

	var ele = document.getElementsByName('gender'); 
    var gender ;           
    for(i = 0; i < ele.length; i++) { 
        if(ele[i].checked) 
       		gender = ele[i].value; 
    }
    obj['gender'] = gender ;

	document.getElementById("show").innerHTML = JSON.stringify(obj) ;
	event.preventDefault(); 
};