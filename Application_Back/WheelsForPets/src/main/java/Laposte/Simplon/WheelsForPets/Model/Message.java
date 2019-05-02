package Laposte.Simplon.WheelsForPets.Model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifiant;
    private String titre;
    private String contenu;

    @Temporal(TemporalType.DATE)
    private Date date;


    @Column(name="identifiant_annonces")
    private int identifiantAnnonce;

    @Column(name = "identifiant_users")
    private int identifiantUser;


    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
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

    public int getIdentifiantAnnonce() {
        return identifiantAnnonce;
    }

    public void setIdentifiantAnnonce(int identifiantAnnonce) {
        this.identifiantAnnonce = identifiantAnnonce;
    }

    public int getIdentifiantUser() {
        return identifiantUser;
    }

    public void setIdentifiantUser(int identifiantUser) {
        this.identifiantUser = identifiantUser;
    }
}
