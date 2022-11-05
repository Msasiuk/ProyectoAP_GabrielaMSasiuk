import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditAcercaDeComponent } from './components/acerca-de/edit-acerca-de.component';
import { EditeducacionComponent } from './components/educacion/editeducacion.component';
import { NeweducacionComponent } from './components/educacion/neweducacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditHardSkillComponent } from './components/hard-skill/edit-hard-skill.component';
import { NewHardSkillComponent } from './components/hard-skill/new-hard-skill.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditProyectoComponent } from './components/proyecto/edit-proyecto.component';
import { NewProyectoComponent } from './components/proyecto/new-proyecto.component';
import { EditSoftSkillComponent } from './components/soft-skill/edit-soft-skill.component';
import { NewSoftSkillComponent } from './components/soft-skill/new-soft-kill.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'editacercade/:id', component: EditAcercaDeComponent },
  { path: 'newex', component: NewExperienciaComponent },
  { path: 'editex/:id', component: EditExperienciaComponent },
  { path: 'newed', component: NeweducacionComponent },
  { path: 'edited/:id', component: EditeducacionComponent },
  { path: 'newsfskill', component: NewSoftSkillComponent },
  { path: 'editsfskill/:id', component: EditSoftSkillComponent },
  { path: 'newhdskill', component: NewHardSkillComponent },
  { path: 'edithdskill/:id', component: EditHardSkillComponent },
  { path: 'newp', component: NewProyectoComponent },
  { path: 'editp/:id', component: EditProyectoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
