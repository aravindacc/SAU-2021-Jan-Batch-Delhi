function validateName(name){
    if(name == ""){
        alert("Name Field cannot be left empty!");
        return false;
    }
    else if (!(/^[a-zA-Z]*$/.test(name))){
        alert("Please enter only letters in Name!");
        return false;
    }
    return true;
}

function validateContact(phone_number){
    if(phone_number==""){
        alert("Phone number Field cannot be left empty!");
        return false;
    }
    else if((!(/\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/.test(phone_number))) ){
        alert("Please enter a valid mobile number!");
        return false;
    }
    return true;
}

function validateEmail(email){
    if(email=="")
    {
        alert("Please enter your e-mail address!");
        return false;
    }
    else if (!(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(email)))
    {
        alert("Please enter a valid email!");
        return false;
    }
    return true;
}

function validateSubject(subject){
    if(!subject[0].checked && !subject[1].checked && !subject[2].checked && !subject[3].checked && !subject[4].checked){
        alert("Please select atleast one Tech skill checkbox.");
        return false;
    }
    return true;
}

function validateWork(work){
    if(!work[0].checked && !work[1].checked && !work[2].checked){
        alert("Please select your identity among Student, Teacher or Industry Professional.");
        return false;
    }
    return true;
}

function validateLocation(location){
    if(location.selectedIndex == 0){
        alert("Please select your current location!");
        return false;
      }
    return true;
}

function validate(){ 
            
    var name = document.getElementById("name").value;
    var phone_number = document.getElementById("phone_number").value;
    var email = document.getElementById("email").value;
    var work = document.getElementsByName("work");
    var subject = document.getElementsByName("subject");
    var location = document.getElementById("location");
   
    if(validateName(name) && validateContact(phone_number) && validateEmail(email) && validateSubject(subject) && validateWork(work) && validateLocation(location)){
        var i = 0;
        var skillObj = [];
        while(i<5){
            if(subject[i].checked)
            skillObj.push(subject[i].value);
            i++;
            }
        var j = 0;
        var workType = "";
        while(j<3){
            if(work[j].checked)
            workType = work[j].value;
            j++;
            }
      
        var personJsonObj = {
            "Name" : name,
            "Phone number" : phone_number,
            "Email" : email,
            "Skills" : skillObj,
            "Work Type" : workType,
            "Location" : location[location.selectedIndex].value,
        };
      alert(JSON.stringify(personJsonObj, null, 1));
    }
}

