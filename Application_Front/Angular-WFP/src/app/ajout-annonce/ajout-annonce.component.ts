import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup } from '@angular/forms'
import { Message } from '../Models/Message';
import { User } from '../Models/User';
import { Annonce } from '../Models/Annonce';
import { AnnonceService } from '../Services/AnnonceService';
import { Location } from '@angular/common';
import { UserService } from '../Services/UserService';
import { BehaviorSubject } from 'rxjs';
@Component({
  selector: 'app-ajout-annonce',
  templateUrl: './ajout-annonce.component.html',
  styleUrls: ['./ajout-annonce.component.css']
})
export class AjoutAnnonceComponent implements OnInit {

  constructor(
    private location: Location,
    private annonceService: AnnonceService,
    private userService: UserService) { }

  public annonceForm: FormGroup;
  private annonceId = 0;
  private validee = false;
  messageList: Message[] = [];
 
  
  
  acheteur: User;
  user: User;
  allUsersList: BehaviorSubject<User[]>;


  ngOnInit() {
    this.allUsersList = this.userService.userList$;
    this.userService.publishUsers();
    //this.allUsersList.subscribe();
    this.user = this.allUsersList.value[1];
    console.log("log de la liste d'users");
    console.log(this.allUsersList);
    console.log("log de allUsersList[1]");
    console.log(this.allUsersList.value[1]);
    this.annonceForm = new FormGroup({
      titre: new FormControl('', [Validators.required, Validators.maxLength(60)]),
      description: new FormControl('', [Validators.required, Validators.maxLength(1000)]),
      dateDepart: new FormControl(new Date()),
      villeDepart: new FormControl('', [Validators.required, Validators.maxLength(100)]),
      cpDepart: new FormControl('', [Validators.required, Validators.min(0o1000), Validators.max(98620)]),
      dateArrivee: new FormControl(new Date()),
      villeArrivee: new FormControl('', [Validators.required, Validators.maxLength(100)]),
      cpArrivee: new FormControl('', [Validators.required, Validators.min(0o1000), Validators.max(98620)]),
      prix: new FormControl('', [Validators.required, Validators.maxLength(3)])
    });
  }

  public hasError = (controlName: string, errorName: string) => {
    return this.annonceForm.controls[controlName].hasError(errorName);
  }

  public onCancel = () => {
    this.location.back();
  }

  public createAnnonce = (annonceFormValue) => {
    if (this.annonceForm.valid) {
      this.executeAnnonceCreation(annonceFormValue);
    }
  }

  private executeAnnonceCreation = (annonceFormValue) => {
    let annonce: Annonce = {
      titre: annonceFormValue.titre,
      description: annonceFormValue.description,
      dateDepart: annonceFormValue.dateDepart,
      villeDepart: annonceFormValue.villeDepart,
      cpDepart: annonceFormValue.cpDepart,
      dateArrivee: annonceFormValue.dateArrivee,
      villeArrivee: annonceFormValue.villeArrivee,
      cpArrivee: annonceFormValue.cpArrivee,
      dateModif: new Date(),
      dateRedaction: new Date(),
      annonceId: this.annonceId,
      prix: annonceFormValue.prix,
      validee: this.validee,
      messageList: this.messageList,
      user: this.user,
      acheteur: this.acheteur = null
    }
    this.annonceService.createAnnonce(annonce);
  }
}
