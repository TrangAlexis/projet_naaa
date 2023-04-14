import { Component, Input, OnInit} from '@angular/core';
import { Section } from 'src/app/models/section.model';

@Component({
  selector: 'app-section',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.scss']
})
export class SectionComponent implements OnInit {
  @Input() section!: Section;

  title!: string;
  next!: string;
  imgUrl!: string;
  subtitle!: string;
  description!: string;

  ngOnInit() {
    // this.title = 'La recette du jour';
    const today = new Date();
    this.next = today.toLocaleDateString('fr-FR', {weekday: 'long', day: 'numeric', month: 'long'});
    // this.imgUrl = '/assets/images/cuisine.jpg';
    // this.subtitle = 'Le gratin healthy de Sofia';
    // this.description = '10 minutes de préparation, 10 minutes de cuisson';
  }
}


