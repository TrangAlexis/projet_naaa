import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {

  constructor(private router: Router) { }

  onSubmit() {
    // Vérifiez les informations de connexion de l'utilisateur
    // Si les informations sont valides, utilisez le service d'authentification pour connecter l'utilisateur
    // Redirigez l'utilisateur vers la page d'accueil
    this.router.navigate(['/home-page']);
  }

}
