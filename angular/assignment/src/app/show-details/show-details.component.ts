import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { emit } from 'process';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-show-details',
  templateUrl: './show-details.component.html',
  styleUrls: ['./show-details.component.scss']
})
export class ShowDetailsComponent implements OnInit {


  @Input()
  details;

  @Output()
  updated :EventEmitter<any> =new EventEmitter();

  constructor(private userService:UserServiceService) { }


  name=new FormControl('',[Validators.required,Validators.minLength(3)]);
  id=new FormControl('',[Validators.required]);
  age=new FormControl('',[Validators.required]);
  dob=new FormControl(['',Validators.required]);

  updateDetails;



  ngOnInit(): void {
    this.name.setValue(this.details.name);
    this.id.setValue(this.details.id);
    this.age.setValue(this.details.age);
    this.dob.setValue(this.details.dob);

  }


  updateUser()
  {
    this.updateDetails={
      name:this.name.value,
      id:this.id.value,
      age:this.age.value,
      dob:this.dob.value
    }
    if(this.isValid())
    {
      this.userService.updateUser(this.details,this.updateDetails);
    }
    else{
      alert("give Valid Details");
    }

  }

  isValid() :boolean
  {
    return  this.name.valid && this.id.valid && this.age.valid;
  }

}
