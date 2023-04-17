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
      },
      (error) => {
        console.log(error);
      }
    );
  }

  onSubmit() {
    this.exerciceService.create(this.exercice).subscribe((result) => {
      this.router.navigate(['/programs-page']);
      alert("L'exercice a été ajouté à la base de donnée avec succès!")
    });
  }

  deleteExercice(id:any) {
    if(confirm("Êtes vous sûr de vouloir supprimer l'exercice de la base de donnée? Cette opération est irréversible!")) {
      this.exerciceService.delete(id).subscribe(() => {
        // Supprission de l'exercice de la liste
        this.exercices = this.exercices.filter(e => e.id !== id);
        // message de succès consol test
        console.log('Exercice supprimé avec succès');
      });
    }
  }

}
