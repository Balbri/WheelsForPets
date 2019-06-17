import { Component, OnInit, OnChanges} from '@angular/core';
import { Message } from '../Models/Message';
import { MessageService } from '../Services/MessagesService';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AnnonceService } from '../Services/AnnonceService';
import { Annonce } from '../Models/Annonce';


@Component({
  selector: 'app-messages-de-lannonce',
  templateUrl: './messages-de-lannonce.component.html',
  styleUrls: ['./messages-de-lannonce.component.css'],
  
})
export class MessagesDeLannonceComponent implements OnInit {

  id : number;
  linkedMessagesList: BehaviorSubject<Message[]>;
  messageForm: FormGroup;
  annonceAffichee: Annonce;
  idDefault= null;
  titreInit = '';
  contenuInit = '';
  initialized = false;
  
  
  constructor(
    private messageService: MessageService,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private annonceService : AnnonceService,
   ) {}

  ngOnInit() {
    this.id = +this.route.snapshot.params.id;
    this.getAnnonceById(this.id);
    this.linkedMessagesList = this.messageService.linkedMessages$;
    this.messageService.publishLinkedMessages(this.id);
    this.initialized = true
    this.initForm();
    console.log(this.annonceAffichee)
    }
  
  initForm() {
    this.messageForm = this.formBuilder.group({
      contenuMessage: [this.contenuInit, Validators.required]
    });
  }

  onSave() {
      const formValue = this.messageForm.value;
    const newMessage = new Message(
      this.idDefault = 0,
      this.titreInit = ("Re : " + this.annonceAffichee.titre),
      formValue['contenuMessage'],
      new Date(),
     this.annonceAffichee,
     this.annonceAffichee.user,
    );
    console.log(newMessage);
    this.messageService.createMessage(newMessage);
  }

  getAnnonceById(id: number): void {
    this.annonceService.findAnnonce(id).subscribe(annonce => this.annonceAffichee = annonce);
  }
}
