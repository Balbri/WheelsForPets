import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { ListeAnnoncesComponent } from './liste-annonces/liste-annonces.component';
import { PageAnnonceComponent } from './page-annonce/page-annonce.component';
import { AjoutAnnonceComponent } from './ajout-annonce/ajout-annonce.component';
import { MentionsLegalesComponent } from './mentions-legales/mentions-legales.component';
import { AdminUserlistComponent } from './admin-userlist/admin-userlist.component';


const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomepageComponent },
  {path: 'annonces', component: ListeAnnoncesComponent},
  {path: 'annonce/:id', component: PageAnnonceComponent},
  {path: 'posterannonce', component: AjoutAnnonceComponent},
  {path: 'mentionslegales', component: MentionsLegalesComponent},
  {path: 'admin/users', component: AdminUserlistComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
