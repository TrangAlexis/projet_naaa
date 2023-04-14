import { Component } from '@angular/core';
import { Exercice } from '../models/exercise.model';
import { ExerciceService } from '../services/ExerciceService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-exercise-editor',
  templateUrl: './exercise-editor.component.html',
  styleUrls: ['./exercise-editor.component.scss']
})
export class ExerciseEditorComponent {
  exercice: Exercice = {
    nom: '',
    description: '',
  };

  constructor(private exerciceService: ExerciceService, private router: Router) {}

  onSubmit() {
    this.exerciceService.create(this.exercice).subscribe((result) => {
      this.router.navigate(['/programs-page']);
    });
  }
}
