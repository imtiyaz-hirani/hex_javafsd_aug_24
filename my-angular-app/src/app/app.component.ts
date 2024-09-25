import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
 import { NgFor } from '@angular/common';
import { Employee } from '../model/Employee';
 
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NgFor],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
}) 
export class AppComponent {
  employee:Employee[]=[];

  employee1:Employee={
    name:"harry potter",
    email:"harry@gmail.com"
  };
  employee2:Employee={
    name:"ronald weasley",
    email:"ronald@gmail.com"
  };
  employee3:Employee={
    name:"hermione granger",
    email:"hermione@gmail.com"
  }

  constructor(){
    this.employee.push(this.employee1);
    this.employee.push(this.employee2);
    this.employee.push(this.employee3);
  }
}
