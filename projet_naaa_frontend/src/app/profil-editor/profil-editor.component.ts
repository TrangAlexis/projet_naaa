import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/AuthService';
import { Router } from '@angular/router';
import { ClientService } from '../services/ClientService';

@Component({
  selector: 'app-profil-editor',
  templateUrl: './profil-editor.component.html',
  styleUrls: ['./profil-editor.component.scss']
})
export class ProfilEditorComponent implements OnInit {
  user: any = undefined;

  constructor(private authService: AuthService, private router: Router,
    private clientService: ClientService) {}

  ngOnInit(): void {
    if (this.authService.authenticated) {
      this.user = JSON.parse(sessionStorage.getItem('user')!).login;
    }
  }

  unsubscribeConfirmation() {
    if(confirm("Êtes-vous sûre de vouloir annuler votre abonnement?")) {
    this.clientService.getClientByNom(this.user).subscribe(
      (client: any) => {
        client.compte.role = 0;
        this.clientService.updateClient(client.nom, client).subscribe(
          (data) => {
            alert(
              "Votre abonnement est bien annulé. Reconnectez vous pour profiter de l'application en tant qu'utilisateur Freemium."
            );
            this.authService.logout();
            this.router.navigate(['/connexion']);
          },
          (error) => {
            console.error(error);
            alert(
              'Une erreur est survenue lors de la mise à jour de votre compte. Veuillez réessayer plus tard.'
            );
          }
        );
      },
      (error) => {
        console.error(error);
        alert(
          'Une erreur est survenue lors de la récupération de votre compte. Veuillez réessayer plus tard.'
        );
      }
    );}
  }



  deleteAccount() {
    if (confirm("Êtes-vous sûr de vouloir supprimer votre compte?")) {
      this.clientService.getClientByNom(this.user).subscribe((client: any) => {
        this.clientService.deleteClient(client.nom).subscribe((data) => {
          alert("Votre compte a été supprimé.");
          this.authService.logout();
          this.router.navigate(['/inscription']);
        });
      });
    } else {
      // code si l'utilisateur annule la suppression ici
      this.router.navigate(['/user-profile-page']);
    }
  }

}
