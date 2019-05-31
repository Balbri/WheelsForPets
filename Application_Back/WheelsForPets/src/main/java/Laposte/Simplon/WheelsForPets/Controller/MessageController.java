package Laposte.Simplon.WheelsForPets.Controller;

import Laposte.Simplon.WheelsForPets.Model.Message;
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
    @RequestMapping(value = "/messages/{messageId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMessageById(@PathVariable int messageId){
        Optional<Message> message = null;

        try {
            message =(messageRepository.findById(messageId));

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
    @RequestMapping(value = "/annonces/messages/{messageId}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Message>> getMessageByAnnonceId(@PathVariable int messageId) {
        return new ResponseEntity<>(messageRepository.findByIdAnnonce(messageId), HttpStatus.OK);

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
        System.out.println(resultMessage);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultMessage);

    }

    /*
     * Methode PUT
     */

    @PutMapping(value = "/messages/{messageId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
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
    @RequestMapping(value = "/messages/{messageId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMessage(@PathVariable Integer messageId){
        Message messageAsupprimer = null;
        try {
            messageAsupprimer = messageRepository.findById(messageId).get();
            messageRepository.deleteById(messageId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(messageAsupprimer);
    }
}