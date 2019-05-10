package Laposte.Simplon.WheelsForPets.Model;


import javax.persistence.*;

@Entity
@Table(name = "animaux")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animauxid")
    private int animauxId;

    private String nom;

    private int age;

    private String espece;

    private String description;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "userid")
    private User user;


    public Animal() {
    }

    public int getAnimauxId() {
        return animauxId;
    }

    public void setAnimauxId(int animauxId) {
        this.animauxId = animauxId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
