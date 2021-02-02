import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../model/user';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class UserListService {
  baseUrl: string = 'http://jsonplaceholder.typicode.com/users';
  usersBS = new BehaviorSubject<User[]>([]);
  usersOb = this.usersBS.asObservable();

  userToEditBS = new BehaviorSubject<User>({id:NaN, name:'', username:'', email:''});
  userToEditOb = this.userToEditBS.asObservable();

  constructor(private http: HttpClient) {
    this.getUsersFromAPI();
  }

  // load from API and http get
  getUsersFromAPI() {
    return this.http.get<User[]>(this.baseUrl).subscribe((allUser) => {
      const newUsers = [];
      console.log(allUser);
      for (let user of allUser) {
        newUsers.push({
          id: user.id,
          name: user.name,
          username: user.username,
          email: user.email,
        });
      }
      this.usersBS.next(newUsers);
    });
  }

  // get all users as observable
  getAllUser():Observable<User[]> {
    return this.usersOb;
  }

  // delete user
  deleteUser(id: number): Observable<User> {
    // delete from observable
    const newUsers = this.usersBS.value.filter(user => user.id !== id);
    this.usersBS.next(newUsers);

    // delete from server
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<User>(url, httpOptions);
  }

  // add new user or edit it
  addUser(user: User):Observable<User> {

    // update existing user
    const newUsers =  this.usersBS.value;
    for (let i =0; i<newUsers.length; i++) {
      if (newUsers[i].id == user.id) {
        newUsers[i] = user;
        this.usersBS.next(newUsers);
        return this.http.put<User>(`${this.baseUrl}/${user.id}`, user, httpOptions); 
      }
    }

    // if user is new push value and upadate server
    newUsers.push(user);
    this.usersBS.next(newUsers);
    return this.http.post<User>(this.baseUrl, user, httpOptions);
  }


  // set user  which need to edited
  setEditUser(user: User) {
    this.userToEditBS.next(user);
  }

  // getter for userToEdit
  getEditUser() {
    return this.userToEditOb;
  }

  // get edit user value 
  getEditUserValue() {
    return this.userToEditBS.value;
  }
}
