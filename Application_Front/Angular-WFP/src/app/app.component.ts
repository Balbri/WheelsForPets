import { Component, OnInit } from '@angular/core';
import { AnnonceService } from './Services/AnnonceService';
import { MessageService } from './Services/MessagesService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Wheels For Pets';

  constructor(private annoncesService: AnnonceService
   
   
    ) {}

    ngOnInit() {
      this.annoncesService.publishLastAnnonces();
      this.annoncesService.publishAnnonces();
      
    }
}
