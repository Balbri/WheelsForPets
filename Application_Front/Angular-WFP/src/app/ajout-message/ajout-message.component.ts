import { Component, OnInit, Optional } from '@angular/core';
import {  ActivatedRoute } from '@angular/router';




@Component({
  selector: 'app-ajout-message',
  templateUrl: './ajout-message.component.html',
  styleUrls: ['./ajout-message.component.css']
})
export class AjoutMessageComponent implements OnInit {
 
  idAnnonce: number

  constructor( private route: ActivatedRoute,
   ) { }

  ngOnInit() {
    this.idAnnonce = +this.route.snapshot.params.id;
    console.log("test de passage d'id pour l'annonce dans le composant de création message: "+this.idAnnonce)
  }

  


}
