package Laposte.Simplon.WheelsForPets.Model;

import javax.persistence.*;

@Entity
@Table(name= "reservations")
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifiant;
    private boolean validee;

    @Column(name= "identifiant_users")
    private int identifiantUser;

    @Column(name= "identifiant_annonces")
    private int identifiantAnnonce;


    public Reservation() {
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public boolean isValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public int getIdentifiantUser() {
        return identifiantUser;
    }

    public void setIdentifiantUser(int identifiantUser) {
        this.identifiantUser = identifiantUser;
    }

    public int getIdentifiantAnnonce() {
        return identifiantAnnonce;
    }

    public void setIdentifiantAnnonce(int identifiantAnnonce) {
        this.identifiantAnnonce = identifiantAnnonce;
    }
}
