import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile-editor',
  templateUrl: './user-profile-editor.component.html',
  styleUrls: ['./user-profile-editor.component.scss']
})
export class UserProfileEditorComponent {
  constructor(private router: Router) {}
  unsubscribeConfirmation() {
    if (confirm("Êtes-vous sûr de vouloir vous désabonner? Vous perdrez tout les avantages d'un memebre premium...")) {
      // ici code pour update role user
      this.router.navigateByUrl('/user-profile-page');
    } else {
      // code ici si l'utilisateur annule la suppression ici
      this.router.navigateByUrl('/user-profile-page'); // ça marche pas
    }
  }
  deleteAccount() {
    if (confirm("Êtes-vous sûr de vouloir supprimer votre compte?")) {
      // code pour deleteById l'user
      this.router.navigateByUrl('');
    } else {
      // code si l'utilisateur annule la suppression ici
      this.router.navigateByUrl('/user-profile-page'); // ça marche pas
    }
  }
}
