import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DoctorNavbarComponent } from "../doctor-navbar/doctor-navbar.component";
import { NgFor, NgIf } from '@angular/common';
import { AdminService } from '../../../service/admin.service';

@Component({
  selector: 'app-add-schedule',
  standalone: true,
  imports: [FormsModule, DoctorNavbarComponent, NgFor, NgIf],
  templateUrl: './add-schedule.component.html',
  styleUrl: './add-schedule.component.css'
})
export class AddScheduleComponent {

  apptdate: string='';
  day: string='';
  from:string=''
  to:string='';
  numOfAppt:number;

  days:string[] = [];
  successMsg:string=undefined
  errorMsg:string=undefined

  constructor(private adminService: AdminService){
    this.adminService.getDays().subscribe({
      next: (data)=> this.days = data
    })
  }
  
    onClick(){
       this.adminService.postSchedule({
        "date":this.apptdate,
        "day":this.day,
        "fromTime":this.from,
        "toTime":this.to,
        "numberOfAppt":this.numOfAppt
    }).subscribe({
      next:(data)=>{
        this.successMsg = 'Appointment Schedule added';
        this.errorMsg = undefined
      },
      error:(err)=>{
        this.successMsg = undefined;
        console.log(err)
        this.errorMsg = err.message
      }
    })
    }

    resetmsg(){
      this.successMsg = undefined;
      this.errorMsg=undefined;
    }
}
