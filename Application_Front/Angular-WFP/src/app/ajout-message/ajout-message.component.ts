import { Component, OnInit } from '@angular/core';
import { User } from '../Models/User';
import { Annonce } from '../Models/Annonce';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MessageService } from '../Services/MessagesService';
import { AnnonceService } from '../Services/AnnonceService';
import { ActivatedRoute } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { Message } from '../Models/Message';


@Component({
  selector: 'app-ajout-message',
  templateUrl: './ajout-message.component.html',
  styleUrls: ['./ajout-message.component.css']
})
export class AjoutMessageComponent implements OnInit {
  id: number;
  idMessage: number;
  idDefault = null;
  auteur= null;
  titreInit = '';
  contenuInit= '';
  annonceId = null;
  messageForm: FormGroup;
  date= new Date();
  

  constructor(private messageService: MessageService,
    private annonceService: AnnonceService,
    private location: Location,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private httpClient: HttpClientModule) { }

  ngOnInit() {
    this.id = +this.route.snapshot.params.id;
    
  }

  initForm() {
    this.messageForm = this.formBuilder.group({
      
      titre: [this.titreInit, Validators.required],
      contenu: [this.contenuInit, Validators.required]
    });
  }

  onSave() {
    const formValue = this.messageForm.value;
    if (this.id) {
      this.idDefault = this.id;
    }
    const nouveauMessage = new Message(
      this.id = 0,
      formValue['titre'],
      formValue['contenu'],
      this.date,
      this.annonceId,
      this.auteur
    );
   
      this.messageService.createMessage(nouveauMessage);
  }


}
