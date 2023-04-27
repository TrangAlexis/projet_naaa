import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';

import { HomePageComponent } from './home-page/home-page.component';
import { ProgramsPageComponent } from './programs-page/programs-page.component';
import { LeaderboardsPageComponent } from './leaderboards-page/leaderboards-page.component';
import { UserProfilPageComponent } from './user-profil-page/user-profil-page.component';
import { ExerciseEditorComponent } from './exercise-editor/exercise-editor.component';
import { InscriptionCoachComponent } from './inscription-coach/inscription-coach.component';
import { AuthGuardService } from './services/AuthGuardService';
import { ProgrammeEditorComponent } from './programme-editor/programme-editor.component';
import { SubscribeComponent } from './subscribe/subscribe.component';
import { PaymentComponent } from './payment/payment.component';
import { ProfilEditorComponent } from './profil-editor/profil-editor.component';
import { AuthGuardServiceTwo } from './services/AuthGuardServiceTwo';
import { EntrainementComponent } from './entrainement/entrainement.component';

const routes: Routes = [
  { path: '', component: LandingPageComponent, canActivate: [AuthGuardServiceTwo]},
  { path: 'inscription', component: InscriptionComponent, canActivate: [AuthGuardServiceTwo]},
  { path: 'connexion', component: ConnexionComponent, canActivate: [AuthGuardServiceTwo]},
  { path: 'home-page', component: HomePageComponent, canActivate: [AuthGuardService]  },
  { path: 'programs-page', component: ProgramsPageComponent, canActivate: [AuthGuardService]   },
  { path: 'leaderboards-page', component: LeaderboardsPageComponent, canActivate: [AuthGuardService]   },
  { path: 'user-profil-page', component: UserProfilPageComponent, canActivate: [AuthGuardService]   },
  { path: 'app-exercise-editor', component: ExerciseEditorComponent, canActivate: [AuthGuardService]  },
  { path: 'app-programme-editor', component: ProgrammeEditorComponent, canActivate: [AuthGuardService]  },
  { path: 'inscription-coach', component: InscriptionCoachComponent},
  { path: 'inscription-coach', component: InscriptionCoachComponent},
  { path: 'subscribe', component: SubscribeComponent, canActivate: [AuthGuardService] },
  { path: 'payment', component: PaymentComponent, canActivate: [AuthGuardService] },
  { path: 'profil-editor', component: ProfilEditorComponent, canActivate: [AuthGuardService] },
  { path: 'entrainement', component: EntrainementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
