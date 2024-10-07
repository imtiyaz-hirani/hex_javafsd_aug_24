import { Component, OnInit } from '@angular/core';
import { DoctorNavbarComponent } from "../doctor/doctor-navbar/doctor-navbar.component";
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../service/product.service';
import { Product } from '../../model/product';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-product-file-upload',
  standalone: true,
  imports: [DoctorNavbarComponent, FormsModule, NgIf ,NgFor],
  templateUrl: './product-file-upload.component.html',
  styleUrl: './product-file-upload.component.css'
})
export class ProductFileUploadComponent implements OnInit{
title; string='';
price: string=''
product: Product=new Product();
show: boolean = false; 
file: File = null; 
imageMsg: string=''; 
images: string[] = [];
constructor(private productService : ProductService){}

ngOnInit(): void {
  throw new Error('Method not implemented.');
}

onAddProduct(){
  this.product.title = this.title; 
  this.product.price = this.price; 

  this.productService.addProduct(this.product).subscribe({
    next: (data)=>{
      this.product=data; 
      this.show = true; 
      console.log(this.product) 
    }
  })
}

onChange(event: any){
 // console.log(event.target.files[0])
  this.file = event.target.files[0];
}

onUpload(){
  let formData = new FormData();
  formData.set('file',this.file); 
  this.productService.uploadImage(formData,this.product.id ).subscribe({
      next:(data)=>{
        this.images.push(this.file.name)
        this.imageMsg = 'Image ' + this.file.name + ' is uploaded' ;
        this.file = null;
      },

  }); 
}
}
