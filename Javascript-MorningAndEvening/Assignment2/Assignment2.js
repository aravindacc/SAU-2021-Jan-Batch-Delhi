function validateForm(){

    emailID = document.getElementById("email").value;
    atpos = emailID.indexOf("@");
    dotpos = emailID.lastIndexOf(".");

    course = document.getElementsByName("course").value;
    os = document.getElementById("os").value;
    checkOS = document.getElementById("os");
    checkOS = checkOS.options[checkOS.selectedIndex].value;
    fullname = document.getElementById("fullname").value;
    fathername = document.getElementById("fathername").value;
    address = document.getElementById("address").value;


    if(fullname == "")
        alert("Full Name is not given. Kindly give it.");
        
    else if(fathername == "")
        alert("Fateher's Name is not given. Kindly give it.");

    else if(address == "")
        alert("Address is not given. Kindly give it.");
    
    else if(!document.getElementsByName("course")[1].checked && !document.getElementsByName("course")[0].checked)
        alert("Course is not chosen. Kindly choose one course");
    
    else if(atpos < 1 || ( dotpos - atpos < 2 ))
        alert("Invalid email ID");

    else if(checkOS == 0)
        alert("Operating System is not selected. Kindly select it.");

    else
    {
        var course = document.getElementsByName('course');
        var courseValue;
        for(var i = 0; i < course.length; i++){
            if(course[i].checked){
                courseValue = course[i].value;
            }
        }

        var output ={
            "Email: ": emailID,
            "FullName: ": fullname,
            "Father's: Name": fathername,
            "Address: ": address,
            "Course: ": courseValue,

        };
        console.log(output);
        alert("submitted");
    }
}