import { Component, OnInit, Input } from '@angular/core';
import { Message } from '../Models/Message';
import { MessageService } from '../Services/MessagesService';
import { ActivatedRoute, Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-messages-de-lannonce',
  templateUrl: './messages-de-lannonce.component.html',
  styleUrls: ['./messages-de-lannonce.component.css'],
  
})
export class MessagesDeLannonceComponent implements OnInit {

  id : number;
  linkedMessagesList: BehaviorSubject<Message[]>;

  constructor(
    private messageService: MessageService,
    private route: ActivatedRoute,
    ) {}

  ngOnInit() {
    this.id = +this.route.snapshot.params.id;
    this.linkedMessagesList = this.messageService.linkedMessages$;
    this.messageService.publishLinkedMessages(this.id);
  }
}
