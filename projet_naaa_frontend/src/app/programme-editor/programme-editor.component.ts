import { Component } from '@angular/core';
import { Programme } from '../models/programmes.model';
import { Exercice } from '../models/exercise.model';
import { ExerciceService } from '../services/ExerciceService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-programme-editor',
  templateUrl: './programme-editor.component.html',
  styleUrls: ['./programme-editor.component.scss']
})
export class ProgrammeEditorComponent {
  programme: Programme = {
    title: "",
    points:-1,
    rewardTitle:"",
    imageSrc:"",
    participants:0,
    finishedChallengers:0,
    isFavorite: false
  };

  exercices!: Exercice[];

  // addExercice(){
  //   this.exercices.push(new Exercice())
  // }

  onSubmitProgramme() {
    
  }



}
