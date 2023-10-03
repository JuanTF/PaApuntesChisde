package pe.edu.upc.aaw.ep_ejercicio3_universidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.ep_ejercicio3_universidad.entities.Student;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
    //Listar Por Mayor Cantidad De promedio
    @Query(value = "SELECT s.jmtr_name, s.jmtr_weighted_average\n" +
            " FROM Student s\n" +
            " JOIN University u ON s.jmtr_id_university = u.jmtr_id_university\n" +
            " WHERE s.jmtr_weighted_average >= :jmtrQualification\n" +
            " ORDER BY s.jmtr_name asc;",nativeQuery = true)
    public List<String[]> listStudentPerGreatestWeightedAverage(Double jmtrQualification);

    //Listar Por Mayor Cantidad De promedio findby
    public List<Student> findByJmtrWeightedAverageIsGreaterThanEqualOrderByJmtrNameAsc(Double jmtrChisde2);

    //--------------------------------------------------------------------------------------------------------
    @Query(value = "SELECT s.*\n" +
            " FROM Student s\n" +
            " JOIN University u ON s.jmtr_id_university = u.jmtr_id_university\n" +
            " WHERE u.jmtr_id_university = :jmtrQIdUniversity",nativeQuery = true)
    public List<Student> listStudentPerIdUniversity(Long jmtrQIdUniversity);

    public List<Student> findByJmtrUniversity_JmtrIdUniversity(Long jmtrQIdUni);




}
