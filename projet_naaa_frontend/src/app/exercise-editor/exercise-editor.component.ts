import { Component } from '@angular/core';
import { Exercice } from '../models/exercise.model';
import { ExerciceService } from '../services/ExerciceService';

@Component({
  selector: 'app-exercise-editor',
  templateUrl: './exercise-editor.component.html',
  styleUrls: ['./exercise-editor.component.scss']
})
export class ExerciseEditorComponent {

  
  exercice: Exercice = new Exercice("Je suis là", "Hello");
  
  constructor(private exerciceService: ExerciceService) { }
  

  onSubmit() {
    this.exerciceService.create(this.exercice)
      .subscribe(
        data => console.log('Exercice ajouté avec succès !'),
        error => console.log('Une erreur est survenue lors de l\'ajout de l\'exercice.')
      );
  }
}
