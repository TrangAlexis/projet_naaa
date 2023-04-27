import { Component, OnInit } from '@angular/core';
import { Exercice } from '../models/exercise.model';
import { ExerciceService } from '../services/ExerciceService';
import { Router } from '@angular/router';


@Component({
  selector: 'app-exercise-editor',
  templateUrl: './exercise-editor.component.html',
  styleUrls: ['./exercise-editor.component.scss']
})
export class ExerciseEditorComponent implements OnInit {
  exercice: Exercice = {
    nom: '',
    description: '',
  };

  exercices!: Exercice[];

  constructor(private exerciceService: ExerciceService, private router: Router) {}

  ngOnInit(): void {
    this.exerciceService.getAll().subscribe(
      (exercices: Exercice[]) => {
        this.exercices = exercices;
        console.log(exercices);

      },
      (error) => {
        console.log(error);
      }
    );
  }


  onSubmitExercice() {
    this.exerciceService.create(this.exercice).subscribe((result) => {
      alert("L'exercice a été ajouté à la base de donnée avec succès!");
      window.location.reload();
    }, (error) => {
      alert("Une erreur s'est produite, t'es pas coach!");
    });
  }

  deleteExercice(id:any) {
    if(confirm("Êtes vous sûr de vouloir supprimer l'exercice de la base de donnée? Cette opération est irréversible!")) {
      this.exerciceService.delete(id).subscribe(() => {
        this.exercices = this.exercices.filter(e => e.id !== id);
        alert('Exercice supprimé avec succès');
      });
    }
  }

}
