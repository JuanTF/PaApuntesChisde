package pe.edu.upc.aaw.ep_ejercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.ep_ejercicio2.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
