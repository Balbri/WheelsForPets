import { Component, OnInit } from '@angular/core';
import { AnnonceService } from './Services/AnnonceService';
import { UserService } from './Services/UserService';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Wheels For Pets';

  constructor(private annoncesService: AnnonceService,
    private userService : UserService
   
   
    ) {}

    ngOnInit() {
      this.annoncesService.publishLastAnnonces();
      this.annoncesService.publishAnnonces();
      this.userService.publishUsers();
      
    }
}
