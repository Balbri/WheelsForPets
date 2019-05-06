package Laposte.Simplon.WheelsForPets.Repository;

import Laposte.Simplon.WheelsForPets.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{

    @Query(value = "SELECT * FROM articles WHERE articles.titre like ?1", nativeQuery = true)
    Optional<Article> findByTitre(String titre);

}
