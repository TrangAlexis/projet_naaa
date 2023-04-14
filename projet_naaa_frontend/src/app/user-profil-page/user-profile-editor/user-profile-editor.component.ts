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
    if (confirm("Êtes-vous sûr de vouloir supprimer votre compte?")) {
      // Code pour se delete l'utilisateur ici
      this.router.navigateByUrl('');
    } else {
      // Code si l'utilisateur annule la suppression ici
      this.router.navigateByUrl('/user-profile-page'); // ça marche pas 
    }
  }
}
