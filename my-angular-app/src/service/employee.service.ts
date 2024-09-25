import { Injectable } from "@angular/core";
import { Employee } from "../model/Employee";

@Injectable({
    providedIn:"root" 
})
export class EmployeeService{

    employee:Employee[]=[];
    employee1:Employee; 
    employee2:Employee;
    employee3:Employee;

    getAllEmployee() : Employee[]{
        this.employee1={
            name:"harry potter",
            email:"harry@gmail.com"
          };
          this.employee2={
            name:"ronald weasley",
            email:"ronald@gmail.com"
          };
          this.employee3={
            name:"hermione granger",
            email:"hermione@gmail.com"
          }

          this.employee.push(this.employee1);
        this.employee.push(this.employee2);
        this.employee.push(this.employee3);

        return this.employee;
    }
}