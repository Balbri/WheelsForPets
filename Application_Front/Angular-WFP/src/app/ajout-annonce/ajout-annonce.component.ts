import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup} from '@angular/forms'
import { Message } from '../Models/Message';
import { User } from '../Models/User';
import { Annonce } from '../Models/Annonce';
import { AnnonceService } from '../Services/AnnonceService';
import { Location } from '@angular/common';
@Component({
  selector: 'app-ajout-annonce',
  templateUrl: './ajout-annonce.component.html',
  styleUrls: ['./ajout-annonce.component.css']
})
export class AjoutAnnonceComponent implements OnInit {

  constructor(private location: Location, private annonceService: AnnonceService) { }
  /*
  minDate = new Date();
  maxDate = new Date(this.minDate.getTime() + (90 * 24 * 60 * 60 * 1000));
  minDateArrivee = new Date();
  maxDateArrivee = new Date(this.minDate.getTime() + (1 * 24 * 60 * 60 * 1000));
  dateCtrlDepart : FormControl;
  dateCtrlArrivee : FormControl;
 

  annonceForm: FormGroup;
  idDefault = null;
  titreInit = '';
  descriptionInit = '';
  villeDepartInit = '';
  cpDepartInit = null;
  villeArriveeInit = '';
  cpArriveeInit = '';
  prixInit = null;
  validee = false;
  dateModif = new Date();
  messageList: Message[] = [];
  user: User;
  acheteur: User;
  dateRedaction = new Date();
 
  
  

  constructor(
    private formBuilder: FormBuilder,
    private annonceService: AnnonceService,
    private location: Location,
  ) {
    
   }

  ngOnInit() {
    //this.dateCtrlDepart= new FormControl('', [Validators.required]);
    //this.dateCtrlArrivee = new FormControl('', [Validators.required]);
    this.initForm();
  }

  /***
   * Pour le DatePicker de la création d'annonce, on fixe la limite minimale cliquable avec @param minDate . 
   * On génère la limite maximale cliquable à jour J + 3 mois grâce à @param maxDate.
   */
  /*
  initForm() {
    this.annonceForm = this.formBuilder.group({
      titre: [this.titreInit, Validators.required],
      description: [this.descriptionInit, Validators.required],
      villeDepart: [this.villeDepartInit, Validators.required],
      cpDepart: [this.cpDepartInit, Validators.required],
      villeArrivee: [this.villeArriveeInit, Validators.required],
      cpArrivee: [this.cpArriveeInit, Validators.required],
      prix: [this.prixInit, Validators.required],  
      dateDepart: [this.dateCtrlDepart, Validators.required],
      dateArrivee:[this.dateCtrlArrivee, Validators.required]
    });
  }

  

  onSave() {
    const formValue = this.annonceForm.value;
    const newAnnonce = new Annonce(
      this.idDefault=0,
      this.dateRedaction,
      formValue['titre'],
      formValue['description'],
      formValue['villeDepart'],
      formValue['cpDepart'],
      formValue['dateCtrlDepart'],
      formValue['villeArrivee'],
      formValue['cpArrivee'],
      formValue['dateCtrlArrivee'],
      formValue['prix'],
      this.validee,
      this.dateModif,
      this.messageList,
      null,
      null);

      this.annonceService.createAnnonce(newAnnonce);
      this.annonceService.publishLastAnnonces();
      this.annonceService.publishAnnonces

  }*/
  public annonceForm: FormGroup;
  
  private annonceId = 0;
  private validee = false;
  messageList: Message[] = [];
  user: User;
  acheteur: User;
  
  ngOnInit() {
    
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
 
  public hasError = (controlName: string, errorName: string) =>{
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
      user: this.user = null,
      acheteur: this.acheteur = null
    }
 
   
    this.annonceService.createAnnonce(annonce);
  }
}
