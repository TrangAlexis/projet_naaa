import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/AuthService';
import { Router } from '@angular/router';
import { CoachService } from '../services/CoachService';
import { ClientService } from '../services/ClientService';

@Component({
  selector: 'app-user-profil-page',
  templateUrl: './user-profil-page.component.html',
  styleUrls: ['./user-profil-page.component.scss']
})
export class UserProfilPageComponent implements OnInit {
  user: any = undefined;
  login: any = undefined;
  client: any = undefined;

  points: number =93;
  level!:string;

  constructor(private authService: AuthService, private router: Router,
    private coachService: CoachService,
    private clientService: ClientService ) {}

    ngOnInit(): void {
      if (this.authService.authenticated) {
        this.user = JSON.parse(sessionStorage.getItem('user')!);
        this.login = this.user.login;
        if (this.user.role === 'ROLE_COACH') {
          this.coachService.getCoachByNom(this.login).subscribe((coach: any) => {
            this.client = coach;
          });
        } else {
          this.clientService
            .getClientByNom(this.login)
            .subscribe((client: any) => {
              this.client = client;
            });
        }
      }
    }

  public onLogout() {
    this.authService.logout();
    this.router.navigate(['/connexion']);
  }


  passerDesLevels(){
    switch(true){
      case (this.points < 0 || this.points > 100):
        return this.level = "Score invalide";
      break;
      case (this.points < 50):
        return this.level = "Niveau 1 - Petit muscle";
      break;
      case (this.points < 80):
        return this.level = "Niveau 2 - mieux";
      break;
      case (this.points > 80):
        return this.level = "Niveau 3 - champioooon";
      break;
      default:
        return this.level = "Niveau 1";
      break;
    }
  }
}
