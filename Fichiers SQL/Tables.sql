#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Articles
#------------------------------------------------------------

CREATE TABLE Articles(
        articleId Int  Auto_increment  NOT NULL ,
        titre     Varchar (255) NOT NULL ,
        date      Date NOT NULL ,
        contenu   Text NOT NULL ,
        visuel    Blob NOT NULL
	,CONSTRAINT Articles_PK PRIMARY KEY (articleId)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Authorities
#------------------------------------------------------------

CREATE TABLE Authorities(
        authorityId Int  Auto_increment  NOT NULL ,
        username    Varchar (55) NOT NULL ,
        authority   Varchar (55) NOT NULL
	,CONSTRAINT Authorities_PK PRIMARY KEY (authorityId)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Users
#------------------------------------------------------------

CREATE TABLE Users(
        UserId        Int  Auto_increment  NOT NULL ,
        password      Varchar (255) NOT NULL ,
        nom           Varchar (50) NOT NULL ,
        prenom        Varchar (55) NOT NULL ,
        dateNaissance Date NOT NULL ,
        numRue        Int NOT NULL ,
        rue           Varchar (55) NOT NULL ,
        codePostal    Int NOT NULL ,
        ville         Varchar (55) NOT NULL ,
        vehicule      Varchar (55) NOT NULL ,
        username      Varchar (55) NOT NULL ,
        enabled       Bool NOT NULL ,
        authorityId   Int NOT NULL
	,CONSTRAINT Users_PK PRIMARY KEY (UserId)

	,CONSTRAINT Users_Authorities_FK FOREIGN KEY (authorityId) REFERENCES Authorities(authorityId)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Animaux
#------------------------------------------------------------

CREATE TABLE Animaux(
        animauxId   Int  Auto_increment  NOT NULL ,
        nom         Varchar (50) NOT NULL ,
        age         Int NOT NULL ,
        espece      Varchar (50) NOT NULL ,
        description Text NOT NULL ,
        UserId      Int NOT NULL
	,CONSTRAINT Animaux_PK PRIMARY KEY (animauxId)

	,CONSTRAINT Animaux_Users_FK FOREIGN KEY (UserId) REFERENCES Users(UserId)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Annonces
#------------------------------------------------------------

CREATE TABLE Annonces(
        annonceID     Int  Auto_increment  NOT NULL ,
        dateRedaction Date NOT NULL ,
        titre         Varchar (255) NOT NULL ,
        description   Text NOT NULL ,
        villeDepart   Varchar (255) NOT NULL ,
        CPDepart      Int NOT NULL ,
        dateDepart    Date NOT NULL ,
        CPArrivee     Int NOT NULL ,
        villeArrivee  Varchar (255) NOT NULL ,
        dateArrivee   Date NOT NULL ,
        prix          Float NOT NULL ,
        UserId        Int NOT NULL
	,CONSTRAINT Annonces_PK PRIMARY KEY (annonceID)

	,CONSTRAINT Annonces_Users_FK FOREIGN KEY (UserId) REFERENCES Users(UserId)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Messages
#------------------------------------------------------------

CREATE TABLE Messages(
        messageId Int  Auto_increment  NOT NULL ,
        titre     Varchar (255) NOT NULL ,
        date      Date NOT NULL ,
        contenu   Text NOT NULL ,
        annonceID Int NOT NULL ,
        UserId    Int NOT NULL
	,CONSTRAINT Messages_PK PRIMARY KEY (messageId)

	,CONSTRAINT Messages_Annonces_FK FOREIGN KEY (annonceID) REFERENCES Annonces(annonceID)
	,CONSTRAINT Messages_Users0_FK FOREIGN KEY (UserId) REFERENCES Users(UserId)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Reservations
#------------------------------------------------------------

CREATE TABLE Reservations(
        reservationId Int  Auto_increment  NOT NULL ,
        validee       Bool NOT NULL ,
        UserId        Int NOT NULL ,
        annonceID     Int NOT NULL
	,CONSTRAINT Reservations_PK PRIMARY KEY (reservationId)

	,CONSTRAINT Reservations_Users_FK FOREIGN KEY (UserId) REFERENCES Users(UserId)
	,CONSTRAINT Reservations_Annonces0_FK FOREIGN KEY (annonceID) REFERENCES Annonces(annonceID)
	,CONSTRAINT Reservations_Annonces_AK UNIQUE (annonceID)
)ENGINE=InnoDB;

