import { Component } from '@angular/core';

@Component({
  selector: 'app-doctor-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DoctorDashboardComponent {
  username: any = localStorage.getItem('username'); 

}
