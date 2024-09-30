import { Component } from '@angular/core';
import { DoctorNavbarComponent } from "../doctor-navbar/doctor-navbar.component";

@Component({
  selector: 'app-schedule',
  standalone: true,
  imports: [DoctorNavbarComponent],
  templateUrl: './schedule.component.html',
  styleUrl: './schedule.component.css'
})
export class ScheduleComponent {

}
