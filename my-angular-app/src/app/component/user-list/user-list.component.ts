import { Component } from '@angular/core';
import { UserService } from '../../service/user.service';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [NgFor,NgIf],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent {

  users:any[] =[];
  isDelete: boolean = false;
  deleteMsg: string=''
  constructor(private userService: UserService){
    this.userService.getUsers().subscribe({
        next: (data)=>{
          this.users = data;
        },
        error: (err)=>{
          console.log(err)
        }
    });
  }

  onDelete(id:number,name:string){
    this.users = this.users.filter(u=>u.id != id);
    this.isDelete = true;
    this.deleteMsg = 'User : '+ name+ '\'s info deleted';
  }
}

//()=>{} - arrow function 
