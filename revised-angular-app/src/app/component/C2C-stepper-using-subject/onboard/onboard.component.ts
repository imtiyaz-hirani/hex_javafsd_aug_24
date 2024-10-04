import { Component } from '@angular/core';
import { StepperModule } from 'primeng/stepper';
import { ButtonModule } from 'primeng/button';
import { AdminNavbarComponent } from "../../admin/admin-navbar/admin-navbar.component";
import { PersonalInfoComponent } from "../personal-info/personal-info.component";
import { MedicalInfoComponent } from "../medical-info/medical-info.component";
import { RoomInfoComponent } from "../room-info/room-info.component";
import { SummaryComponent } from "../summary/summary.component";

@Component({
  selector: 'app-onboard',
  standalone: true,
  imports: [StepperModule, ButtonModule, AdminNavbarComponent, PersonalInfoComponent, MedicalInfoComponent, RoomInfoComponent, SummaryComponent],
  templateUrl: './onboard.component.html',
  styleUrl: './onboard.component.css'
})
export class OnboardComponent {

}
