import { Component, OnInit } from '@angular/core';
import { Program } from '../models/programmes';
import { Exercice } from '../models/exercise.model';
import { ExerciceService } from '../services/ExerciceService';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';
import { ProgrammeService } from '../services/ProgrammeService';

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


  programExercices!: any[];
  programExercicesForDisplay!: Exercice[];
  allExercices!: Exercice[];
  allProgrammes!: Program[];

  constructor(private exerciceService: ExerciceService,
              private programService: ProgrammeService,
              private router: Router) {}

  ngOnInit(): void {
    this.programExercices=[]
    this.programExercicesForDisplay=[]
    
    //init Form
    this.form = new FormGroup({
      nomProgramme: new FormControl(),
      nombreJours: new FormControl(),
      selectorExercice: new FormControl(),
      nombreRepetition: new FormControl(),
    });


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
  }

  deleteProgramme(id:any){
    this.programService.deleteProgram(id).subscribe(() =>{
      this.allProgrammes = this.allProgrammes.filter(p => p.id !==id);
    })
  }



  submitProgramme() {
    console.log("submitProgramme click")
    let programmeJson = {
      nom: this.form.get('nomProgramme')?.value,
      nombreJours: this.form.get('nombreJours')?.value,
      exercices: this.programExercices
    };
    this.programService.create(programmeJson).subscribe((programme) => {
      console.debug(programme);
      window.location.reload();
    });
  }

  addExercice(){
    console.log("addExercice click")

    this.exerciceService.getById((this.form.get("selectorExercice")?.value).id).subscribe((exo) => {
      // console.log(exo)
      this.programExercices.push({id:{exercice:exo},repetition:this.form.get("nombreRepetition")?.value});
      this.programExercicesForDisplay.push(exo);
    });

    console.log(this.programExercices)
  }


}
