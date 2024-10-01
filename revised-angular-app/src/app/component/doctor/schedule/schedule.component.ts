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
   size:number = 100; 
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

   filterByCurrentWeek(){
      let todaysDate= new Date();
      let todaysDay = new Date().getDay(); 
      let startDate = new Date(todaysDate.setDate(todaysDate.getDate() - (todaysDay-1)))
      let todaysDate1 = new Date();
      let endDate = new Date(todaysDate1.setDate(todaysDate1.getDate() + (6-todaysDay)))
      let fromDate = startDate.toISOString().split('T')[0]; 
      let toDate=endDate.toISOString().split('T')[0]; 
      
      this.schedule = this.schedule.filter(e=> e.date >= fromDate && e.date <= toDate )
   }

   filterByToday(){
      let todaysDate= new Date();
      this.schedule = this.schedule
            .filter(s=>new Date(s.date).toLocaleDateString() === 
                       new Date().toLocaleDateString()); 
   }

   getAll(){
      this.fetchData();
   }
}
