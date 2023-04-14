export class Client {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  login: string;
  mdp: string;
  pointsDeSucces: number;
  dateNaissance: Date;
  premium: boolean;
  programme: Programme;
  compte: Compte;

  constructor(
    id: number,
    nom: string,
    prenom: string,
    email: string,
    login: string,
    mdp: string,
    pointsDeSucces: number,
    dateNaissance: Date,
    premium: boolean,
    programme: Programme,
    compte: Compte
  ) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.login = login;
    this.mdp = mdp;
    this.pointsDeSucces = pointsDeSucces;
    this.dateNaissance = dateNaissance;
    this.premium = premium;
    this.programme = programme;
    this.compte = compte;
  }
}

export interface Compte {
  id: number;
  login: string;
  role: Role;
}

export enum Role {
  ROLE_CLIENTFREEMIUM = 'ROLE_CLIENTFREEMIUM',
  ROLE_CLIENTPREMIUM = 'ROLE_CLIENTPREMIUM',
  ROLE_COACH = 'ROLE_COACH'
}

export interface Programme {
  id: number;
  nom: string;
  description: string;
}
