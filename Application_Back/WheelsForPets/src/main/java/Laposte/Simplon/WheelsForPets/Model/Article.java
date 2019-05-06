package Laposte.Simplon.WheelsForPets.Model;


import sun.util.resources.Bundles;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "articleid")
    private int articleId;

    private String titre;
    @Temporal(TemporalType.DATE)
    private Date date;

    private String contenu;

    private Blob visuel;

    public Article() {
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Blob getVisuel() {
        return visuel;
    }

    public void setVisuel(Blob visuel) {
        this.visuel = visuel;
    }
}
