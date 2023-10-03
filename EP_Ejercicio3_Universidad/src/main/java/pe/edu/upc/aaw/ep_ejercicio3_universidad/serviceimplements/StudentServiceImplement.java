package pe.edu.upc.aaw.ep_ejercicio3_universidad.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.entities.Student;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.repositories.IStudentRepository;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.serviceinterfaces.IStudentService;

import java.util.List;

@Service
public class StudentServiceImplement implements IStudentService {
    @Autowired
    private IStudentRepository jmtrSr;

    @Override
    public void insert(Student jmtrStudent) {
        jmtrSr.save(jmtrStudent);
    }

    @Override
    public List<String[]> listStudentPerGreatestWeightedAverage(Double jmtrQualification) {
        return jmtrSr.listStudentPerGreatestWeightedAverage(jmtrQualification);
    }

    @Override
    public List<Student> listStudentPerIdUniversity(Long jmtrQIdUniversity) {
        return jmtrSr.listStudentPerIdUniversity(jmtrQIdUniversity);
    }

    @Override
    public List<Student> findByJmtrUniversity_JmtrIdUniversity(Long jmtrQIdUni) {
        return jmtrSr.findByJmtrUniversity_JmtrIdUniversity(jmtrQIdUni);
    }

    @Override
    public List<Student> findByJmtrWeightedAverageIsGreaterThanEqualOrderByJmtrNameAsc(Double jmtrChisde2) {
        return jmtrSr.findByJmtrWeightedAverageIsGreaterThanEqualOrderByJmtrNameAsc(jmtrChisde2);
    }


}
