import { Observable, map } from 'rxjs';
import { AuthService } from 'src/app/services/AuthService';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AsyncValidatorFn, AbstractControl, ValidationErrors } from '@angular/forms';
import { Router } from '@angular/router';
import { Coach } from '../models/coach.model';
import { CoachService } from '../services/CoachService';
import { MustMatch } from '../helpers/must-match.validators';

@Component({
  selector: 'app-inscription-coach',
  templateUrl: './inscription-coach.component.html',
  styleUrls: ['./inscription-coach.component.scss']
})
export class InscriptionCoachComponent implements OnInit {
  inscriptionForm!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private coachService: CoachService, private router: Router) { }

  ngOnInit() {
    this.inscriptionForm = this.formBuilder.group({
      nom: ['', Validators.required],
      login: ['', Validators.required,this.loginFree(this.coachService)],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    },{
      validator: MustMatch('password', 'confirmPassword')
    });
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

    const coach: Coach = {
      nom: this.f['nom'].value,
      compte: {
        login: this.f['login'].value,
        password: this.f['password'].value,
        role: 2 // coach
      }
    };

    this.coachService.createCoach(coach).subscribe((result) => {
      this.router.navigate(['/connexion']);
    })

  }

  loginFree(srv: CoachService): AsyncValidatorFn{
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      console.debug('check');
      return this.coachService.checkLogin(control.value).pipe(
        map((exist:boolean)=> {
          return exist ? {loginExist: true} : null;
        })
      );
    };
  }
}
