package Laposte.Simplon.WheelsForPets.Model;

import javax.persistence.*;

@Entity
@Table(name= "reservations")
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationid")
    private int reservationId;
    private boolean validee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    private User user;


    @OneToOne(cascade = CascadeType.ALL)
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

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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
