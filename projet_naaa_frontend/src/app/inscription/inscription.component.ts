import { map, Observable } from 'rxjs';
import { AuthService } from 'src/app/services/AuthService';
import { ClientService } from './../services/ClientService';
<<<<<<< HEAD
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, AsyncValidatorFn, AbstractControl, ValidationErrors } from '@angular/forms';
=======
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
>>>>>>> main
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

  constructor(private formBuilder: FormBuilder, private clientService: ClientService, private clientSrv: AuthService, private router: Router) { }

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

  loginFree(srv: AuthService): AsyncValidatorFn{
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      console.debug('check');
      return this.clientSrv.checkLogin(control.value).pipe(
        map((exist:boolean)=> {
          return exist ? {loginExist: true} : null;
        })
      );
    };
  }

}
