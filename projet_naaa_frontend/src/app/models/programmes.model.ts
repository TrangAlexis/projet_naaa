export class Programme {
  
  public id?: number;
    constructor(
      public title: string,
      public points: number,
      public rewardTitle: string,
      public imageSrc: string,
      public participants: number,
      public finishedChallengers: number,
      public isFavorite: boolean
    ) {}
}

  