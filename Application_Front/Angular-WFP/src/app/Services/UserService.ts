import { Injectable, Input } from '@angular/core';

import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Message } from '../Models/Message';
import { User } from '../Models/User';



@Injectable({
    providedIn: 'root'
  })
  export class UserService {
    
    
    private userList: User[]= [];
    userList$: BehaviorSubject<User[]> = new BehaviorSubject(this.userList);
   
    constructor(private httpClient: HttpClient
      ){}

      public publishUsers() {
        this.getUsers().subscribe(
          users => {
            this.userList = users;
            this.userList$.next(this.userList);
            
          }
        );
       
      }

     public getUsers(): Observable<User[]> {
        return this.httpClient.get<User[]>('http://localhost:8080/api/admin/users/');
      }

    

  }