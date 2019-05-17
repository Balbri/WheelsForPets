import { Component, OnInit } from '@angular/core';
import { Annonce } from '../Models/Annonce';
import { User } from '../Models/User';
import { BehaviorSubject } from 'rxjs';
import { AnnonceService } from '../Services/AnnonceService';
import { Message } from '../Models/Message';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {


  annonce : Annonce;
  redacteurs : User[];
  messages : Message[];
  acheteurs: User[];
  annonceList: BehaviorSubject<Annonce[]>;

  constructor(private annonceService: AnnonceService) { }

  ngOnInit() {
    this.annonceList = this.annonceService.annoncesDispo$;
    this.getRedacteur;
    console.log(this.annonceList);
  }

  getRedacteur() {
    this.annonceService.getUsers().subscribe(redacteur => this.redacteurs = redacteur);
  }


  getAcheteur() {
    this.annonceService.getUsers().subscribe(acheteur => this.acheteurs = acheteur);
  }
}
