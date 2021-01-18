import { Component, Input, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-users',
  templateUrl: './add-users.component.html',
  styleUrls: ['./add-users.component.scss']
})
export class AddUsersComponent implements OnInit {
  constructor() {}

  profileForm = new FormGroup({
    FirstName: new FormControl(''),
    EmployeeId: new FormControl('' ),
    DOB:new FormControl(''),
    Email: new FormControl(''),
    Contact: new FormControl(''),
    Agree: new FormControl(''),
  });


  validateName(name: any){
    if(name == ""){
        alert("First Name Field cannot be left empty!");
        return false;
    }
    return true;
}

validateEmpId(empId: any){
  if(empId==""){
      alert("Employee Id Field cannot be left empty!");
      return false;
  }
  return true;
}

validateContact(phone_number: any){
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

 validateEmail(email:any){
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


validateConsent(confirm: any){
    if(!confirm){
        alert("Please give your consent and confirmation");
        return false;
    }
    return true;
}

validate(){

  
    var FirstName= this.profileForm.controls['FirstName'].value;
    var empId= this.profileForm.controls['EmployeeId'].value;
    var email= this.profileForm.controls['Email'].value;
    var contact= this.profileForm.controls['Contact'].value;
    var confirm= this.profileForm.controls['Agree'].value;
    


    if(this.validateName(FirstName) && this.validateEmpId(empId) && this.validateEmail(email) && this.validateContact(contact) && this.validateConsent(confirm)){
      console.warn(this.profileForm.value);
      sessionStorage.setItem(empId, JSON.stringify(this.profileForm.value));
      alert("Employee Successfully Added!" );
    }
}


  ngOnInit(): void {
  }

}
