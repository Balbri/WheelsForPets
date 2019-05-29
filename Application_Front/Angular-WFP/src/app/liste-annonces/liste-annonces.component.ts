import { Component, OnInit } from '@angular/core';
import { Annonce } from '../Models/Annonce';
import { BehaviorSubject } from 'rxjs';
import { AnnonceService } from '../Services/AnnonceService';


@Component({
  selector: 'app-liste-annonces',
  templateUrl: './liste-annonces.component.html',
  styleUrls: ['./liste-annonces.component.css']
})
export class ListeAnnoncesComponent implements OnInit {

  annonces: Annonce[];
  
  allAnnoncesList: BehaviorSubject<Annonce[]>;

  constructor(
    private annonceService: AnnonceService,
    ) {}

  ngOnInit() {
      this.allAnnoncesList = this.annonceService.allAnnoncesDispo$;
  }
}
