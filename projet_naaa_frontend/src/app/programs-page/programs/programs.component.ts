import { Component, Input, OnInit } from '@angular/core';
import { Program } from 'src/app/models/programs.model'; 

@Component({
selector: 'app-programs',
templateUrl: './programs.component.html',
styleUrls: ['./programs.component.scss']
})
export class ProgramsComponent implements OnInit {
  @Input() programs!: Program;

  title!: string;
  next!: string;
  imgUrl!: string;
  subtitle!: string;
  description!: string;

constructor() { }

ngOnInit(): void {
}

}