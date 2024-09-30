import { Component } from '@angular/core';
import { DoctorNavbarComponent } from "../doctor-navbar/doctor-navbar.component";
import { AdminService } from '../../../service/admin.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-schedule',
  standalone: true,
  imports: [DoctorNavbarComponent,NgFor],
  templateUrl: './schedule.component.html',
  styleUrl: './schedule.component.css'
})
export class ScheduleComponent {
   schedule:any[]= [];

   constructor(private adminService : AdminService){
    this.adminService.getDoctorSchedule().subscribe({
      next:(data)=>{
        this.schedule = data
        console.log(this.schedule)
      },
      error: (err)=>{
        console.log(err.message)
      }
    })

   }
}
