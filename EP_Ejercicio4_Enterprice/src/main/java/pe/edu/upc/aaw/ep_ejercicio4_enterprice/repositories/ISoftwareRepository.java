package pe.edu.upc.aaw.ep_ejercicio4_enterprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities.Software;

import java.util.List;

@Repository
public interface ISoftwareRepository extends JpaRepository<Software,Long> {
    List<Software> findByJmtrEnterprice_JmtrNameOrderByJmtrNameAsc (String jmtrNameEnterprice);

    @Query(value = "SELECT so.*\n" +
            " FROM Software so \n" +
            " INNER JOIN Enterprice en ON en.jmtr_id_enterprice = so.jmtr_id_enterprice\n" +
            " WHERE en.jmtr_name = :jmtrQNameEnterprise\n" +
            " ORDER BY so.jmtr_name ASC",nativeQuery = true)
    public List<Software>listSoftwarePerNameEnterprise(String jmtrQNameEnterprise);

    @Query(value = "SELECT so.*\n" +
            " FROM Software so \n" +
            " INNER JOIN Enterprice en ON en.jmtr_id_enterprice = so.jmtr_id_enterprice\n" +
            " WHERE en.jmtr_name = :jmtrQNameEnterprise2\n" +
            " ORDER BY so.jmtr_name ASC",nativeQuery = true)
    public List<String[]>listSoftwarePerNameEnterprise2(String jmtrQNameEnterprise2);
}
