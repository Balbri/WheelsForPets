import { Component, OnInit } from '@angular/core';
import { Annonce } from '../Models/Annonce';
import { User } from '../Models/User';
import { BehaviorSubject } from 'rxjs';
import { AnnonceService } from '../Services/AnnonceService';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {


  annonce : Annonce;
  redacteurs : User[];

  annoncesDispo: BehaviorSubject<Annonce[]>;

  constructor(private annonceService: AnnonceService) { }

  ngOnInit() {
    this.annoncesDispo = this.annonceService.annoncesDispo$;
    this.getRedacteur;
  }

  getRedacteur() {
    this.annonceService.getUsers().subscribe(redacteur => this.redacteurs = redacteur);
  }

}
