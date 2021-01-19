window.onload = function(){ 

    output = {};
    document.getElementById("submit").onclick = function(event){
    
    event.preventDefault();

    output.firstName = document.getElementById("fname").value;
     
    output.lastName = document.getElementById("lname").value;

    output.year = document.getElementById("Year").value;

    emailID = document.getElementById("email").value;
    output.email = emailID;

    atpos = emailID.indexOf("@");
    dotpos = emailID.lastIndexOf(".");

    if(document.getElementsByName("gender")[1].checked)
        output.gender = document.getElementsByName("gender")[1].value;
    else if(document.getElementsByName("gender")[0].checked)
        output.gender = document.getElementsByName("gender")[0].value;
    else 
        output.gender = "";
    

    if(output.firstName=="")
        alert("First name field is required");
        
    else if(output.lastname=="")
        alert("Last name field is required");
    
    else if(output.gender=="")
        alert("Gender is required field");
    
    else if(atpos < 1 || ( dotpos - atpos < 2 ))
        alert("Invalid email ID");

    else if(output.year=="")
        alert("Choose your year cant be blank");

    else
    {
        output = JSON.stringify(output);
        console.log(output);
    }

};
};