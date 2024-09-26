import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
 import { NgFor, NgIf } from '@angular/common';
import { NavbarComponent } from "./component/navbar/navbar.component";
import { UserListComponent } from "./component/user-list/user-list.component";
import { UserAddComponent } from "./component/user-add/user-add.component";
  
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,  NgFor, NgIf, NavbarComponent, UserListComponent, UserAddComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
}) 
export class AppComponent {
 
}
