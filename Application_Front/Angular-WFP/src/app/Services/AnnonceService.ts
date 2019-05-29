import { Injectable } from '@angular/core';
import { Annonce } from '../Models/Annonce';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../Models/User';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Animal } from '../Models/Animal';
import { map } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material';

@Injectable({
    providedIn: 'root'
  })
  export class AnnonceService {
    private anId: number;
    private allAnnoncesDispo: Annonce[];
    allAnnoncesDispo$: BehaviorSubject<Annonce[]> = new BehaviorSubject(this.allAnnoncesDispo);
    private annoncesDispo: Annonce[];
    annoncesDispo$: BehaviorSubject<Annonce[]> = new BehaviorSubject(this.annoncesDispo);
    private selectedAnnonce: Annonce;
    selectedAnnonce$: BehaviorSubject<Annonce> = new BehaviorSubject(this.selectedAnnonce);
    constructor(private httpClient: HttpClient, 
      private snackBar: MatSnackBar){}


    getUsers(): Observable<User[]> {
        return this.httpClient.get<User[]>('http://localhost:8080/api/admin/users');
      }
    
    getMessages(): Observable<Message[]> {
        return this.httpClient.get<Message[]>('http://localhost:8080/api/annonces/messages/'+this.anId);
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

    private getAnnonce(anId): Observable<Annonce> {
      return this.httpClient.get<Annonce>('http://localhost:8080/api/annonces'+ this.anId)
    }
    
     public publishSelectedAnnonces(id:number) {
      this.getAnnonce(this.anId).subscribe(
        annonce => {
          this.selectedAnnonce = annonce;
          this.selectedAnnonce$.next(this.selectedAnnonce);
        }
      );
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
        this.anId = annonceId;
        return this.getAnnonces().pipe(map(annonces => annonces.find(annonce => annonce.annonceId === annonceId)));
      }
      return of(this.annoncesDispo.find(annonce => annonce.annonceId === annonceId));
    } else {
      return of(new Annonce(0, null, '', '', '', null, null, '', 0, null, null, null, null, null, null, null));
    }
  }




   /**
   * Fonction de création d'une nouvelle Annonce
   * Elle met à jour notre liste d'annonces et notre liste observable.
   * @param nouvelleAnnonce la nouvelle annonce à créer.
   */
  public createAnnonce(nouvelleAnnonce: Annonce) {
    this.httpClient.post<Annonce>('http://localhost:8080/api/annonces', nouvelleAnnonce).subscribe(
      nouvelleAnnonce => {
        this.allAnnoncesDispo.push(nouvelleAnnonce);
        this.allAnnoncesDispo$.next(this.allAnnoncesDispo);
      },
      error => {
        // popu-up erreur
        this.snackBar.open("L\'annonce n'a pas pu être créée", 'ERREUR', {
          duration: 2000,
        });
      }
    );
  }




  }