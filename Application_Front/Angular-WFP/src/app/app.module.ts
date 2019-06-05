import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Router } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './Angular-Material';

import {HttpClientModule} from '@angular/common/http';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ListeAnnoncesComponent } from './liste-annonces/liste-annonces.component';
import { PageAnnonceComponent } from './page-annonce/page-annonce.component';
import { MessagesDeLannonceComponent } from './messages-de-lannonce/messages-de-lannonce.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AjoutAnnonceComponent } from './ajout-annonce/ajout-annonce.component';
import { MentionsLegalesComponent } from './mentions-legales/mentions-legales.component';
import { MatDatepickerModule, MatNativeDateModule } from '@angular/material';
import { AdminUserlistComponent } from './admin-userlist/admin-userlist.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    HeaderComponent,
    FooterComponent,
    ListeAnnoncesComponent,
    PageAnnonceComponent,
    MessagesDeLannonceComponent,
    AjoutAnnonceComponent,
    MentionsLegalesComponent,
    AdminUserlistComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    RouterModule,   
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatDatepickerModule, 
    MatNativeDateModule,
  ],

  exports: [
    MatDatepickerModule, 
    MatNativeDateModule,
  ],


  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
