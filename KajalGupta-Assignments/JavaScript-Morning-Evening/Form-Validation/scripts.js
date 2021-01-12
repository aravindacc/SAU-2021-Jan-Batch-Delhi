function validateForm(){

    emailID = document.getElementById("email").value;
    atpos = emailID.indexOf("@");
    dotpos = emailID.lastIndexOf(".");

    gender = document.getElementsByName("gender").value;
    city = document.getElementById("city").value;

    checkCity = document.getElementById("city");
    checkCity = checkCity.options[checkCity.selectedIndex].value;

    fname = document.getElementById("fname").value;
    lname = document.getElementById("lname").value;

    if(fname=="")
        alert("First name field is required");
        
    else if(lname=="")
        alert("Last name field is required");
    
    else if(!document.getElementsByName("gender")[1].checked && !document.getElementsByName("gender")[0].checked)
        alert("Gender is required field");
    
    else if(atpos < 1 || ( dotpos - atpos < 2 ))
        alert("Invalid email ID");

    else if(checkCity==0)
        alert("Please select a city");

    else
    {
        var output = {
        "first-name":fname,
        "last-name":lname,
        "gender":gender,
        "city":city,
        "email":emailID
        }
        console.log(output);
    }
}
