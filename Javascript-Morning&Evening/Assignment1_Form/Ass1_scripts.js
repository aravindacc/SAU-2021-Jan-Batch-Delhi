
var output = {} ; 
document.getElementById("submit").onclick = function(event){
    event.preventDefault();
	output['First_Name'] = document.getElementById("fname").value ; 
	output['Last_Name'] = document.getElementById("lname").value ; 
	output['Email'] = document.getElementById('email').value ; 
    output['city'] = document.getElementById('city').value ; 

    atratePos = output['Email'].indexOf("@");
    dotPos = output['Email'].lastIndexOf(".");
    console.log(dotPos)
    length = output['Email'].length;
    console.log(length)
    //Invalid email - @gmail.com or a@gmail.coms
    if(atratePos < 1 || ( length - dotPos > 4 ))
        alert("Invalid email ID");

	var ele = document.getElementsByName('gender'); 
    var gender ;           
    for(i = 0; i < ele.length; i++) { 
        if(ele[i].checked) 
       		gender = ele[i].value; 
    }
    output['gender'] = gender ;

	document.getElementById("showOutput").innerHTML = JSON.stringify(output) ;
	 
};