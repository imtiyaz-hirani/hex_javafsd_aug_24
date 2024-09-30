import { Component } from '@angular/core';

@Component({
  selector: 'app-patient-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class PatientDashboardComponent {
  username: any = localStorage.getItem('username'); 

}
