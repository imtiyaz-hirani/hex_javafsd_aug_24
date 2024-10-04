import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-page2',
  standalone: true,
  imports: [],
  templateUrl: './page2.component.html',
  styleUrl: './page2.component.css'
})
export class Page2Component implements OnInit{

  vehicle: string=''; 
  constructor(private actRoute: ActivatedRoute){}
  
  ngOnInit(): void {
     this.vehicle = this.actRoute.snapshot.paramMap.get('vehicle')
  }


}
/** 
 * Router service helps us navigate with or with param
 * ActivatedRoute service helps us read the param from url 
 */

/**
 * LIFECYLE
 * --------
 * constructor : HTML+CSS --1 : use this for service injection
 * ngOnInit: OnInit --2 : use this for initializing variables 
 * ngOnDestroy : OnDestroy --3 : use this to un-subscribe from observable
 * 
 */