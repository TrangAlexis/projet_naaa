import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/AuthService';
import { ClientService } from '../services/ClientService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss'],
})
export class PaymentComponent implements OnInit {
  user: any = undefined;

  constructor(
    private authService: AuthService,
    private router: Router,
    private clientService: ClientService
  ) {}

  ngOnInit(): void {
    if (this.authService.authenticated) {
      this.user = JSON.parse(sessionStorage.getItem('user')!).login;
      console.log(this.user);

    }
  }

  onClick() {
    alert(
      "Lucky you! Les modes de payements sont momentanement indisponibles, cliquez sur le bouton 'Confirmer' pour passer membre Premium à vie!"
    );
  }

  onSubscribe() {
    this.clientService.getClientByNom(this.user).subscribe(
      (client: any) => {
        client.compte.role = 1;
        this.clientService.updateClient(client.nom, client).subscribe(
          (data) => {
            alert(
              'Félicitations! Vous êtes maintenant membre Premium! Reconnectez vous pour profiter de vos privilèges!'
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
    );
  }
}
