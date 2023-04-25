import { Component, OnInit } from '@angular/core';
import { Programme } from '../models/programmes.model';
import { AuthService } from '../services/AuthService';

@Component({
  selector: 'app-programs-page',
  templateUrl: './programs-page.component.html',
  styleUrls: ['./programs-page.component.scss']
})
export class ProgramsPageComponent implements OnInit {
  isCoach!:boolean;
  constructor(private authService: AuthService) {

  }

  ngOnInit(): void {
    this.isCoach = this.authService.isCoach();
    let sortedPrograms = this.programs.sort((a, b) => b.finishedChallengers - a.finishedChallengers);
  }

  getFavoritePrograms(programs: Programme[]): Programme[] {
    return programs.filter(program => program.isFavorite).concat(programs.filter(program => !program.isFavorite));
  }

  programs: Programme[] = [
    new Programme(
      'Programme de jogging',
      600,
      'La coureuse du dimanche',
      '/assets/images/jogg.jpg',
      258,
      4039,
      false
    ),
    new Programme(
      'Yoga des chiens',
      700,
      'Snoop Dog',
      '/assets/images/newprog.jpg',
      124,
      2015,
      true
    ),
    new Programme(
      'Musculation en Pyjama',
      600,
      'Pyjaman',
      '/assets/images/home.jpg',
      173,
      3152,
      false
    ),
    new Programme(
      'Classique Push Pull Leg',
      400,
      'Le Gym Bro',
      '/assets/images/ppl.jpg',
      130,
      2128,
      false
    ),
    new Programme(
      'Avec ma gosse',
      500,
      'Super parent',
      '/assets/images/avis.jpg',
      179,
      2876,
      true
    ),
    new Programme(
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

