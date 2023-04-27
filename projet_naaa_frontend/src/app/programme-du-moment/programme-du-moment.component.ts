import { Component, OnInit } from '@angular/core';
import { Program } from '../models/programmes';
import { ProgrammeService } from '../services/ProgrammeService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-programme-du-moment',
  templateUrl: './programme-du-moment.component.html',
  styleUrls: ['./programme-du-moment.component.scss']
})
export class ProgrammeDuMomentComponent implements OnInit{

  programme: Program = {
    nom: "",
    nombreJours: 0,
    exercices: [],
  };

  constructor(
    private programService: ProgrammeService,
    private router: Router) {}

  ngOnInit(): void {

    
    // -------Chose the programme here-----
    this.programService.getById(2).subscribe((prog) => {
    // ------------------------------------
      this.programme=prog;
    })
  }

  startTraining(){
    this.router.navigateByUrl("/entrainement");
  }


}
