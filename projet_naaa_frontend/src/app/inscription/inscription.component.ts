import { ClientService } from './../services/ClientService';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { MustMatch } from '../helpers/must-match.validators';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent implements OnInit {

  nom!: string;
  prenom!: string;
  email!: string;
  login!: string;
  mdp!: string;
  role!: string;



  inscriptionForm!: FormGroup;
  submitted = false;
required: any;

  constructor(private formBuilder: FormBuilder, private clientService: ClientService) { }

  ngOnInit() {
    this.inscriptionForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required]
    }, {
      validator: MustMatch('password', 'confirmPassword')
    });
  }

  get f() { return this.inscriptionForm.controls; }

  // onSubmit() {
  //   this.submitted = true;

  //   if (this.inscriptionForm.invalid) {
  //     return;
  //   }

  //   alert('Inscription réussie !\n\n' + JSON.stringify(this.inscriptionForm.value, null, 4));
  // }

  onSubmit(): void {
    const client = {
      nom: this.nom,
      prenom: this.prenom,
      email: this.email,
      login: this.login,
      mdp: this.mdp,
      compte: {
        role: this.role
      }
    };
  }

}
