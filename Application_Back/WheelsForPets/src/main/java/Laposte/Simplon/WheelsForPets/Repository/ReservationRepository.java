package Laposte.Simplon.WheelsForPets.Repository;

import Laposte.Simplon.WheelsForPets.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

    @Query(value = "SELECT * FROM reservations WHERE (Identifiant_Annonces = ?1)", nativeQuery = true)
    Collection<Reservation>findByIdAnnonce(int identifiant);




}
