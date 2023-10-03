package pe.edu.upc.aaw.ep_ejercicio1.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.ep_ejercicio1.entities.Dessert;
import pe.edu.upc.aaw.ep_ejercicio1.repositories.IDessertRepository;
import pe.edu.upc.aaw.ep_ejercicio1.serviceinterfaces.IDessertService;

@Service
public class DessertServiceImplement implements IDessertService {
    @Autowired
    private IDessertRepository jmtrDr;

    @Override
    public void insert(Dessert jmtrDessert) {
        jmtrDr.save(jmtrDessert);
    }
}
