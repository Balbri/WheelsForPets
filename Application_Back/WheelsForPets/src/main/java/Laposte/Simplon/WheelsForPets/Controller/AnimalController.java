package Laposte.Simplon.WheelsForPets.Controller;

import Laposte.Simplon.WheelsForPets.Model.Animal;
import Laposte.Simplon.WheelsForPets.Repository.AnimalRepository;
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
public class AnimalController {



    @Autowired
private AnimalRepository animalRepository;


    /*
     * Methode Get All
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/animaux", produces = "application/json")
    public ResponseEntity<Collection<Animal>> getAllAnimaux(){
        return new ResponseEntity<Collection<Animal>>(animalRepository.findAll(), HttpStatus.OK);
    }



    /*
     * Methode get par ID
     */
    @RequestMapping(value = "/animaux/{animalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAnimalById(@PathVariable int animalId){
        Optional<Animal> animal = null;

        try {
            animal =(animalRepository.findById(animalId));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        if(animal == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(animal);
    }



    /*
     * Methode POST
     */
    @RequestMapping(value = "/animaux", method = RequestMethod.POST, produces= "application/json", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> addAnimal(@RequestBody Animal animal){
        Animal resultAnimal = null;
        try {
          resultAnimal = animalRepository.saveAndFlush(animal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resultAnimal);
    }

    /*
     * Methode PUT
     */

    @PutMapping(value = "/animaux/{animalId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> modifyAnimal(@RequestBody Animal animal) {
        Animal animalAmodifier = null;

        try {
            animalAmodifier = animalRepository.saveAndFlush(animal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(animalAmodifier);
    }

    /*
     * Methode DELETE
     */
    @RequestMapping(value = "/animaux/{animalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAnimal(@PathVariable Integer animalId){
        Animal animalAsupprimer = null;
        try {
            animalAsupprimer = animalRepository.findById(animalId).get();
            animalRepository.deleteById(animalId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(animalAsupprimer);
    }
}