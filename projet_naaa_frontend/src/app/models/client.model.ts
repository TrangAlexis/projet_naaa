export class Client {
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
      role: 0 // 0 pour CLIENT_FREEMIUM
    };
  }
}
