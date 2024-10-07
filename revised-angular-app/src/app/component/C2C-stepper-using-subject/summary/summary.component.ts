import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PatientService } from '../../../service/patient.service';

@Component({
  selector: 'app-summary',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './summary.component.html',
  styleUrl: './summary.component.css'
})
export class SummaryComponent implements OnInit{
    name: string;
    email: string;
    contact: string;

    illness:string;
    duration: string;
    details:string;

    room: string; 
    
    constructor(private patientService: PatientService){}

  ngOnInit(): void {
      this.patientService.personalInfo$.subscribe( patient=>{
        this.name = patient.name;
        this.email = patient.email;
        this.contact = patient.contact;
       
      })

      this.patientService.medicalInfo$.subscribe(patient=>{
        this.illness = patient.illness;
        this.duration = patient.duration;
        this.details = patient.details;
      });

      this,this.patientService.roomInfo$.subscribe(patient=>{
        this.room = patient.type;
      })
  }

  onBtnClick(){
    console.log(this.name + '--', this.email, + '--' + this.contact );
    console.log(this.illness + '--', this.duration, + '--' + this.details );
    console.log(this.room);
    
  }
}
