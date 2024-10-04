import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PatientService } from '../../../service/patient.service';

@Component({
  selector: 'app-medical-info',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './medical-info.component.html',
  styleUrl: './medical-info.component.css'
})
export class MedicalInfoComponent implements OnInit {
  illness: string;
  duration:string;
  details:string;

  constructor(private patientService: PatientService){}
  
  ngOnInit(): void {
     this.patientService.medicalInfo$.subscribe(patient=>{
      this.illness = patient.illness;
      this.duration = patient.duration;
      this.details = patient.details
     })
  }

  onChange(){
    this.patientService.setMedicalInfo(this.illness,this.duration,this.details );
  }
}
