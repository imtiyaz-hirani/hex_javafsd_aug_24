import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { AdminDashboardComponent } from './component/admin/dashboard/dashboard.component';
import { DoctorDashboardComponent } from './component/doctor/dashboard/dashboard.component';
import { PatientDashboardComponent } from './component/patient/dashboard/dashboard.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { LogoutComponent } from './auth/logout/logout.component';
import { DoctorListComponent } from './component/admin/doctor-list/doctor-list.component';
import { ScheduleComponent } from './component/doctor/schedule/schedule.component';
 
export const routes: Routes = [
    {
        "path" : "" , component: LoginComponent
    },
    {
        "path": "admin/dashboard" , component: AdminDashboardComponent
    },
    {
        "path":"admin/doctor-list", component: DoctorListComponent
    },
    {
        "path": "doctor/dashboard" , component: DoctorDashboardComponent
    },
    {
        "path": "doctor/add-schedule" , component: ScheduleComponent
    },
    {
        "path": "patient/dashboard" , component: PatientDashboardComponent
    },
    {
        "path": "logout" , component: LogoutComponent
    },
    {
        "path": "**" , component: PageNotFoundComponent
    }

];
