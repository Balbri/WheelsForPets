
INSERT INTO Articles (articleid, Titre, Date, Contenu, Visuel) VALUES (0 ,"Bonne année 2017", "2016-12-31", "Toute l'équipe de WfP vous souhaite une heureuse année 2017!", " http://6a21dce278275d3d868d-fcb80616f2777fb30a7a76c10a11eb5a.r66.cf1.rackcdn.com/fireworksdog.jpg");

INSERT INTO Users (userid, Password, Nom, Prenom, DateNaissance, NumRue, Rue, CodePostal, Ville, Vehicule, Username, Enabled) VALUES (0 , "Admin666", "Macron", "Emmanuel", DATE '1965-04-15', 23, "Rue de la galère", 75001, "Paris", "Peugeot 406", "Numero1", true);

INSERT INTO Users (userid, Password, Nom, Prenom, DateNaissance, NumRue, Rue, CodePostal, Ville, Vehicule, Username, Enabled) VALUES (0 , "Admin666", "Philippe", "Edouard", DATE '1965-04-15', 23, "Rue de la galère", 75001, "Paris", "Peugeot 408", "LecheCul", true);

INSERT INTO animaux (animauxid, Nom, Age, Espece, Description, userid) VALUES (0 , "Nux", 8, "Chien", "Un chien sympa", 2);

INSERT INTO annonces (annonceid, DateRedaction, Titre, Description, CPDepart, CPArrivee, DateDepart, DateArrivee, VilleDepart, VilleArrivee, Prix, userid) VALUES (0 , DATE '2018-02-14', "Balade Sociale du 2 Avril", "J'ai une place disponible pour un chien et son maître", 78800, 92100, DATE '2018-04-02', DATE '2018-04-02', "Houilles", "Nanterre", 5, 1);

INSERT INTO messages (messageid, Titre, Date, Contenu, annonceid, userid) VALUES (0 , "Possible PittBull?", DATE '2018-02-19', "Bonjour, j'ai un pitbull gentil, est-ce que vous accepteriez de nous emmener?", 1, 2);

INSERT INTO messages (messageid, Titre, Date, Contenu, annonceid, userid) VALUES (0 , "RE - Possible PittBull?", DATE '2018-02-19', "Biensûr, pas de problème", 1, 1);

insert INTO Users (userid, Password, Nom, Prenom, DateNaissance, NumRue, Rue, CodePostal, Ville, Vehicule, Username, Enabled) VALUES (0 , "blabla", "Rais", "Rachid", DATE '1985-06-25', 12, "Camille Desmoulins", 92800, "Issy", "Audi RS8", "Racanimauxhidou22", true);

INSERT INTO Reservations (reservationid, Validee, userid, annonceid) values (0, False, 2, 1)