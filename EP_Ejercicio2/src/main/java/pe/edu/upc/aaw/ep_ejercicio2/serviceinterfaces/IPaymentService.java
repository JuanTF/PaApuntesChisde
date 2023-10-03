package pe.edu.upc.aaw.ep_ejercicio2.serviceinterfaces;

import pe.edu.upc.aaw.ep_ejercicio2.entities.Payment;

import java.util.List;

public interface IPaymentService {
    public void insert(Payment jmtrPayment);
    public List<String[]> ListPaymentMember(Long jmtrQCodeMember);

    public List<Payment> ListPaymentMember2(Long jmtrQCodeMember2);
}
