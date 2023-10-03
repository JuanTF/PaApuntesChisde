package pe.edu.upc.aaw.ep_ejercicio3_universidad.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.entities.University;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.repositories.IUniversityRepository;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.serviceinterfaces.IUniversityService;

@Service
public class UniversityServiceImplement implements IUniversityService {
    @Autowired
    private IUniversityRepository jmtrUr;

    @Override
    public void insert(University jmtrUniversity) {
        jmtrUr.save(jmtrUniversity);
    }
}
