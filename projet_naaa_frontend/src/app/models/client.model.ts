export class Client {
  id?: number;
  nom: string;
  avatar: string;
  compte: {
    login: string;
    password: string;
    role: number;
  };

  constructor(nom: string, avatar:string, login: string, password: string) {
    this.nom = nom;
    this.avatar=avatar;
    this.compte = {
      login: login,
      password: password,
      role: 0 // 0 pour CLIENT_FREEMIUM
    };
  }
}
