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
}
