import { Component } from '@angular/core';
import { DoctorNavbarComponent } from "../doctor-navbar/doctor-navbar.component";

@Component({
  selector: 'app-doctor-dashboard',
  standalone: true,
  imports: [DoctorNavbarComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DoctorDashboardComponent {
  username: any = localStorage.getItem('username'); 

}
