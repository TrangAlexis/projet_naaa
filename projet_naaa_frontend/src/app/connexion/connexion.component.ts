import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/AuthService';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent implements OnInit {
  login = '';
  password = '';
  authError = false;


  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {}

  onSubmit(form:any) {
    this.authService.authentication(this.login, this.password).subscribe({
      next: (result) => {
        sessionStorage.setItem('token', btoa(this.login + ':' + this.password));
        this.authError = false;
        sessionStorage.setItem('user', JSON.stringify(result));
        this.router.navigateByUrl('/home-page');
      },
      error: (err) => {
        alert("Identifiants incorrects ou compte inexistant.")
        this.authError = true;
      },
    });
  }

}
