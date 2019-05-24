import { Injectable, Input } from '@angular/core';

import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Message } from '../Models/Message';
import { MatSnackBar } from '@angular/material';


@Injectable({
    providedIn: 'root'
  })
  export class MessageService {
    
    id: number;
    private linkedMessages: Message[]= [];
    linkedMessages$: BehaviorSubject<Message[]> = new BehaviorSubject(this.linkedMessages);
   
    constructor(private httpClient: HttpClient,
      private snackBar: MatSnackBar){}

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

         /**
   * Fonction de création d'une nouvelle Annonce
   * Elle met à jour notre liste d'annonces et notre liste observable.
   * @param nveauMessage la nouvelle annonce à créer.
   */
  public createMessage(nveauMessage: Message) {
    this.httpClient.post<Message>('http://localhost:8080/api/annonces/messages/', nveauMessage).subscribe(
      nveauMessage => {
        this.linkedMessages.push(nveauMessage);
        this.linkedMessages$.next(this.linkedMessages);
      },
      error => {
        // popu-up erreur
        this.snackBar.open("Une erreur a empêché la création du message", 'ERREUR', {
          duration: 2000,
        });
      }
    );
  }

  }