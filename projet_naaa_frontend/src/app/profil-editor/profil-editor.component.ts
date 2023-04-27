import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/AuthService';
import { Router } from '@angular/router';
import { ClientService } from '../services/ClientService';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MustMatch } from '../helpers/must-match.validators';
import { Client } from '../models/client.model';
import { CoachService } from '../services/CoachService';

@Component({
  selector: 'app-profil-editor',
  templateUrl: './profil-editor.component.html',
  styleUrls: ['./profil-editor.component.scss'],
})
export class ProfilEditorComponent implements OnInit {
  user: any = undefined;
  role: any = undefined;
  login: any = undefined;
  client: any = undefined;

  selectedImage: any= { src: '/assets/images/quadrillage.jpg', alt: 'Image 1' };

  mdpForm!: FormGroup;
  submitted = false;

  avatarForm!: FormGroup;
  submittedAvatar=false;

  // avatar1 = 'assets/images/user2.jpg';
  // avatar2 = 'assets/images/user3.jpg';
  // avatar3 = 'assets/images/user4.jpg';

  // avatars = [this.avatar1, this.avatar2, this.avatar3];
  // selectedAvatar!: string;

  constructor(
    private authService: AuthService,
    private router: Router,
    private clientService: ClientService,
    private formBuilder: FormBuilder,
    private coachService: CoachService
  ) {}

  ngOnInit(): void {
    console.log(sessionStorage)
    if (this.authService.authenticated) {
      this.user = JSON.parse(sessionStorage.getItem('user')!);
      this.login = this.user.login;
      this.role = this.user.role;
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

    this.mdpForm = this.formBuilder.group(
      {
        newPassword: ['', Validators.required],
        confirmPassword: ['', Validators.required],
      },
      {
        validator: MustMatch('newPassword', 'confirmPassword'),
      }
    );
    this.avatarForm = this.formBuilder.group(
      {
        newAvatar: ['', Validators.required]
      }
    );


  }

  get f() {
    return this.mdpForm.controls;
  }

  get av() {
    return this.avatarForm.controls;
  }

  onMdpChange() {
    this.submitted = true;

    if (this.mdpForm.invalid) {
      return;
    }

    const newPassword = this.f['newPassword'].value;

    if (this.role === 'ROLE_COACH') {
      this.coachService.getCoachByNom(this.login).subscribe((coach: any) => {
        coach.compte.password = newPassword;
        this.coachService.updateCoach(coach.nom, coach).subscribe((result) => {
          alert('Mot de passe changé avec succès! Veuillez vous reconnecter.');
          this.authService.logout();
          this.router.navigate(['/connexion']);
        });
      });
    } else {
      this.clientService
        .getClientByNom(this.login)
        .subscribe((client: Client) => {
          client.compte.password = newPassword;
          this.clientService
            .updateClient(client.nom, client)
            .subscribe((result) => {
              alert('Mot de passe changé avec succès! Veuillez vous reconnecter.');
              this.authService.logout();
              this.router.navigate(['/connexion']);
            });
        });
    }
  }

  unsubscribeConfirmation() {
    if (confirm('Êtes-vous sûre de vouloir annuler votre abonnement?')) {
      this.clientService.getClientByNom(this.login).subscribe(
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
      );
    }
  }

  deleteAccount() {
    if (confirm('Êtes-vous sûr de vouloir supprimer votre compte?')) {
      if (this.user.role === 'ROLE_COACH') {
        this.coachService.getCoachByNom(this.login).subscribe((coach: any) => {
          this.coachService.deleteCoach(coach.nom).subscribe((data) => {
            alert('Votre compte a été supprimé.');
            this.authService.logout();
            this.router.navigate(['/inscription']);
          });
        });
      } else {
        this.clientService
          .getClientByNom(this.login)
          .subscribe((client: any) => {
            this.clientService.deleteClient(client.nom).subscribe((data) => {
              alert('Votre compte a été supprimé.');
              this.authService.logout();
              this.router.navigate(['/inscription']);
            });
          });
      }
    } else {
      this.router.navigate(['']);
    }
  }


  images = [
    { src: 'assets/images/user2.jpg', alt: 'Image 1' },
    { src: 'assets/images/user3.jpg', alt: 'Image 2' },
    { src: 'assets/images/user4.jpg', alt: 'Image 3' }
  ];


  selectImage(image: any) {
    this.selectedImage = image;
    this.avatarForm.controls['newAvatar'].setValue(this.selectedImage.src);
  
  }



  onAvatarChange() {
    this.submittedAvatar = true;

    if (this.avatarForm.invalid) {
      return;
    }

    const newAvatar = this.av['newAvatar'].value;

    if (this.role === 'ROLE_COACH') {
      this.coachService.getCoachByNom(this.login).subscribe((coach: any) => {
        coach.avatar = newAvatar;
        this.coachService.updateCoach(coach.nom, coach).subscribe((result) => {
          alert('Avatar changé avec succès! Veuillez vous reconnecter.');
          this.authService.logout();
          this.router.navigate(['/connexion']);
        });
      });
    } else {
      this.clientService
        .getClientByNom(this.login)
        .subscribe((client: Client) => {
          client.avatar = newAvatar;
          this.clientService
            .updateClient(client.nom, client)
            .subscribe((result) => {
              alert('Avatar changé avec succès! Veuillez vous reconnecter.');
              this.authService.logout();
              this.router.navigate(['/connexion']);
            });
        });
    }
  }

}
