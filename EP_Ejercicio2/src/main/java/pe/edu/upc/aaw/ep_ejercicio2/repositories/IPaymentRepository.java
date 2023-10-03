package pe.edu.upc.aaw.ep_ejercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.ep_ejercicio2.entities.Payment;

import java.util.List;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Long> {
    public List<Payment> findByJmtrMember_JmtrIdMember(Long jmtrQCodeMember2);

    @Query(value = "SELECT pa.jmtr_id_payment, pa.jmtr_amount, pa.jmtr_month, pa.jmtr_status, pa.jmtr_year, pa.jmtr_id_member \n" +
            "FROM Member me\n" +
            "JOIN Payment pa ON me.jmtr_id_member = pa.jmtr_id_member\n" +
            "WHERE me.jmtr_memeber_code = :jmtrQCodeMember",nativeQuery = true)
    public List<String[]> ListPaymentMember(Long jmtrQCodeMember);
    //Listar pagos de miembros


    @Query(value = "SELECT pa.*\n" +
            " FROM Member me\n" +
            " JOIN Payment pa ON me.jmtr_id_member = pa.jmtr_id_member\n" +
            " WHERE me.jmtr_memeber_code = :jmtrQCodeMember2\n" +
            " ORDER BY pa.jmtr_month",nativeQuery = true)
    public List<Payment> ListPaymentMember2(Long jmtrQCodeMember2);
}
