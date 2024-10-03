import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DoctorNavbarComponent } from "../doctor-navbar/doctor-navbar.component";
import { NgFor, NgIf } from '@angular/common';
import { AdminService } from '../../../service/admin.service';
import { Router } from '@angular/router';

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

  constructor(private adminService: AdminService, private router: Router){
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
        if(err.status == 305){
          this.errorMsg = err.error
        }
        else{
          this.router.navigateByUrl("/**")
        }
      }
    })
    }

    resetmsg(){
      this.successMsg = undefined;
      this.errorMsg=undefined;
    }
}
