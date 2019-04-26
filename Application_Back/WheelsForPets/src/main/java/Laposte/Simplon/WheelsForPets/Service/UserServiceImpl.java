package Laposte.Simplon.WheelsForPets.Service;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import livrocaz.model.Client;
import livrocaz.model.Commande;
import livrocaz.model.Users;
import livrocaz.repository.ClientRepository;
import livrocaz.repository.CommandeRepository;
import livrocaz.repository.UserRepository;
import Laposte.Simplon.WheelsForPets.Security.JwtTokenProvider;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;
    private ClientRepository clientRepo;
    private CommandeRepository commandeRepo;
    private BCryptPasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository userRepository, ClientRepository clientRepository, CommandeRepository commandeRepository,
                           BCryptPasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.userRepo = userRepository;
        this.clientRepo = clientRepository;
        this.commandeRepo = commandeRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    public String signin(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepo.findByUsername(username).get().getAuthority());
        } catch (AuthenticationException e) {
            throw new Exception();
        }
    }

    public String signup(Client client) throws Exception {
        if (!userRepo.findByUsername(client.getUsers().getUsername()).isPresent()) {
            Users userToSave = new Users(client.getUsers().getUsername(), passwordEncoder.encode(client.getUsers().getPassword()), client.getUsers().getAuthority());
            Client clientToSave = new Client(client.getNomClient(),
                    client.getPrenomClient(),
                    client.getNumeroL(),
                    client.getRueL(),
                    client.getComplementL(),
                    client.getCpL(),
                    client.getVilleL(),
                    client.getEmailClient(),
                    userToSave);
            // création du panier client (commande à 0)
            Commande commandeToSave = new Commande(clientToSave, new Date(), 5.65, 0.0, 0.0, 0);
            clientRepo.save(clientToSave);
            commandeRepo.save(commandeToSave);
            return jwtTokenProvider.createToken(client.getUsers().getUsername(), client.getUsers().getAuthority());
        } else {
            throw new Exception();
        }
    }
}