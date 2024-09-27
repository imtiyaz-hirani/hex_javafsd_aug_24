import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { AdminDashboardComponent } from './component/admin/dashboard/dashboard.component';
import { DoctorDashboardComponent } from './component/doctor/dashboard/dashboard.component';
import { PatientDashboardComponent } from './component/patient/dashboard/dashboard.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
 
export const routes: Routes = [
    {
        "path" : "" , component: LoginComponent
    },
    {
        "path": "admin/dashboard" , component: AdminDashboardComponent
    },
    {
        "path": "doctor/dashboard" , component: DoctorDashboardComponent
    },
    {
        "path": "patient/dashboard" , component: PatientDashboardComponent
    },
    {
        "path": "**" , component: PageNotFoundComponent
    }

];
