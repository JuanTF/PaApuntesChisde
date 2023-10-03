package pe.edu.upc.aaw.ep_ejercicio4_enterprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities.Enterprice;

@Repository
public interface IEnterpriceRepository extends JpaRepository<Enterprice,Long> {

}
