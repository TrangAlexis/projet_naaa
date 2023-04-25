import { Component, OnInit } from '@angular/core';
import { Programme } from '../models/programmes.model';
import { Exercice } from '../models/exercise.model';
import { ExerciceService } from '../services/ExerciceService';
import { Router } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { ProgrammeService } from '../services/ProgrammeService';

@Component({
  selector: 'app-programme-editor',
  templateUrl: './programme-editor.component.html',
  styleUrls: ['./programme-editor.component.scss']
})
export class ProgrammeEditorComponent implements OnInit{
  form!: FormGroup;
  programme: Programme = {
    title: "",
    points:-1,
    rewardTitle:"",
    imageSrc:"",
    participants:0,
    finishedChallengers:0,
    isFavorite: false
  };
  programExercices!: Exercice[];
  allExercices!: Exercice[];

  constructor(private exerciceService: ExerciceService,
              private programService: ProgrammeService,
              private router: Router) {}

  ngOnInit(): void {
    this.exerciceService.getAll().subscribe(
      (exercices: Exercice[]) => {
        this.allExercices = exercices;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  addExercice(){
    let exerciceJson = {
      nom: this.form.get('selectorExercice.nom')?.value,
      description:this.form.get('selectorExercice.description')?.value,
    };
    this.programService.create(this.programme)
  }

  onSubmitProgramme() {
    
  }



}
