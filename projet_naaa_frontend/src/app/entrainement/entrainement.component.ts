import { Component, OnInit } from '@angular/core';
import { Program } from '../models/programmes';
import { ProgrammeService } from '../services/ProgrammeService';
import { Router } from '@angular/router';
import { Exercice } from '../models/exercise.model';
import { ClientService } from '../services/ClientService';
import { Client } from '../models/client.model';

@Component({
  selector: 'app-entrainement',
  templateUrl: './entrainement.component.html',
  styleUrls: ['./entrainement.component.scss']
})
export class EntrainementComponent implements OnInit{
  userSession : any={
    login:"",
    role:""
  }
  client!: Client

  buttonDone=true

  exercices!: any[];
  programme: Program = {
    nom: "",
    nombreJours: 0,
    exercices: [],
  };

  constructor(
    private programService: ProgrammeService,
    private clientService: ClientService,
    private router: Router) {}

  ngOnInit(): void {

    
    // -------Chose the programme here-----
    this.programService.getById(2).subscribe((prog) => {
    // ------------------------------------
      this.programme=prog;

      // console.log("PROGRAMME");
      // console.log(this.programme)
      this.exercices=this.programme.exercices
  
      // console.log("EXERCICES")
      // console.log(this.exercices)
    })

  };

  buttonIsDone(i:number){
    return i-this.n;
  }
  n=0
  exerciseDone(points:any,i:number){
    this.n+=1
    // console.log(points)
    this.userSession = JSON.parse(sessionStorage.getItem("user")!)
    // console.log(this.userSession.login)

    this.clientService.getClientByNom(this.userSession.login).subscribe((client:any)=>{
      console.log(client)
      client.pointsDeSucces+=points;
      console.log(client.pointsDeSucces)
      this.clientService.updateClient(client.nom,client).subscribe(()=>{
        // window.location.reload()


      })
    })
    
  };
}
