import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListerUtilisateursComponent } from './components/lister-utilisateurs/lister-utilisateurs.component';
import { ListLaboratoriesComponent } from './components/list-laboratories/list-laboratories.component';
import { AddLaboratoryComponent } from './components/add-laboratory/add-laboratory.component';
import { DeleteLaboratoryComponent } from './components/delete-laboratory/delete-laboratory.component';
import { EditLaboratoryComponent } from './components/edit-laboratory/edit-laboratory.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import {AdresseListComponent} from './components/adresse-service/adresse-list/adresse-list.component';
import {AdresseAddComponent} from './components/adresse-service/adresse-add/adresse-add.component';
import {AdresseUpdateComponent} from './components/adresse-service/adresse-update/adresse-update.component';
import {AdresseDeleteComponent} from './components/adresse-service/adresse-delete/adresse-delete.component';
import {ContactListComponent} from './components/contact-service/contact-list/contact-list.component';
import {ContactAddComponent} from './components/contact-service/contact-add/contact-add.component';
import {ContactUpdateComponent} from './components/contact-service/contact-update/contact-update.component';
import {ContactDeleteComponent} from './components/contact-service/contact-delete/contact-delete.component';


const routes: Routes = [
  { path: '', component: HomeComponent }, 
  { path: 'login', component: LoginComponent },
  { path: 'utilisateurs', component: ListerUtilisateursComponent },
  { path: 'adminPannel' , component: SidebarComponent},
  { path: 'list-laboratory', component: ListLaboratoriesComponent },
  { path: 'edit-laboratory/:id', component: EditLaboratoryComponent },
  { path: 'add-laboratory', component: AddLaboratoryComponent },
  { path: 'delete-laboratory/:id', component: DeleteLaboratoryComponent },
  { path: 'adresse-list', component: AdresseListComponent },
  { path: 'adresse-add', component: AdresseAddComponent},
  { path: 'adresse-update/:id', component: AdresseUpdateComponent},
  { path: 'adresse-delete/:id', component: AdresseDeleteComponent},
  { path: 'contact-list', component: ContactListComponent },
  { path: 'contact-add', component: ContactAddComponent},
  { path: 'contact-update/:id', component: ContactUpdateComponent},
  { path: 'contact-delete/:id', component: ContactDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }