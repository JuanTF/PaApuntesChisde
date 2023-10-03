package pe.edu.upc.aaw.ep_ejercicio3_universidad.serviceinterfaces;

import pe.edu.upc.aaw.ep_ejercicio3_universidad.entities.Student;

import java.util.List;

public interface IStudentService {
    public void insert(Student jmtrStudent);
    public List<String[]> listStudentPerGreatestWeightedAverage(Double jmtrQualification);
    public List<Student> listStudentPerIdUniversity(Long jmtrQIdUniversity);
    public List<Student> findByJmtrUniversity_JmtrIdUniversity(Long jmtrQIdUni);
    public List<Student> findByJmtrWeightedAverageIsGreaterThanEqualOrderByJmtrNameAsc(Double jmtrChisde2);

}
