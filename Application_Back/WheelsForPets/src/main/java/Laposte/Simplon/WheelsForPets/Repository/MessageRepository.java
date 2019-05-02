package Laposte.Simplon.WheelsForPets.Repository;

import Laposte.Simplon.WheelsForPets.Model.Annonce;
import Laposte.Simplon.WheelsForPets.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

    @Query(value = "SELECT * FROM messages WHERE (Identifiant_Annonces = ?1)", nativeQuery = true)
    Collection<Message>findByIdAnnonce(int identifiant);

}
