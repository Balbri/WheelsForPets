package Laposte.Simplon.WheelsForPets.Repository;

import Laposte.Simplon.WheelsForPets.Model.Animal;
import Laposte.Simplon.WheelsForPets.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{

    @Query(value = "SELECT * FROM animaux WHERE animaux.nom like ?1", nativeQuery = true)
    Optional<Article> findBynom(String nom);

}
