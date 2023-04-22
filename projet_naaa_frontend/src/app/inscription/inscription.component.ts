import { ClientService } from './../services/ClientService';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { MustMatch } from '../helpers/must-match.validators';
import { Client } from '../models/client.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent implements OnInit {
  inscriptionForm!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private clientService: ClientService, private router: Router) { }

  ngOnInit() {
    this.inscriptionForm = this.formBuilder.group({
      nom: ['', Validators.required],
      login: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    },{
      validator: MustMatch('password', 'confirmPassword')
    }
    );
    this.inscriptionForm.controls['login'].valueChanges.subscribe(value => {
      this.inscriptionForm.controls['nom'].setValue(value);
    });
  }

  get f() { return this.inscriptionForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.inscriptionForm.invalid) {
      return;
    }

    const client: Client = {
      nom: this.f['nom'].value,
      compte: {
        login: this.f['login'].value,
        password: this.f['password'].value,
        role: 0 // CLIENT_FREEMIUM
      }
    };

    this.clientService.createClient(client).subscribe((result) => {
      this.router.navigate(['/connexion']);
    })

  }
}
