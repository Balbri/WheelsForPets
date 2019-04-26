#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


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
# Table: Authorities
#------------------------------------------------------------

CREATE TABLE Authorities(
        Identifiant Int  Auto_increment  NOT NULL ,
        username    Varchar (55) NOT NULL ,
        authority   Varchar (55) NOT NULL
	,CONSTRAINT Authorities_PK PRIMARY KEY (Identifiant)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Users
#------------------------------------------------------------

CREATE TABLE Users(
        Identifiant             Int  Auto_increment  NOT NULL ,
        password                Varchar (255) NOT NULL ,
        Nom                     Varchar (50) NOT NULL ,
        Prenom                  Varchar (55) NOT NULL ,
        DateNaissance           Date NOT NULL ,
        NumRue                  Int NOT NULL ,
        Rue                     Varchar (55) NOT NULL ,
        Code_Postal             Int NOT NULL ,
        Ville                   Varchar (55) NOT NULL ,
        Vehicule                Varchar (55) NOT NULL ,
        Username                Varchar (55) NOT NULL ,
        enabled                 Bool NOT NULL ,
        Identifiant_Authorities Int NOT NULL
	,CONSTRAINT Users_PK PRIMARY KEY (Identifiant)

	,CONSTRAINT Users_Authorities_FK FOREIGN KEY (Identifiant_Authorities) REFERENCES Authorities(Identifiant)
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
# Table: Annonces
#------------------------------------------------------------

CREATE TABLE Annonces(
        Identifiant       Int  Auto_increment  NOT NULL ,
        DateRedaction     Date NOT NULL ,
        Titre             Varchar (255) NOT NULL ,
        Description       Text NOT NULL ,
        VilleDepart       Varchar (255) NOT NULL ,
        CPDepart          Int NOT NULL ,
        DateDepart        Date NOT NULL ,
        CPArrivee         Int NOT NULL ,
        VilleArrivee      Varchar (255) NOT NULL ,
        DateArrivee       Date NOT NULL ,
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
        Identifiant_Annonces Int NOT NULL ,
        Identifiant_Users    Int NOT NULL
	,CONSTRAINT Messages_PK PRIMARY KEY (Identifiant)

	,CONSTRAINT Messages_Annonces_FK FOREIGN KEY (Identifiant_Annonces) REFERENCES Annonces(Identifiant)
	,CONSTRAINT Messages_Users0_FK FOREIGN KEY (Identifiant_Users) REFERENCES Users(Identifiant)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Reservations
#------------------------------------------------------------

CREATE TABLE Reservations(
        Identifiant          Int  Auto_increment  NOT NULL ,
        Validee              Bool NOT NULL ,
        Identifiant_Users    Int NOT NULL ,
        Identifiant_Annonces Int NOT NULL
	,CONSTRAINT Reservations_PK PRIMARY KEY (Identifiant)

	,CONSTRAINT Reservations_Users_FK FOREIGN KEY (Identifiant_Users) REFERENCES Users(Identifiant)
	,CONSTRAINT Reservations_Annonces0_FK FOREIGN KEY (Identifiant_Annonces) REFERENCES Annonces(Identifiant)
	,CONSTRAINT Reservations_Annonces_AK UNIQUE (Identifiant_Annonces)
)ENGINE=InnoDB;

