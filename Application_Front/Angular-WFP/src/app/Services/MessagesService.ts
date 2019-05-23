import { Injectable, Input } from '@angular/core';

import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Message } from '../Models/Message';


@Injectable({
    providedIn: 'root'
  })
  export class MessageService {
    
    id: number;
    private linkedMessages: Message[] = [];
    linkedMessages$: BehaviorSubject<Message[]> = new BehaviorSubject(this.linkedMessages);
   
    constructor(private httpClient: HttpClient){}

    
      public publishLinkedMessages(id: number) {

        this.getMessages(id).subscribe(
          messagesList => {
            this.linkedMessages = messagesList;
            this.linkedMessages$.next(this.linkedMessages);
          }
        );
      }

     public getMessages(id): Observable<Message[]> {
        return this.httpClient.get<Message[]>('http://localhost:8080/api/annonces/messages/' + id);
      }

     
  }