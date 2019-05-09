# WheelsForPets
<strong>[Trello](https://trello.com/b/W3I6500n/wheels-for-pets)</strong>

Contexte:

Dans un internet de plus en plus tourné vers l'économie alternative et participative, le web a vu fleurir de nombreux sites d'entraide et de services entre particulier. LeBonCoin, Blablacar, Drivy sont des exemples parmis nombreux autres, et sont certainement les plus grands porte-étendards de cette nouvelle économie de l'Internet Français. 

Néanmoins, il existe un domaine dans lequel aucun service n'est proposé: Le transport d'animaux de compagnie. Les citadins qui possèdent un chien le savent, ne pas avoir de véhicule rend toute sortie à la campagne impossible. Ne pas être véhiculé, c'est aussi devoir acheter une place de train pour pouvoir y faire monter son animal, ou un espace en soute lors d'un trajet en avion. 

Wheels For pets a pour objectif de répondre à cette problématique en permettant aux utilisateurs de proposer et trouver des solutions de transport dédiées spécifiquement aux animaux.
 
 Les internautes souhaitant déplacer leur animal sans être véhiculés doivent aujourd'hui s'arranger via des groupes Facebook dédiés, ou peuvent se tourner vers la solution professionelle payante  http://www.france-express.com/.

L'objectif de Wheels for Pets est double. A l'échelle globale, il est de proposer une solution simple et efficace pour fluidifier les adoptions dans le milieu associatif. A l'échelle personnelle, il peut permettre à quelqu'un de non véhiculé de déplacer son animal sans devoir prendre les transports en communs, qui peuvent être stressants pour les bêtes.


## Cas d'utilisation

![Diagramme UseCase](https://github.com/Balbri/WheelsForPets/blob/master/Documentation%20Source/Usecase.png)

## Base de Données

![MLD Wheels For Pets](https://github.com/Balbri/WheelsForPets/blob/master/Documentation%20Source/MLD.png)


## Wireframes
[Wireframe Homepage](https://github.com/Balbri/WheelsForPets/blob/master/Wireframes/%5BWF%5DWFP_Home_01.jpg)

[Wireframe Home Mobile Base](https://github.com/Balbri/WheelsForPets/blob/master/Wireframes/%5BWF%5DWFP_Home_Mobile_02.jpg)

[Wireframe Home Mobile Etendue](https://github.com/Balbri/WheelsForPets/blob/master/Wireframes/%5BWF%5DWFP_Home_Mobile_01.jpg)

## Maquettes

[Maquette Homepage](https://github.com/Balbri/WheelsForPets/blob/master/Exports/%5BCREASITE%5DWFP_Desk_Home_02.jpg)


## Règles de gestion:

.Un visiteur peut consulter les annonces et les messages postés sur ces annonces. Il peut s'inscrire / se connecter sur le site pour effectuer les actions propres aux membres authentifiés.

.Un utilisateur inscrit doit pouvoir poster, consulter et souscrire à une annonce. Il possède peut posséder des animaux. Il peut lire et poster des messages. Il est pourvu d'un Role utilisateur (son niveau d'accès sur le site). Il peut gérer son profil / ses animaux. Pour valider une réservation, il doit aller au bout du tunnel de paiement.

.Une annonce peut contenir des messages. Elle contient aussi un unique emplacement de réservation utilisable par un autre utilisateur.

.L'administrateur peut consulter toutes les tables et les gérer, il peut aussi poster des articles.

.Un article est une entité indépendante, n'ayant aucune relation avec les autres tables.


## Technologies et langages utilisés:

Base de Données: MySQL, Modélisation avec jMerise, 

Back office: Application en Java, application Spring.

Front office: Angular 6

Contrôle de version: GitHub

Test de requêtes à la base de données: Postman


### Dépendances: 


<strong>mysql-connector-java :</strong> Pilote permettant d'assurer la connexion à la base de données.

<strong>spring-boot-starter-web :</strong> Permet de développer une application web.


<strong>spring-boot-starter-data-jpa :</strong> Implémentation d'Hibernate pour utiliser les données Java Persistance API.

<strong>spring-boot-starter-security :</strong> Implémentation des options relatives à la sécurisation de l'application.

<strong>spring-boot-starter-thymeleaf :</strong> Module visuel utilisé par Spring Security pour le formulaire de connexion.


<strong>jjwt-api :</strong> Module permettant de gérer les tokens de sécurité.

<strong>jjwt-impl :</strong> Module d'implémentation de Json Web Token.

<strong>jjwt-jackson :</strong> Mapper d'objet pour Json Web Token.


<strong>spring-boot-starter-test :</strong> Pour les tests unitaires.

<strong>spring-security-test :</strong> Pour les tests unitaires liés à Spring Security.


<strong>spring-boot-devtools :</strong> Outil de conception pour optimiser le développement.













