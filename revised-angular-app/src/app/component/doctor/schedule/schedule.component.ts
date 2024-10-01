import { Component } from '@angular/core';
import { DoctorNavbarComponent } from "../doctor-navbar/doctor-navbar.component";
import { AdminService } from '../../../service/admin.service';
import { NgFor } from '@angular/common';
import { count } from 'rxjs';

@Component({
  selector: 'app-schedule',
  standalone: true,
  imports: [DoctorNavbarComponent,NgFor],
  templateUrl: './schedule.component.html',
  styleUrl: './schedule.component.css'
})
export class ScheduleComponent {
   schedule:any[]= [];
   totalPages : number =0;  
   numArry:number[]=[];
   counter: number=0;
   page:number =0;
   size:number = 3; 
   last: boolean=false; 
   first: boolean=true; 

   constructor(private adminService : AdminService){
    this.fetchData();
    
    console.log(this.numArry)
   }

   fetchData(){
    this.adminService.getDoctorSchedule(this.page,this.size).subscribe({
      next:(data)=>{
         this.schedule = data.content;
         this.totalPages = data.totalPages; 
         this.last = data.last; 
         this.first = data.first; 

         if(this.counter === 0){
          let i=0;
          while(i<this.totalPages){
              this.numArry.push(i); //0 1 
              i++; //1 2
            };
          }
          
        this.counter = this.counter+1;
      },
      error: (err)=>{
        console.log(err.message)
      }
    })
   }

   onPageNumberClick(n:number){
   
    this.page = n; 
    this.fetchData();
   }

   onNext(){
    this.page = this.page + 1; 
    this.fetchData();
    
   }

   onPrev(){
    this.page = this.page - 1;
    this.fetchData();
   }

}
