import { Injectable } from '@angular/core';
import { Router }         from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class EmployeeDataService {

  constructor(private router:Router) { }

  employeeDataBase = [];

  prefilledData = {
    username: "",
    id: "",
    age: "",
    date: ""

  };

  update: boolean = false;
  buttonState = "Add User";

  addData(employee: any)
  {
    this.prefilledData.username = "";
    this.prefilledData.id = "";
    this.prefilledData.age = "";
    this.prefilledData.date = "";


    var index = this.employeeDataBase.findIndex(i => i.id === employee.id);

    if(index == -1)
    {
      this.employeeDataBase.push(employee);
      console.log(this.employeeDataBase);
      alert("Details Added");
    }

    else
    {
      alert("Employee with id already exist.");
    }

  }

  getData()
  {
    console.log(this.employeeDataBase);
  }

  deleteData(id: any)
  {
    var index = this.employeeDataBase.findIndex(i => i.id === id)
    this.employeeDataBase.splice(index, 1);
  }

  editData(id: any)
  {
    var index = this.employeeDataBase.findIndex(i => i.id === id)
    this.prefilledData.username = this.employeeDataBase[index].username;
    this.prefilledData.id = this.employeeDataBase[index].id;
    this.prefilledData.age = this.employeeDataBase[index].age;
    this.prefilledData.date = this.employeeDataBase[index].date;

    this.update = true;
    this.buttonState = "Update User";
    this.router.navigate(['EmployeeFormComponent']);



  }

  updateData(formValue: any, oldId: any)
  {

    var index = this.employeeDataBase.findIndex(i => i.id === oldId)
    var newIndex = this.employeeDataBase.findIndex(i => i.id === formValue.id)

    if(newIndex == index || newIndex == -1)
    {
      this.employeeDataBase[index].username = formValue.username;
      this.employeeDataBase[index].id = formValue.id;
      this.employeeDataBase[index].age = formValue.age;
      this.employeeDataBase[index].date = formValue.date;

      this.prefilledData.username = "";
      this.prefilledData.id = "";
      this.prefilledData.age = "";
      this.prefilledData.date = "";

      alert("Details Updated");
    }

    else
    {
      alert("Employee with the given id already exist.");
    }

    this.update = false;
    this.buttonState = "Add User";
  }
}
