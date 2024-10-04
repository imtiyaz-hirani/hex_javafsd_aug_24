import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Patient } from '../../../model/patient.model';
import { PatientService } from '../../../service/patient.service';

@Component({
  selector: 'app-personal-info',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './personal-info.component.html',
  styleUrl: './personal-info.component.css'
})
export class PersonalInfoComponent implements OnInit{
  name: string;
  email: string;
  contact: string;
  patient: Patient={
    name:'',
    email:'',
    contact:''
  };

  constructor(private patientService: PatientService){}
  ngOnInit(): void {
    this.patientService.personalInfo$.subscribe(patient=>{
      this.name = patient.name;
        this.email = patient.email;
        this.contact = patient.contact;
     })
  }
  onChange(){
    this.patientService.setPersonalInfo(this.name,this.email,this.contact);
  }
}
