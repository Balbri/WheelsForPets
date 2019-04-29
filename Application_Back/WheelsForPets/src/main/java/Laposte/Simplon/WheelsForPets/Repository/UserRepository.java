package Laposte.Simplon.WheelsForPets.Repository;

import java.util.Optional;

import Laposte.Simplon.WheelsForPets.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query(value = "SELECT * FROM users WHERE users.username like ?1", nativeQuery = true)
    Optional<User> findByUsername(String username);

}
