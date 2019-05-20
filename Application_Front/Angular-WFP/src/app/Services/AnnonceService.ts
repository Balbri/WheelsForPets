import { Injectable } from '@angular/core';
import { Annonce } from '../Models/Annonce';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../Models/User';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Animal } from '../Models/Animal';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })
  export class AnnonceService {

    private allAnnoncesDispo: Annonce[];
    allAnnoncesDispo$: BehaviorSubject<Annonce[]> = new BehaviorSubject(this.allAnnoncesDispo);
    private annoncesDispo: Annonce[];
    annoncesDispo$: BehaviorSubject<Annonce[]> = new BehaviorSubject(this.annoncesDispo);

    constructor(private httpClient: HttpClient){}


    getUsers(): Observable<User[]> {
        return this.httpClient.get<User[]>('http://localhost:8080/api/admin/users');
      }
    
    getMessages(): Observable<Message[]> {
        return this.httpClient.get<Message[]>('http://localhost:8080/api/messages');
      }

    getAnimaux(): Observable<Animal[]> {
        return this.httpClient.get<Animal[]>('http://localhost:8080/api/animaux');
      }

      private get3Annonces(): Observable<Annonce[]> {
        return this.httpClient.get<Annonce[]>('http://localhost:8080/api/annonces/dernieres');
      }

    private getAnnonces(): Observable<Annonce[]> {
        return this.httpClient.get<Annonce[]>('http://localhost:8080/api/annonces')
    }

    
    public publishLastAnnonces() {
        this.get3Annonces().subscribe(
          annoncesList => {
            this.annoncesDispo = annoncesList;
            this.annoncesDispo$.next(this.annoncesDispo);
          }
        );
      }

      public publishAnnonces() {
        this.getAnnonces().subscribe(
          allAnnoncesList => {
            this.allAnnoncesDispo = allAnnoncesList;
            this.allAnnoncesDispo$.next(this.allAnnoncesDispo);
          }
        );
      }

   
    /**
   * Cette fonction permet de trouver un livre dans la liste des livres chargés par l'application
   * grâce à son ID.
   * @param annonceId l'id qu'il faut rechercher dans la liste.
   */
  public findAnnonce(annonceId: number): Observable<Annonce> {
    if (annonceId) {
      if (!this.allAnnoncesDispo) {
        return this.getAnnonces().pipe(map(annonces => annonces.find(annonce => annonce.annonceId === annonceId)));
      }
      return of(this.annoncesDispo.find(annonce => annonce.annonceId === annonceId));
    } else {
      return of(new Annonce(0, null, '', '', '', null, null, '', 0, null, null, null, null, null, null, null));
    }
  }




  }