import { ClientService } from 'src/app/services/ClientService';
import { AuthService } from 'src/app/services/AuthService';
import { Router } from '@angular/router';
import { AmiService } from './../services/AmiService';
import { Amis } from './../models/ami.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-leaderboards-page',
  templateUrl: './leaderboards-page.component.html',
  styleUrls: ['./leaderboards-page.component.scss']
})
export class LeaderboardsPageComponent implements OnInit{
  ami: Amis={
    id1 : '',
    id2:'',
  };
  user: any = undefined;
  login: any = undefined;

  amiDisplay: Amis={
    id1: '',
    id2: '',
  };

  amis!: Amis[];

  client: any = undefined;
  clientAmi: any = undefined;

  constructor(private amiService: AmiService,private authService: AuthService, private clientService : ClientService, private router: Router){}

  ngOnInit(): void {
    if(this.authService.authenticated){
      this.user=JSON.parse(sessionStorage.getItem('user')!);
      this.login=this.user.login;
      this.clientService.getClientByNom(this.login).subscribe((client:any)=>{
        this.client=client;
        this.ami.id1=this.client.nom;
        this.amiService.getAll(this.ami.id1).subscribe(
          (amis: Amis[])=>{
            //this.ami.id2=amis;
            this.amiDisplay.id2=amis;
            console.log(this.amiDisplay);
            console.log(this.ami.id2);
          },
          (error)=>{
            console.log(error);
          }
        );
      });
    }

  }

  onSubmitAmi(){
    this.amiService.create(this.ami).subscribe((result)=>{
      alert("Votre ami a été ajouté avec succès!");
      window.location.reload();
    },(error)=>{
      alert("Une erreur s'est produite, votre ami n'a pas été ajouté!");
    });
  }

  deleteAmi(nom:any){
    console.log(nom);
    console.log({id1:this.ami.id1,id2:nom});

    if(confirm("Êtes vous sûr de vouloir supprimer cet ami? Cette opération est irréversible!")){
      this.amiService.delete({id1:this.ami.id1,id2:nom}).subscribe(()=>{
        window.location.reload();
        alert('Ami supprimé avec succès');
      });
    }
  }

}
