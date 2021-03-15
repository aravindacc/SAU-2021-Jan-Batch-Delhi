import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { report } from 'process';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {


  constructor(private httpClient:HttpClient){}

  transactions:any=[]
  showAdminPanel:boolean=false;
  showUserPanel:boolean=false;
  addUserPanel:boolean=false;
  addedSuccess:boolean=false;
  username
  accountNumber
  addUserReturnMessage:String=''
  showUserFunctions=false;
  amount;
  serialNo
  addTransactionPanel=false
  ListTransactionPanel=false
  transactionMsg=''
  showAdminInput=false;
  adminId
  adminPassword


  authenticateAdminByIdPassword()
  {
    this.httpClient.post('http://localhost:8080/user/authenticate',{id:this.adminId,password:this.adminPassword}).subscribe(response=>{
      if(response==null)
      {
        alert("Wrong Credentials");
        this.authenticateAdmin();
        this.showAdminPanel=false;
      }
      else
      {
        this.showAdminPanel=true;
      }
      console.log(response)
    })
  }

  authenticateAdmin()
  {
    this.showAdminInput=true;
    this.showUserPanel=false;
    this.showUserFunctions=false;
    this.addUserPanel=false;
    this.transactions=[]
  }

  ListAllTrasactions()
  {
    this.httpClient.get('http://localhost:8080/transactions/getTransactionByType/'+0).subscribe(data=>{
      this.transactions=data
    })
  }



  ListLegalTrasactions()
  {
    this.httpClient.get('http://localhost:8080/transactions/getTransactionByType/'+1).subscribe(data=>{
      this.transactions=data
    })
  }



  ListIllegalTrasactions()
  {
    this.httpClient.get('http://localhost:8080/transactions/getTransactionByType/'+2).subscribe(data=>{
      this.transactions=data
    })
  }

  authenticateUser()
  {
    this.showAdminInput=false;
    this.transactions=[]
    this.showUserPanel=true;
    this.showAdminPanel=false;
    this.addUserPanel=false;
    this.showUserFunctions=false;

  }

  showaddUserPanel()
  {
    this.showAdminInput=false;
    this.showUserPanel=false;
    this.showAdminPanel=false;
    this.addUserPanel=true;
    this.showUserFunctions=false;
  }

  loginUser()
  {
    this.httpClient.get('http://localhost:8080/user/getByAC/'+this.accountNumber).subscribe(data=>{
      if(data==null)
      {
        alert("User dont Exist");
        this.showUserFunctions=false;

      }
      else
      {
        this.username=data['userName'];
        this.showUserFunctions=true;
      }
    })
  }

  addUser()
  {

    this.httpClient.post('http://localhost:8080/user/addUser',{userName:this.username,accountNumber:this.accountNumber},{responseType: 'text'}).subscribe(response=>{
      this.addUserReturnMessage=response;
    })

  }


  doTransaction()
  {
    this.httpClient.post('http://localhost:8080/transactions/addTransaction',{transaction:{accountNumber:this.accountNumber,currencySerial:this.serialNo},amount:this.amount}).subscribe(reponse=>{
      this.transactionMsg = "Your transaction Id is " + reponse;
    })
  }

  showTransactions()
  {
    this.httpClient.get('http://localhost:8080/transactions/getTransactionByNo/'+this.accountNumber).subscribe(data =>{
      this.transactions=data;
    })
  }
}
