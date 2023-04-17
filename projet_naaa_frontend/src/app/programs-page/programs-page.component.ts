import { Component, OnInit } from '@angular/core';
import { Program } from '../models/programs.model';

@Component({
  selector: 'app-programs-page',
  templateUrl: './programs-page.component.html',
  styleUrls: ['./programs-page.component.scss']
})
export class ProgramsPageComponent implements OnInit {

  ngOnInit(): void {
    let sortedPrograms = this.programs.sort((a, b) => b.finishedChallengers - a.finishedChallengers);
  }
  
  getFavoritePrograms(programs: Program[]): Program[] {
    return programs.filter(program => program.isFavorite).concat(programs.filter(program => !program.isFavorite));
  }

  programs: Program[] = [
    new Program(
      'Programme de jogging',
      600,
      'La coureuse du dimanche',
      '/assets/images/jogg.jpg',
      258,
      4039,
      false
    ),
    new Program(
      'Yoga des chiens',
      700,
      'Snoop Dog',
      '/assets/images/newprog.jpg',
      124,
      2015,
      true
    ),
    new Program(
      'Musculation en Pyjama',
      600,
      'Pyjaman',
      '/assets/images/home.jpg',
      173,
      3152,
      false
    ),
    new Program(
      'Classique Push Pull Leg',
      400,
      'Le Gym Bro',
      '/assets/images/ppl.jpg',
      130,
      2128,
      false
    ),
    new Program(
      'Avec ma gosse',
      500,
      'Super parent',
      '/assets/images/avis.jpg',
      179,
      2876, 
      true
    ),
    new Program(
      'Programme de yoga',
      1000,
      'Shi Fu',
      '/assets/images/namaste.jpg',
      76,
      986,
      true
    )
];


}

