package pe.edu.upc.aaw.ep_ejercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.ep_ejercicio2.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    public Users findByJmtrUsername(String jmtrUsername);

}
