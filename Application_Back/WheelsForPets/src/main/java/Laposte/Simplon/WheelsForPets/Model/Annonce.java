package Laposte.Simplon.WheelsForPets.Model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "annonces")
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "annonceid")
    private int annonceId;

    @Temporal(TemporalType.DATE)
    @Column(name="dateredaction")
    private Date dateRedaction;

    private String titre;

    private String description;

    @Column(name="villedepart")
    private String villeDepart;

    @Column(name="cpdepart")
    private int cpDepart;

    @Temporal(TemporalType.DATE)
    @Column(name="datedepart")
    private Date dateDepart;


    @Column(name="villearrivee")
    private String villeArrivee;

    @Column(name="cparrivee")
    private int cpArrivee;

    @Temporal(TemporalType.DATE)
    @Column(name="datearrivee")
    private Date dateArrivee;

    private float prix;

    @OneToMany(mappedBy = "annonce")
    private List<Message> messageList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;







    public Annonce() {
    }


    public Date getDateRedaction() {
        return dateRedaction;
    }

    public void setDateRedaction(Date dateRedaction) {
        this.dateRedaction = dateRedaction;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public int getCpDepart() {
        return cpDepart;
    }

    public void setCpDepart(int cpDepart) {
        this.cpDepart = cpDepart;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public int getCpArrivee() {
        return cpArrivee;
    }

    public void setCpArrivee(int cpArrivee) {
        this.cpArrivee = cpArrivee;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getAnnonceId() {
        return annonceId;
    }

    public void setAnnonceId(int annonceId) {
        this.annonceId = annonceId;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
