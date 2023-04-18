import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/AuthService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profil-page',
  templateUrl: './user-profil-page.component.html',
  styleUrls: ['./user-profil-page.component.scss']
})
export class UserProfilPageComponent implements OnInit {
  user: any = undefined;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    if (this.authService.authenticated) {
      this.user = JSON.parse(sessionStorage.getItem('user')!);
    }
  }

  public onLogout() {
    this.authService.logout();
    this.router.navigate(['/connexion']);
  }
}
