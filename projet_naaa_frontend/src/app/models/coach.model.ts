export class Coach {
  id?: number;
  nom: string;
  compte: {
    login: string;
    password: string;
    role: number;
  };

  constructor(nom: string, login: string, password: string) {
    this.nom = nom;
    this.compte = {
      login: login,
      password: password,
      role: 2 //coahc
    };
  }
}
