import { Injectable, Input } from '@angular/core';

import { BehaviorSubject, Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Message } from '../Models/Message';
import { User } from '../Models/User';
import { map } from 'rxjs/operators';



@Injectable({
    providedIn: 'root'
  })
  export class UserService {
    
    private id: number;
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


          /**
   * Cette fonction permet de trouver un livre dans la liste des livres chargés par l'application
   * grâce à son ID.
   * @param userId l'id qu'il faut rechercher dans la liste.
   */
  public findUser(userId: number): Observable<User> {
    if (userId) {
      if (!this.userList) {
        this.id = userId;
        return this.getUsers().pipe(map(users => users.find(user => user.userId === userId)));
      }
      return of(this.userList.find(user => user.userId === userId));
    } else {
      return of(new User(0, null, '', null, '', null, null, 0, null, null, null, null, null, null, null));
    }
  }

  }