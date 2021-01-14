function ValidateEmail(mail) {
 if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(mail))
  {
    return (true)
  }
  return (false)
}

function ValidateDateTime(dateTime){
  var pos = dateTime.indexOf('T');

  const timeElapsed = Date.now();
  const today = new Date(timeElapsed + (330*60000) - 120);
  isoDateTime = today.toISOString().slice(0,16);

  if(dateTime >= isoDateTime)
    return true;
  return false;
}

window.onload = function(){ 
        document.getElementById("submit").onclick = function(event){

        event.preventDefault();

        var customer_name = document.getElementById("customer_name");
        var phone_number = document.getElementById("phone_number");
        var email_address = document.getElementById("email_address");
        var pickup_time = document.getElementById("pickup_time");
        var taxi = document.getElementsByName("taxi");
        var extras = document.getElementsByName("extras");
        var pickup_place = document.getElementById("pickup_place");
        var dropoff_place = document.getElementById("dropoff_place");
        var comments = document.getElementById("comments");

        var nameStr = customer_name.value;
        var phoneStr = phone_number.value;
        var emailStr = email_address.value;
        var timeStr = pickup_time.value;
        var nameAlertStr = "", phoneAlertStr = "", emailAlertStr = "", timeAlertStr = "";
        var alertStr = "";
        var taxiStr = "";
        var extraStr = "";
        var pickupStr = "";
        var dropoffStr = "";

        if(nameStr == ""){
          nameAlertStr = "=>Please Enter Name\n";
        }

        if(phoneStr.length != 10){
          phoneAlertStr = "=>Please Enter phone number with 10 digits\n";
        }

        if(!ValidateEmail(emailStr)){
          emailAlertStr = "=>Please enter Valid email address\n";
        }

        if(!ValidateDateTime(timeStr)){
          timeAlertStr = "=>Please enter date and time from today and now onwards\n";
        }

        if(!taxi[0].checked && !taxi[1].checked && !taxi[2].checked){
          taxiStr = "=>Please select one of the Taxi Radio Buttons\n";
        }

        if(!extras[0].checked && !extras[1].checked && !extras[2].checked){
          extraStr = "=>Please select atleast one extras checkbox\n";
          
        }

        if(pickup_place.selectedIndex == 0){
          pickupStr = "=>Please select a pickup place\n";
        }

        if(dropoff_place.selectedIndex == 0){
          dropoffStr = "=>Please select a drop off place\n";
        }

        alertStr = alertStr.concat(nameAlertStr, phoneAlertStr, timeAlertStr, emailAlertStr, taxiStr, extraStr, pickupStr, dropoffStr);
        //console.log(alertStr);
        if(alertStr !== ""){
          alert("Please look into your form and provide required fields\n".concat(alertStr));
          return false;
        }
        else{
          var i = 0;
          var extraObj = [];
          var radioValue = "";
          while(i<3){
            if(extras[i].checked)
              extraObj.push(extras[i].value);
            if(taxi[i].checked)
              radioValue = taxi[i].value;
            i++;
          }


          var jsonObj = {
            "Customer Name" : nameStr,
            "Phone number" : phoneStr,
            "Email" : emailStr,
            "Taxi Type" : radioValue,
            "Extras" : extraObj,
            "Time" : timeStr,
            "PickUp Place" : pickup_place[pickup_place.selectedIndex].value,
            "Drop Place" : dropoff_place[dropoff_place.selectedIndex].value,
            "Comments" : comments.value
          };
          alert(JSON.stringify(jsonObj, null, 1));
        }
      };

};