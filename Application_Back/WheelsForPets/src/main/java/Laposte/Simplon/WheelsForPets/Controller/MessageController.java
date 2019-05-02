package Laposte.Simplon.WheelsForPets.Controller;

import Laposte.Simplon.WheelsForPets.Model.Annonce;
import Laposte.Simplon.WheelsForPets.Model.Message;
import Laposte.Simplon.WheelsForPets.Repository.AnnonceRepository;
import Laposte.Simplon.WheelsForPets.Repository.MessageRepository;
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
public class MessageController {



    @Autowired
    private MessageRepository messageRepository;



    /*
     * Methode Get All
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/messages", produces = "application/json")
    public ResponseEntity<Collection<Message>> getAllMessages(){
        return new ResponseEntity<Collection<Message>>(messageRepository.findAll(), HttpStatus.OK);
    }

    /*
     * Methode get par ID
     */
    @RequestMapping(value = "/messages/{identifiant}", method = RequestMethod.GET)
    public ResponseEntity<?> getMessageById(@PathVariable int identifiant){
        Optional<Message> message = null;

        try {
            message =(messageRepository.findById(identifiant));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        if(message == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    /*
     * Methode get par Annonce
     */
    @RequestMapping(value = "/annonces/messages/{identifiant}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Message>> getMessageByAnnonceId(@PathVariable int identifiant) {
        return new ResponseEntity<Collection<Message>>(messageRepository.findByIdAnnonce(identifiant), HttpStatus.OK);

    }


    /*
     * Methode POST
     */
    @RequestMapping(value = "/messages", method = RequestMethod.POST, produces= "application/json", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> addMessage(@RequestBody Message message){
        Message resultMessage = null;
        try {
          resultMessage = messageRepository.saveAndFlush(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resultMessage);
    }

    /*
     * Methode PUT
     */

    @PutMapping(value = "/messages/{identifiant}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> modifyMessage(@RequestBody Message message) {
        Message messageAmodifier = null;

        try {
            messageAmodifier = messageRepository.saveAndFlush(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(messageAmodifier);
    }

    /*
     * Methode DELETE
     */
    @RequestMapping(value = "/messages/{identifiant}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMessage(@PathVariable Integer identifiant){
        Message messageAsupprimer = null;
        try {
            messageAsupprimer = messageRepository.findById(identifiant).get();
            messageRepository.deleteById(identifiant);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(messageAsupprimer);
    }
}