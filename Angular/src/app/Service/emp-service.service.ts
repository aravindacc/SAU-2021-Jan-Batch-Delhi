import { Injectable, OnDestroy } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmpServiceService implements OnDestroy{
  constructor(){
   }

   ngOnDestroy(){
      sessionStorage.removeItem('employeeList');
   }

  storeInsessionStorage(empList){
    sessionStorage.setItem('employeeList',JSON.stringify(empList));
  }

  addEmployee(emp):Boolean{
    var empList=JSON.parse(sessionStorage.getItem('employeeList'));

    if(empList===null){
      empList=[];
    }

    var id=emp.empId;
    var found:Boolean=false;
    empList.forEach((e)=>{
      if(e.empId===id){
        found=true;
      }
    });

    if(!found){
      empList.push(emp);
      this.storeInsessionStorage(empList);
    }
    else{
      alert("Employee with this Id is Already Present!");
      return false;
    }

    return true;
  }

  showAllEmployee(){
    return JSON.parse(sessionStorage.getItem('employeeList'));;
  }

  getEmployeeById(id){
    var empList=JSON.parse(sessionStorage.getItem('employeeList'));
    return empList.find((emp)=>{
      if(emp.empId===id){
        return emp;
      }
    });
  }

  editEmployeeDetail(emp):Boolean{
    var empList=JSON.parse(sessionStorage.getItem('employeeList'));
    var found=false;
    var tmp:any;
    for(var i=0;i<empList.length;i++){
      tmp=empList[i];

      if(tmp.empId===emp.empId){
        empList[i]=emp;
        found=true;
        this.storeInsessionStorage(empList);
        break;
      }
    }

    return found;
  }

  upDateList(newList:Array<any>){
   this.storeInsessionStorage(newList);
  }

}
