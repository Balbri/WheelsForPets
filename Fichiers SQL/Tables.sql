#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Users
#------------------------------------------------------------

CREATE TABLE Users(
        Identifiant   Int  Auto_increment  NOT NULL ,
        MotDePasse    Varchar (255) NOT NULL ,
        Nom           Varchar (50) NOT NULL ,
        Prenom        Varchar (50) NOT NULL ,
        DateNaissance Date NOT NULL ,
        NumRue        Int NOT NULL ,
        Rue           Varchar (50) NOT NULL ,
        Code_Postal   Int NOT NULL ,
        Ville         Varchar (5) NOT NULL ,
        Vehicule      Varchar (5) NOT NULL
	,CONSTRAINT Users_PK PRIMARY KEY (Identifiant)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Animaux
#------------------------------------------------------------

CREATE TABLE Animaux(
        Identifiant       Int  Auto_increment  NOT NULL ,
        Nom               Varchar (50) NOT NULL ,
        Age               Int NOT NULL ,
        Espece            Varchar (50) NOT NULL ,
        Description       Text NOT NULL ,
        Identifiant_Users Int NOT NULL
	,CONSTRAINT Animaux_PK PRIMARY KEY (Identifiant)

	,CONSTRAINT Animaux_Users_FK FOREIGN KEY (Identifiant_Users) REFERENCES Users(Identifiant)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Articles
#------------------------------------------------------------

CREATE TABLE Articles(
        Identifiant Int  Auto_increment  NOT NULL ,
        Titre       Varchar (255) NOT NULL ,
        Date        Date NOT NULL ,
        Contenu     Text NOT NULL ,
        Visuel      Blob NOT NULL
	,CONSTRAINT Articles_PK PRIMARY KEY (Identifiant)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Annonces
#------------------------------------------------------------

CREATE TABLE Annonces(
        Identifiant       Int  Auto_increment  NOT NULL ,
        DateRedaction     Date NOT NULL ,
        Titre             Varchar (255) NOT NULL ,
        Description       Text NOT NULL ,
        Depart            Varchar (255) NOT NULL ,
        Arrivee           Varchar (255) NOT NULL ,
        DateDepart        Date NOT NULL ,
        DateArrivee       Date NOT NULL ,
        Validee           Bool NOT NULL ,
        Prix              Float NOT NULL ,
        Identifiant_Users Int NOT NULL
	,CONSTRAINT Annonces_PK PRIMARY KEY (Identifiant)

	,CONSTRAINT Annonces_Users_FK FOREIGN KEY (Identifiant_Users) REFERENCES Users(Identifiant)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Messages
#------------------------------------------------------------

CREATE TABLE Messages(
        Identifiant          Int  Auto_increment  NOT NULL ,
        Titre                Varchar (255) NOT NULL ,
        Date                 Date NOT NULL ,
        Contenu              Text NOT NULL ,
        Identifiant_Annonces Int NOT NULL
	,CONSTRAINT Messages_PK PRIMARY KEY (Identifiant)

	,CONSTRAINT Messages_Annonces_FK FOREIGN KEY (Identifiant_Annonces) REFERENCES Annonces(Identifiant)
)ENGINE=InnoDB;

