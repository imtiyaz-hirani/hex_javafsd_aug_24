import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
 import { NgFor } from '@angular/common';
import { Employee } from '../model/Employee';
import { EmployeeService } from '../service/employee.service';
 
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NgFor],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
}) 
export class AppComponent {

  employee:Employee[];

  constructor(private employeeService: EmployeeService){
    this.employee = this.employeeService.getAllEmployee();
  }
}
