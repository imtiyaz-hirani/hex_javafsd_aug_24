import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Page2Component } from '../page2/page2.component';

@Component({
  selector: 'app-page1',
  standalone: true,
  imports: [],
  templateUrl: './page1.component.html',
  styleUrl: './page1.component.css'
})
export class Page1Component {

  constructor(private router: Router){}
  onClick(vehicle: string){
    this.router.navigate(['/info',vehicle]);
  }
}
