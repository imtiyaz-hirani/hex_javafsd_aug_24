import { Component } from '@angular/core';
import { Router } from '@angular/router';
 

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class AdminDashboardComponent {
  username: any = localStorage?.getItem('username'); 
  

  constructor(private router: Router){ }//injecting router service

  onLogout(){
    this.router.navigateByUrl('/logout'); 
  }
}
