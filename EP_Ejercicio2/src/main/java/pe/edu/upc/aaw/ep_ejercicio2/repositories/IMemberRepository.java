package pe.edu.upc.aaw.ep_ejercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.ep_ejercicio2.entities.Member;

import java.util.List;

@Repository
public interface IMemberRepository extends JpaRepository<Member,Long> {
    @Query(value = "SELECT me.jmtr_name as club, COUNT(me.jmtr_id_member)  AS quantityMembers\n" +
            " FROM member me\n" +
            " JOIN payment p ON me.jmtr_id_member = p.jmtr_id_member\n" +
            " WHERE p.jmtr_status = false AND p.jmtr_month = :jmtrQMonth\n" +
            " GROUP BY me.jmtr_name",nativeQuery = true)
    public List<String[]> QuantityMembersPerStatusPerMonth(String jmtrQMonth);



}
