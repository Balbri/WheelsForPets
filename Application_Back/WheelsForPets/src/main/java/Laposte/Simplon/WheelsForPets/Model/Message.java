package Laposte.Simplon.WheelsForPets.Model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageid")
    private int messageId;
    private String titre;
    private String contenu;

    @Temporal(TemporalType.DATE)
    private Date date;


    @ManyToOne(cascade={CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name="annonceid")
    private Annonce annonce;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="userid")
    private User user;



    public Message() {
    }



    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
