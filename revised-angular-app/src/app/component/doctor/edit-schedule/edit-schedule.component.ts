import { Component, OnInit } from '@angular/core';
import { DoctorNavbarComponent } from "../doctor-navbar/doctor-navbar.component";
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminService } from '../../../service/admin.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-schedule',
  standalone: true,
  imports: [DoctorNavbarComponent, NgIf, NgFor, FormsModule],
  templateUrl: './edit-schedule.component.html',
  styleUrl: './edit-schedule.component.css'
})
export class EditScheduleComponent implements OnInit{
  apptdate: string='';
  day: string='';
  from:string=''
  to:string='';
  numOfAppt:number; 
  successMsg: string='';
  errorMsg:string='';
  days:string[] =[];
  id:any; 
  show: boolean = false; 

  constructor(private adminService: AdminService, 
    private actRoute: ActivatedRoute,
  private router: Router){
      //this.id= this.actRoute.snapshot.paramMap.get('id');  

     
  }
  ngOnInit(): void {
    
    this.adminService.getDays().subscribe({
      next: (data)=> this.days = data
    })

    this.adminService.schedule$.subscribe({
      next: (data)=>{
         
        this.id = data.id;
          this.apptdate = data.date;
          this.day = data.day;
          this.from = data.fromTime;
          this.to = data.toTime;
          this.numOfAppt = data.numberOfAppt;
 
      }
    })
    
    /*
    this.adminService.getScheduleDetailesById(this.id).subscribe({
      next:(data)=>{
        this.apptdate = data.date;
        this.day = data.day;
        this.from = data.fromTime;
        this.to = data.toTime;
        this.numOfAppt = data.numberOfAppt;
      },
      error: ()=>{}
    }); 
    */

    
  }


  resetmsg(){

  }

  onClick(){
      this.adminService.postSchedule({
        "id": this.id,
        "date":this.apptdate,
        "day":this.day,
        "fromTime":this.from,
        "toTime":this.to,
        "numberOfAppt":this.numOfAppt
      })
      .subscribe({
        next:(data)=>{
          this.successMsg = 'Appointment Schedule edited';
          this.show = true; 
        this.errorMsg = undefined
        },
        error: (err)=>{
          this.successMsg = undefined;
          this.show = false;
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

  onShowClick(){

    this.router.navigateByUrl("/doctor/schedule");

  }
}
