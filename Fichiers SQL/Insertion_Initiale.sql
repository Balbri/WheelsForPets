 
 ########################################## SCRIPT D'INSERTION DES DONNEES INITIALES POUR LA DEMONSTRATION ##########################################
 
 
 #INSERTION USERS:


INSERT INTO Users(
userid, Password, Nom, Prenom, DateNaissance, NumRue,
 Rue, CodePostal, Ville, Vehicule, Username, Enabled
 )
 VALUES(
 0 , "motdepasse", "Bridges", "Edouard", DATE '1965-04-15', 23, "Rue Montfort", 75001, "Paris", "Safrane", "Bedouard", true
 );
 
 INSERT INTO Users(
userid, Password, Nom, Prenom, DateNaissance, NumRue,
 Rue, CodePostal, Ville, Vehicule, Username, Enabled
 )
 VALUES(
 0 , "motdepasse", "Renoir", "Lilian", DATE '1986-03-12', 116, "Avenue Carnot", 31000, "Toulouse", "Peugeot 408sw", "Rlian", true
 );
 
 INSERT INTO Users(
userid, Password, Nom, Prenom, DateNaissance, NumRue,
 Rue, CodePostal, Ville, Vehicule, Username, Enabled
 )
 VALUES(
 0 , "motdepasse", "Cohen", "Lea", DATE '1985-11-22', 10, "Rue de la mairie", 31460, "Caignac", "Aixam Crossline", "LcoHen", true
 );
 
 INSERT INTO Users(
userid, Password, Nom, Prenom, DateNaissance, NumRue,
 Rue, CodePostal, Ville, Vehicule, Username, Enabled
 )
 VALUES(
 0 , "motdepasse", "Eggen", "Charlotte", DATE '1986-08-03', 11, "Rue Severine", 78800, "Houilles", "Peugeot 406", "CEggen", true
 );
 
 
 #INSERTION ANIMAUX
 
 INSERT INTO animaux (animalid, Nom, Age, Espece, Description, userid) VALUES (0 , "Nux", 8, "Chien", "Un chien sympa", 2);
 INSERT INTO animaux (animalid, Nom, Age, Espece, Description, userid) VALUES (0 , "Nikita", 2, "Chat", "Petite minette malicieuse", 1);
 INSERT INTO animaux (animalid, Nom, Age, Espece, Description, userid) VALUES (0 , "Coco", 8, "Cacatoes", "Piaf joueur et malicieux", 2);


#INSERTION ANNONCES

INSERT INTO annonces (
annonceid, DateRedaction, Titre, Description, CPDepart, CPArrivee, DateDepart, DateArrivee, VilleDepart, VilleArrivee, validee, Prix, acheteur,  redacteur
) VALUES (
0 , DATE '2018-02-14', "Balade Sociale du 2 Avril", "J'ai une place disponible pour un chien et son maître", 78800, 92100, DATE '2018-04-02', DATE '2018-04-02', "Houilles", "Nanterre",false, 5,2, 1
);

INSERT INTO annonces (
annonceid, DateRedaction, Titre, Description, CPDepart, CPArrivee, DateDepart, DateArrivee, VilleDepart, VilleArrivee, validee, Prix, acheteur,  redacteur
) VALUES (
0 , DATE '2019-05-15', "Trajet vers le Sud au mois de Juillet", "Partant en vacances vers Toulouse le 12 Juillet, j'ai de la place pour un chat(uniquement) et son maître", 75000, 31000, DATE '2019-07-12', DATE '2019-07-12', "Paris", "Toulouse",false, 40,null, 4
);

INSERT INTO annonces (
annonceid, DateRedaction, Titre, Description, CPDepart, CPArrivee, DateDepart, DateArrivee, VilleDepart, VilleArrivee, validee, Prix, acheteur,  redacteur
) VALUES (
0 , DATE '2019-03-11', "Sortie en forêt dans le 78", "Je pars pour une après midi en forêt de Saint Germain le 4 Mai et j'ai une place pour n'importe quel animal", 92100, 78200, DATE '2019-05-04', DATE '2019-05-04', "Nanterre", "Saint Germain en Laye",true, 10,1, 3
);

INSERT INTO annonces (
annonceid, DateRedaction, Titre, Description, CPDepart, CPArrivee, DateDepart, DateArrivee, VilleDepart, VilleArrivee, validee, Prix, acheteur,  redacteur
) VALUES (
0 , DATE '2019-03-21', "Annonce de test", "test", 92100, 78200, DATE '2019-05-04', DATE '2019-05-04', "Clermont Ferrand", "Brives",false, 100,null, 2
);

INSERT INTO annonces (
annonceid, DateRedaction, Titre, Description, CPDepart, CPArrivee, DateDepart, DateArrivee, VilleDepart, VilleArrivee, validee, Prix, acheteur,  redacteur
) VALUES (
0 , DATE '2019-06-21', "Annonce supplémentaire", "test", 92100, 78200, DATE '2019-05-04', DATE '2019-05-04', "Tours", "Toulon",false, 800,null, 1
);


#INSERTION MESSAGES

INSERT INTO messages (messageid, Titre, Date, Contenu, annonceid, userid) VALUES (0 , "Possible PittBull?", DATE '2018-02-19', "Bonjour, j'ai un pitbull gentil, est-ce que vous accepteriez de nous emmener?", 1, 2);

INSERT INTO messages (messageid, Titre, Date, Contenu, annonceid, userid) VALUES (0 , "RE - Possible PittBull?", DATE '2018-02-19', "Biensûr, pas de problème", 1, 1);


INSERT INTO articles (articleid, contenu, date, Titre, visuel) VALUES (
0, ("Wheels for pets, c'est la solution au problème commun à ceux qui n'ont pas de véhicule mais qui ont des animaux de compagnie.
 La plateforme vous offre la possibilité de vous retrouver et de vous organiser afin de déplacer vos meilleurs amis à poils ou plumes."), 
 '2019-01-01', 'https://www.sciencesetavenir.fr/assets/img/2018/01/26/cover-r4x3w1000-5a6b5197ebd39-sipa-51314555-000005.jpg')