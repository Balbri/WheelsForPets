import { Component, OnInit } from '@angular/core';
import { Annonce } from '../Models/Annonce';
import { ActivatedRoute, Router } from '@angular/router';
import { AnnonceService } from '../Services/AnnonceService';

@Component({
  selector: 'app-page-annonce',
  templateUrl: './page-annonce.component.html',
  styleUrls: ['./page-annonce.component.css']
})
export class PageAnnonceComponent implements OnInit {

  
  id: number;
  annonceAffichee: Annonce;

  constructor(
    private route: ActivatedRoute,
    private annonceService: AnnonceService
    ) {}

  ngOnInit() {
    this.id = +this.route.snapshot.params.id;
    this.getAnnonceById(this.id);
    
    console.log (this.annonceAffichee.redacteur)
  }

  

  getAnnonceById(id: number): void {
    this.annonceService.findAnnonce(id).subscribe(annonce => this.annonceAffichee = annonce, redacteur => this.annonceAffichee.redacteur = redacteur);
  }
}
