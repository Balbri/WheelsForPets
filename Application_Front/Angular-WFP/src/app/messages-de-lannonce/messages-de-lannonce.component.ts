import { Component, OnInit} from '@angular/core';
import { Message } from '../Models/Message';
import { MessageService } from '../Services/MessagesService';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AnnonceService } from '../Services/AnnonceService';
import { User } from '../Models/User';


@Component({
  selector: 'app-messages-de-lannonce',
  templateUrl: './messages-de-lannonce.component.html',
  styleUrls: ['./messages-de-lannonce.component.css'],
  
})
export class MessagesDeLannonceComponent implements OnInit {

  id : number;
  linkedMessagesList: BehaviorSubject<Message[]>;
  messageForm: FormGroup;
  annonce= this.getAnnonceById(this.id);
  annonceAffichee;
  idDefault= null;
  titreInit = '';
  contenuInit = '';
  redacteur: User
  
  constructor(
    private messageService: MessageService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private annonceService : AnnonceService,
   
    ) {}

  ngOnInit() {
    this.id = +this.route.snapshot.params.id;
    this.annonceAffichee.annonceId = +this.route.snapshot.params.id;
    this.linkedMessagesList = this.messageService.linkedMessages$;
    this.messageService.publishLinkedMessages(this.id);
    
    this.initForm();
    this.getAnnonceById(this.id);
    
  }

  initForm() {
    this.messageForm = this.formBuilder.group({
      titreMessage: [this.titreInit, Validators.required],
      contenuMessage: [this.contenuInit, Validators.required]
    });
  }

  onSave() {
    const formValue = this.messageForm.value;
    
    
    
    const newMessage = new Message(
      this.idDefault = 0,
      formValue['titreMessage'],
      formValue['contenuMessage'],
      new Date(),
     this.annonceAffichee,
     this.annonceAffichee.redacteur
      
    );
    
    
      this.messageService.createMessage(newMessage);
    console.log("lannonce est " )
    console.log("l'utilisateur de l'annonce est " +this.annonceAffichee.User)
    //this.location.back();
  }

  getAnnonceById(id: number): void {
    this.annonceService.findAnnonce(id).subscribe(annonce => this.annonceAffichee = annonce);
  }
}
