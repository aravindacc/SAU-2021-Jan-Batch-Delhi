import { toBase64String } from '@angular/compiler/src/output/source_map';
import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-showdata',
  templateUrl: './showdata.component.html',
  styleUrls: ['./showdata.component.scss']
})
export class ShowdataComponent implements OnInit {

  constructor(public service: DataService) { }
  details= [{}];
  updatecheck= false;

    firstname= '';
    lastname= '';
    dob= '';
    phone= '';
    age= '';
    email= '';
    index= undefined;

  ngOnInit(): void {
    this.service.obs.subscribe(data => {this.details = data; });


  }

  openform(i: any): void{
    this.updatecheck = true;
    this.firstname= this.details[i].firstname;
    this.lastname= this.details[i].lastname;
    this.dob= this.details[i].dob;
    this.phone= this.details[i].phone;
    this.age= this.details[i].age;
    this.email= this.details[i].email;
    this.index= i;
  }

  deletevalue(i: any): void {
    this.service.delete(i);
  }

  updatethevalue(): void {
    const value=
    {firstname:this.firstname,
      lastname:this.lastname,
      dob:this.dob,
      phone:this.phone,
      age:this.age,
    email:this.email
  };
    this.service.update(this.index, value);
    alert("Value Updated");
    this.updatecheck = false;
  }

}
