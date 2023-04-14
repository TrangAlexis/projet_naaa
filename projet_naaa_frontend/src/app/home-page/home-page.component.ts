import { Component, OnInit } from '@angular/core';
import { Section } from '../models/section.model';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
})
export class HomePageComponent implements OnInit {
  
  food!: Section;
  challenge!: Section;
  news!: Section;

  ngOnInit(): void {
    this.food = new Section(
      'La recette du jour',
      'Lundi 29 Novembre',
      '/assets/images/cuisine.jpg',
      'Le gratin de Julia',
      '10 minutes et 60 minutes'
    ),
    this.challenge = new Section(
      'Le challenge du mois',
      'voir plus',
      '/assets/images/home3.jpg',
      'Morning Booster en 5 minutes',
      'Pour le plein d\'énergie toute la journée'
    ),
    this.news = new Section(
      'Nouveautés',
      'voir plus',
      '/assets/images/newprog2.jpg',
      'Les nouveaux programmes du moments',
      'Le printemps arrive, on s\'active!'
    );
  }
}
