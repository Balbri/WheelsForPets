package Laposte.Simplon.WheelsForPets.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name= "reservations")
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationid")
    private int reservationId;
    private boolean validee;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userid")
    private User user;



    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "annonceid")
    private Annonce annonce;


    public Reservation() {
    }

    public int getreservationId() {
        return reservationId;
    }

    public void setreservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }





    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
}
