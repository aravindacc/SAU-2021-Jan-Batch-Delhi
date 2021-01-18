import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-show-all-users',
  templateUrl: './show-all-users.component.html',
  styleUrls: ['./show-all-users.component.scss']
})
export class ShowAllUsersComponent implements OnInit {
  [x: string]: any;

  constructor() { }

  storage: any = {};

  ngOnInit(): void {
    let keys = Object.keys(sessionStorage);
    for (var i = 0; i < keys.length; i++) {
      this.storage[keys[i]] = sessionStorage.getItem(keys[i]);
      console.log(this.storage[keys[i]].FirstName);
    }
    console.log(this.storage);
    var table: HTMLTableElement = <HTMLTableElement>document.getElementById("table");
    var rows = '';
    for (var p in this.storage) {
      let newRow = table.insertRow(-1);
      var i = 0;
      console.log(p);
      console.log(this.storage[p]);
      //console.log(typeof(this.storage[p]));
      this.emp = sessionStorage.getItem(p);
      this.emp = JSON.parse(this.emp);
      for (var k in this.emp) {
        //console.log(this.emp[k]);
        let newCell = newRow.insertCell(i);
        i = i + 1;
        let newText = document.createTextNode(this.emp[k]);
        newCell.appendChild(newText);
        if (i > 4) break;
      }

    }

  }
}



