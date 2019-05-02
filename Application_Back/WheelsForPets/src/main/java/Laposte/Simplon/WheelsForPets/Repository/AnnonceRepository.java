package Laposte.Simplon.WheelsForPets.Repository;

import Laposte.Simplon.WheelsForPets.Model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer>{

    @Query(value = "SELECT * FROM annonces WHERE annonces.titre like ?1", nativeQuery = true)
    Optional<Annonce> findByUsername(String username);

    @Query(value = "SELECT * FROM annonces ORDER BY annonces.DateRedaction DESC LIMIT 3", nativeQuery = true)
    Collection<Annonce> getLast3Annonces();

}
