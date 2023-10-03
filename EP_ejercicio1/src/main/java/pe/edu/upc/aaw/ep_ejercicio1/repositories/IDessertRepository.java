package pe.edu.upc.aaw.ep_ejercicio1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.ep_ejercicio1.entities.Dessert;

@Repository
public interface IDessertRepository extends JpaRepository<Dessert,Integer> {

}
