import { Component } from '@angular/core';

@Component({
  selector: 'app-user-status',
  templateUrl: './user-status.component.html',
  styleUrls: ['./user-status.component.scss']
})
export class UserStatusComponent {
  points: number =56;
  level!:string;

  progressionProgramme(){
    switch(true){
      case (this.points < 0 || this.points > 100):
        return this.level = "Score invalide";
      break;
      case (this.points < 50):
        return this.level = "1";
      break;
      case (this.points < 80):
        return this.level = "2";
      break;
      case (this.points > 80):
        return this.level = "3";
      break;
      default:
        return this.level = "1";
      break;
    }
  }
}
