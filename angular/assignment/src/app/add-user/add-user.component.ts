import { Component, OnInit } from '@angular/core';
import { FormControl, RequiredValidator, Validators } from '@angular/forms';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {


  name=new FormControl('',[Validators.min(3),Validators.required]);
  empid=new FormControl('',Validators.required);
  age=new FormControl('',[Validators.required]);
  dob=new FormControl([Validators.required]);
  newUser:any;
  showAdded:boolean=false;
  constructor(private userService:UserServiceService) { }



  ngOnInit(): void {
  }

  addUserFromService()
  {
    if(this.isValid())
    {
      this.newUser=
      {
        name:this.name.value,
        empid:this.empid.value,
        age:this.age.value,
        dob:this.dob.value
      }

      this.userService.addData(this.newUser);
      this.name.setValue('');
      this.empid.setValue('');
      this.age.setValue('');
      this.showAdded =true;
    }
    else
    {
        alert("give Valid Details First");
    }
  }

  updateAge() :void
  {
    var today = new Date();
    var birthDate = new Date(this.dob.value);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    this.age.setValue(age);
  }


  isValid():boolean
  {
    return this.name.valid && this.age.valid && this.empid.valid ;
  }

}
