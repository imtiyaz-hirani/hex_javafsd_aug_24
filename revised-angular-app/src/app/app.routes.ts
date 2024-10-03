import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { AdminDashboardComponent } from './component/admin/dashboard/dashboard.component';
import { DoctorDashboardComponent } from './component/doctor/dashboard/dashboard.component';
import { PatientDashboardComponent } from './component/patient/dashboard/dashboard.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { LogoutComponent } from './auth/logout/logout.component';
import { DoctorListComponent } from './component/admin/doctor-list/doctor-list.component';
import { ScheduleComponent } from './component/doctor/schedule/schedule.component';
import { AddScheduleComponent } from './component/doctor/add-schedule/add-schedule.component';
import { AuthGuard } from './guard/auth.guard';
 
export const routes: Routes = [
    {
        "path" : "" , component: LoginComponent,
    },
    {
        "path": "admin/dashboard" , component: AdminDashboardComponent, canActivate: [AuthGuard]
    },
    {
        "path":"admin/doctor-list", component: DoctorListComponent, canActivate: [AuthGuard]
    },
    {
        "path":"doctor/schedule", component: ScheduleComponent, canActivate: [AuthGuard]
    },
    {
        "path": "doctor/dashboard" , component: DoctorDashboardComponent, canActivate: [AuthGuard]
    },
    {
        "path": "doctor/add-schedule" , component: AddScheduleComponent, canActivate: [AuthGuard]
    },
    {
        "path": "patient/dashboard" , component: PatientDashboardComponent, canActivate: [AuthGuard]
    },
    {
        "path": "logout" , component: LogoutComponent
    },
    {
        "path": "**" , component: PageNotFoundComponent
    }

];
