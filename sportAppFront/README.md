# Front-End side Sport App Project
Without JS Frameworks
.css with TailwindCSS

To do:
- Page index.js:  Implémenter JS toggle effect if signed-in or not sign-in (Susbcription / Sign In button apparent if user not connected)
                  When user connected: name, title, level and personnalized programs appear.
                 
- Page d'inscription: nom, prenom, mail, mdp, confirmation mdp, choix abonnement, "Subscribe" button big, close little cross button at the top right side opacity-50%.

- Page de quizz_1 : premier quizz du nouveau inscrit : questions style de vie, objectifs, temps pret à être consacré au sport : génère un programme sportif sur-mesure

- Page de quizz_2 : quizz de modification : infos deja prise en compte, juste modification des objectifs 

- Page user (profil):   rounded-full profile picture, title, name, level, points
                        table des succes et accomplissement : listing de tout ce que l'user à gagner en succès, tout les programmes terminés,  tout les évènements...
                        bouton "Lier profil réseau social" : lie profil user à son compte FB ou autre...
                        bouton "Modifier Profil" => page modification profil (nom, prenom, mail, tel, adresse...)
                        bouton "Mes programmes" => page programme en cours (programme en cours bouton "Commencer", programmes terminés, bouton "nouveau programme")
                                                                                                                                        mène vers un quizz_2
                        bouton danger_zone "Désactiver et supprimer le compte" : efface les données de l'utilisateur de la BDD. 
                        
- Page social : Rank parmis la liste de connexion des amis sous forme de sorted list by point
                          possibilité d'ajouter des amis via la recherche via le numéro de téléphone
                          possibilité de supprimer des amis
                          possibilité de masquer des amis
                          possibilité de favoris des amis
                          possibilité de msg les amis : interface messagerie réseau social en ligne à implémenter. 
                          
- Page loupe/recherche : listing de tout les programmes d'entrainenement généraux non personnalisés, exemple: "les abdos en béton en 30 jours",
                                                                                                              "3 mois pour un boule à la kardashian", 
                                                                                                              "remise en forme", "classic PPL"...
                          Bouton "Question à Claude??, notre IA": ouverture interface chat direct avec une IA programmé instancié coach sportif.
                          Les questions sont prédéfinies en exemple à cliquer, ou directement écris par l'user.
                          [Though about learning AI => user progression, program personnalization but kinda tricky...]


