import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-delete-users',
  templateUrl: './delete-users.component.html',
  styleUrls: ['./delete-users.component.scss']
})
export class DeleteUsersComponent implements OnInit {

  constructor() { }
  deleteprofileForm = new FormGroup({
    EmployeeId: new FormControl(''),
    Confirm: new FormControl(''),
  });

validateConsent(confirm: any){
    if(!confirm[0].checked ){
        alert("Please confirm if you really want to delete the specified record.");
        return false;
    }
    return true;
}

  delete(){
    var confirm = <HTMLInputElement> <unknown>document.getElementsByName('Confirm');
    var empId= this.deleteprofileForm.controls['EmployeeId'].value;
    if(this.validateConsent(confirm)){
      sessionStorage.removeItem(empId);
      alert("Record for Employee Id " + empId + " sucessfully deleted");
    }
  }

  ngOnInit(): void {
  }

}
