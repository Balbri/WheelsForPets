package Laposte.Simplon.WheelsForPets.Controller;

import Laposte.Simplon.WheelsForPets.Model.Article;
import Laposte.Simplon.WheelsForPets.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ArticleController {



    @Autowired
    private ArticleRepository articleRepository;


    /*
     * Methode Get All
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/articles", produces = "application/json")
    public ResponseEntity<Collection<Article>> getAllArticles(){
        return new ResponseEntity<Collection<Article>>(articleRepository.findAll(), HttpStatus.OK);
    }



    /*
     * Methode get par ID
     */
    @RequestMapping(value = "/articles/{articleId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getArticleById(@PathVariable Integer articleId){
        Optional<Article> article = null;

        try {
            article =(articleRepository.findById(articleId));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        if(article == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(article);

    }


    /*
     * Methode POST
     */
    @RequestMapping(value = "/articles", method = RequestMethod.POST, produces= "application/json", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> addArticle(@RequestBody Article article){
        Article resultArticle = null;
        article.setDate(new Date());
        try {
          resultArticle = articleRepository.saveAndFlush(article);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resultArticle);
    }

    /*
     * Methode PUT
     */

    @PutMapping(value = "/articles/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> modifyArticle(@RequestBody Article article) {
        Article articleAmodifier = null;

        try {
            articleAmodifier = articleRepository.saveAndFlush(article);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(articleAmodifier);
    }

    /*
     * Methode DELETE
     */
    @RequestMapping(value = "/articles/{articleId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteArticle(@PathVariable Integer articleId){
        Article articleAsupprimer = null;
        try {
            articleAsupprimer = articleRepository.findById(articleId).get();
            articleRepository.deleteById(articleId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(articleAsupprimer);
    }
}