import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { AdminNavbarComponent } from "../admin-navbar/admin-navbar.component";
 

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [RouterLink, AdminNavbarComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class AdminDashboardComponent {
   
}
