import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { RedesYLoginComponent } from './components/redes-y-login/redes-y-login.component';
import { BannerComponent } from './components/banner/banner.component';
import { AcercaDeComponent } from './components/acerca-de/acerca-de.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { FormsModule } from '@angular/forms';
import { SoftSkillComponent } from './components/soft-skill/soft-skill.component';
import { ProyectoComponent } from './components/proyecto/proyecto.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { interceptorProvider } from './service/interceptor-service';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NeweducacionComponent } from './components/educacion/neweducacion.component';
import { EditeducacionComponent } from './components/educacion/editeducacion.component';
import { EditSoftSkillComponent } from './components/soft-skill/edit-soft-skill.component';
import { NewSoftSkillComponent } from './components/soft-skill/new-soft-kill.component';
import { EditAcercaDeComponent } from './components/acerca-de/edit-acerca-de.component';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { environment } from '../environments/environment';
import { provideStorage, getStorage } from '@angular/fire/storage';
import { EditProyectoComponent } from './components/proyecto/edit-proyecto.component';
import { NewProyectoComponent } from './components/proyecto/new-proyecto.component';
import { HardSkillComponent } from './components/hard-skill/hard-skill.component';
import { NewHardSkillComponent } from './components/hard-skill/new-hard-skill.component';
import { EditHardSkillComponent } from './components/hard-skill/edit-hard-skill.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    RedesYLoginComponent,
    BannerComponent,
    AcercaDeComponent,
    ExperienciaComponent,
    EducacionComponent,
    SoftSkillComponent,
    ProyectoComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    NewExperienciaComponent,
    EditExperienciaComponent,
    NeweducacionComponent,
    EditeducacionComponent,
    EditSoftSkillComponent,
    NewSoftSkillComponent,
    EditAcercaDeComponent,
    EditProyectoComponent,
    NewProyectoComponent,
    HardSkillComponent,
    NewHardSkillComponent,
    EditHardSkillComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgCircleProgressModule.forRoot({
      maxPercent: 100,
      radius: 100,
      outerStrokeWidth: 15,
      outerStrokeColor: '#FF7F50',
      innerStrokeColor: '#E6A577',
      innerStrokeWidth: 10,
      showSubtitle: false,
      showUnits: false,
      showBackground: false,
      startFromZero: false,
      titleColor: '#FFFFFF',
    }),
    HttpClientModule,
    provideFirebaseApp(() => initializeApp(environment.firebase)),
    provideStorage(() => getStorage()),
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent],
})
export class AppModule {}
