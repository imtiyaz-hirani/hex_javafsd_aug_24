import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  getAllDoctorApi: string = 'http://localhost:8082/doctor/all';
  
  constructor(private http: HttpClient) { }

  getAllDoctors():Observable<any>{

    return this.http.get<any>(this.getAllDoctorApi , {
      headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token'))
    });
  }

  getDays():Observable<any>{
    return this.http.get('http://localhost:8082/doctor/days');
  }
  postSchedule(obj:any):Observable<any>{
    return this.http.post('http://localhost:8082/doctor/schedule/add', obj, 
      {
        headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token'))
      }
    )
  }

  getDoctorSchedule():Observable<any>{
    return this.http.get('http://localhost:8082/doctor/schedule/all', 
      {
        headers: new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('token'))
      }
    )
  }
}
