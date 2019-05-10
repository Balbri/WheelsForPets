package Laposte.Simplon.WheelsForPets.Controller;

import Laposte.Simplon.WheelsForPets.Model.Reservation;
import Laposte.Simplon.WheelsForPets.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ReservationController {



    @Autowired
    private ReservationRepository reservationRepository;


    /*
     * Methode Get All
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/reservations", produces = "application/json")
    public ResponseEntity<Collection<Reservation>> getAllMessages(){
        return new ResponseEntity<Collection<Reservation>>(reservationRepository.findAll(), HttpStatus.OK);
    }



    /*
     * Methode get par ID
     */
    @RequestMapping(value = "/reservations/{reservationId}", method = RequestMethod.GET)
    public ResponseEntity<?> getReservationById(@PathVariable int reservationId){
        Optional<Reservation> reservation = null;

        try {
            reservation =(reservationRepository.findById(reservationId));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        if(reservation == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(reservation);
    }

    /*
     * Methode get par Annonce
     */
    @RequestMapping(value = "/annonces/reservations/{reservationId}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Reservation>> getReservationByAnnonceId(@PathVariable int reservationId) {
        return new ResponseEntity<>(reservationRepository.findByIdAnnonce(reservationId), HttpStatus.OK);

    }


    /*
     * Methode POST
     */
    @RequestMapping(value = "/reservations", method = RequestMethod.POST, produces= "application/json", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> addReservation(@RequestBody Reservation reservation){
        Reservation resultReservation = null;
        try {
          resultReservation = reservationRepository.saveAndFlush(reservation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resultReservation);
    }

    /*
     * Methode PUT
     */

    @PutMapping(value = "/reservations/{reservationId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> modifyReservation(@RequestBody Reservation reservation) {
        Reservation reservationAmodifier = null;

        try {
            reservationAmodifier = reservationRepository.saveAndFlush(reservation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationAmodifier);
    }

    /*
     * Methode DELETE
     */
    @RequestMapping(value = "/reservations/{reservationId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteReservation(@PathVariable Integer reservationId){
        Reservation reservationAsupprimer = null;
        try {
            reservationAsupprimer = reservationRepository.findById(reservationId).get();
            reservationRepository.deleteById(reservationId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(reservationAsupprimer);
    }
}