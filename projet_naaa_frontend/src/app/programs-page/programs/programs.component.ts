import { Component, Input, OnInit } from '@angular/core';
import { Programme } from 'src/app/models/programmes.model'; 

@Component({
selector: 'app-programs',
templateUrl: './programs.component.html',
styleUrls: ['./programs.component.scss']
})
export class ProgramsComponent implements OnInit {
  @Input() programs!: Programme;

  title!: string;
  next!: string;
  imgUrl!: string;
  subtitle!: string;
  description!: string;

constructor() { }

ngOnInit(): void {
}

}