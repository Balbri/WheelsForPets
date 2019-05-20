import { Component, OnInit } from '@angular/core';
import { Annonce } from '../Models/Annonce';
import { BehaviorSubject } from 'rxjs';
import { AnnonceService } from '../Services/AnnonceService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {


  annonce : Annonce;
  annonceList: BehaviorSubject<Annonce[]>;

  constructor(private annonceService: AnnonceService,
    private router: Router) { }

  ngOnInit() {
    this.annonceList = this.annonceService.annoncesDispo$;
  }

 
}
