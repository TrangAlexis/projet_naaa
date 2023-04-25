import { Component, OnInit } from '@angular/core';
import { Program } from '../models/programmes';
import { Exercice } from '../models/exercise.model';
import { ExerciceService } from '../services/ExerciceService';
import { Router } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { ProgrammeService } from '../services/ProgrammeService';
import { Programme } from '../models/programmes.model';

@Component({
  selector: 'app-programme-editor',
  templateUrl: './programme-editor.component.html',
  styleUrls: ['./programme-editor.component.scss']
})
export class ProgrammeEditorComponent implements OnInit{
  form!: FormGroup;
  programme: Program = {
    nom: "",
    nombreJours: 0,
    exercices: [],
  };
  programExercices!: Exercice[];
  allExercices!: Exercice[];
  allProgrammes!: Program[];

  constructor(private exerciceService: ExerciceService,
              private programService: ProgrammeService,
              private router: Router) {}

  ngOnInit(): void {
    console.log("hello")
    this.exerciceService.getAll().subscribe(
      (exercices: Exercice[]) => {
        this.allExercices = exercices;
      },
      (error) => {
        console.log(error);
      }
    );
    this.programService.getAll().subscribe(
      (programmes: Program[]) =>{
        this.allProgrammes = programmes;
      },
      (error) => {
        console.log(error);
      }
    );
    console.log(this.allProgrammes)
  }
  addExercice(){
  }

  onSubmitProgramme() {
    
  }



}
