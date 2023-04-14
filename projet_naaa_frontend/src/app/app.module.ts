import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoaderComponent } from './loader/loader.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NavbarComponent } from './navbar/navbar.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProgramsPageComponent } from './programs-page/programs-page.component';
import { LeaderboardsPageComponent } from './leaderboards-page/leaderboards-page.component';
import { UserProfilPageComponent } from './user-profil-page/user-profil-page.component';
import { SectionComponent } from './home-page/section/section.component';
import { HelloUserComponent } from './home-page/hello-user/hello-user.component';
import { UserStatusComponent } from './home-page/user-status/user-status.component';
import { ProgramsComponent } from './programs-page/programs/programs.component';
import { SearchBarComponent } from './programs-page/search-bar/search-bar.component';
import { ExerciseEditorComponent } from './exercise-editor/exercise-editor.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    LoaderComponent,
    LandingPageComponent,
    ConnexionComponent,
    InscriptionComponent,
    NavbarComponent,
    HomePageComponent,
    ProgramsPageComponent,
    LeaderboardsPageComponent,
    UserProfilPageComponent,
    SectionComponent,
    HelloUserComponent,
    UserStatusComponent,
    ProgramsComponent,
    SearchBarComponent,
    ExerciseEditorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    CommonModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
