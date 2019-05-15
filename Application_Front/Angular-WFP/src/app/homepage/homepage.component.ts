import { Component, OnInit } from '@angular/core';
import { Annonce } from '../Models/Annonce';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {


  annonce : Annonce;
  constructor() { }

  ngOnInit() {
  }

}
