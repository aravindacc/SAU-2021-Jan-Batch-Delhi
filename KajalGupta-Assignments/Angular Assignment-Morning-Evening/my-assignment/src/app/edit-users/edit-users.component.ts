import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-users',
  templateUrl: './edit-users.component.html',
  styleUrls: ['./edit-users.component.scss'],
})
export class EditUsersComponent implements OnInit {

  constructor(private router: Router){}
  editprofileForm = new FormGroup({
    EmployeeId: new FormControl(''),
    Confirm: new FormControl(''),
  });

  emp:any;

  show=false;
  showedit=true;
  saveEmp(){
    
    var FirstName= this.profileForm.controls['FirstName'].value;
    var empId= this.profileForm.controls['EmployeeId'].value;
    var email= this.profileForm.controls['Email'].value;
    var contact= this.profileForm.controls['Contact'].value;
    


    if(this.validateName(FirstName) && this.validateEmpId(empId) && this.validateEmail(email) && this.validateContact(contact) ){
      console.warn(this.profileForm.value);
      sessionStorage.setItem(empId, JSON.stringify(this.profileForm.value));
      alert("Employee Details Successfully Saved!" );
    }
    this.showedit=true;
     this.show=false;
  }

  profileForm = new FormGroup({
    FirstName: new FormControl(''),
    EmployeeId: new FormControl('' ),
    DOB:new FormControl(''),
    Email: new FormControl(''),
    Contact: new FormControl(''),
    Agree: new FormControl(''),
  });

fetchDetails(key:any) {
    this.emp = sessionStorage.getItem(key);
    this.emp=JSON.parse(this.emp);
}

validateConsent(confirm: any){
    if(!confirm){
        alert("Please confirm if you really want to edit the specified record.");
        return false;
    }
    return true;
}

validateConsent1(confirm: any){
  if(!confirm){
      alert("Please give your consent and confirmation");
      return false;
  }
  return true;
}

validateName(name: any){
  if(name == ""){
      alert("First Name Field cannot be left empty!");
      return false;
  }
  else if (!(/^[a-zA-Z]*$/.test(name))){
      alert("Please enter only letters in Name!");
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


  edit(){
    var confirm= this.editprofileForm.controls['Confirm'].value;
    var empId= this.editprofileForm.controls['EmployeeId'].value;
    if(this.validateConsent(confirm)){
      this.fetchDetails(empId);
      this.showedit=false;
      this.show=true;
    }
  }

  ngOnInit(): void {
  }

}



