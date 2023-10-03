package pe.edu.upc.aaw.ep_ejercicio1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.ep_ejercicio1.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
