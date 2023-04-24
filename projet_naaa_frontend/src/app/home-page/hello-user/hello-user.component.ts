import { NgSwitchCase } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/AuthService';
import { ClientService } from 'src/app/services/ClientService';
import { CoachService } from 'src/app/services/CoachService';

@Component({
  selector: 'app-hello-user',
  templateUrl: './hello-user.component.html',
  styleUrls: ['./hello-user.component.scss'],
})
export class HelloUserComponent implements OnInit {
  user: any = undefined;
  login: any = undefined;
  client: any = undefined;

  points: number =93;
  level!:string;


  constructor(
    private authService: AuthService,
    private clientService: ClientService,
    private coachService: CoachService
  ) {}

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
