import { Component } from '@angular/core';
import { Programme } from '../models/programmes.model';

@Component({
  selector: 'app-programme-editor',
  templateUrl: './programme-editor.component.html',
  styleUrls: ['./programme-editor.component.scss']
})
export class ProgrammeEditorComponent {
  programme: Programme = {
    title: "",
    points:-1,
    rewardTitle:"",
    imageSrc:"",
    participants:0,
    finishedChallengers:0,
    isFavorite: false
  };

  onSubmitProgramme() {
    
  }

}
