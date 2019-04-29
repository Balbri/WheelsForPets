package Laposte.Simplon.WheelsForPets.Controller;

import java.util.Collection;
import java.util.Optional;

import Laposte.Simplon.WheelsForPets.Model.JsonWebToken;
import Laposte.Simplon.WheelsForPets.Model.User;
import Laposte.Simplon.WheelsForPets.Repository.UserRepository;
import Laposte.Simplon.WheelsForPets.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserRepository userRepo;

    /**
     * Method to register a new user in database.
     * @param user the new user to create.
     * @return a JWT if sign up is ok, a bad response code otherwise.
     * @throws Exception
     */
    @PostMapping("/sign-up")
    public ResponseEntity<JsonWebToken> signUp(@RequestBody User user) throws Exception {
        try {
            String token = userService.signup(user);
            return ResponseEntity.ok(new JsonWebToken(token));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Method to sign in a user (already existing).
     * @param user the user to sign in to the app.
     * @return a JWT if sign in is ok, a bad response code otherwise.
     * @throws Exception
     */
    @PostMapping("/sign-in")
    public ResponseEntity<JsonWebToken> signIn(@RequestBody User user) throws Exception {
        try {
            String token = userService.signin(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(new JsonWebToken(token));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    /*
     * Methode Get All
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/admin/users", produces = "application/json")
    public ResponseEntity<Collection<User>> getAllUsers(){
        return new ResponseEntity<Collection<User>>(userRepo.findAll(), HttpStatus.OK);
    }

    /*
     * Methode get par ID
     */
    @RequestMapping(value = "/admin/users/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String username){
        Optional<User> user = null;

        try {
            user =(userRepo.findByUsername(username));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        if(user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    /*
     * Methode POST
     */
    @RequestMapping(value = "/admin/users", method = RequestMethod.POST, produces= "application/json", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> addUser(@RequestBody User user){
        User resultUser = null;
        try {
            // cryptage mot de passe avant sauvegarde dans BDD
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            user.setPassword(bcrypt.encode(user.getPassword()));

            resultUser = userRepo.saveAndFlush(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(resultUser);
    }

    /*
     * Methode PUT
     */

    @PutMapping(value = "/admin/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> modifyUser(@RequestBody User user) {
        User useramodifier = null;
        String userPassword = null;
        try {
            userPassword = user.getPassword();

            // Si le MdP n'est pas déjà encrypté
            if (!userPassword.startsWith("$2a$10$")) {
                // cryptage mot de passe avant sauvegarde dans BDD
                BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
                user.setPassword(bcrypt.encode(user.getPassword()));
            }

            useramodifier = userRepo.saveAndFlush(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(useramodifier);
    }

    /*
     * Methode DELETE
     */
    @RequestMapping(value = "/admin/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        User userToDelete = null;
        try {
            userToDelete = userRepo.findById(id).get();
            userRepo.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(userToDelete);
    }
}