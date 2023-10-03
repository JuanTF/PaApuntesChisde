package pe.edu.upc.aaw.ep_ejercicio2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.ep_ejercicio2.entities.Payment;
import pe.edu.upc.aaw.ep_ejercicio2.repositories.IPaymentRepository;
import pe.edu.upc.aaw.ep_ejercicio2.serviceinterfaces.IPaymentService;

import java.util.List;

@Service
public class PaymentServiceImplement implements IPaymentService {
    @Autowired
    private IPaymentRepository jmtrPr;

    @Override
    public void insert(Payment jmtrPayment) {
        jmtrPr.save(jmtrPayment);
    }

    @Override
    public List<String[]> ListPaymentMember(Long jmtrQCodeMember) {
        return jmtrPr.ListPaymentMember(jmtrQCodeMember);
    }

    @Override
    public List<Payment> ListPaymentMember2(Long jmtrQCodeMember2) {
        return jmtrPr.ListPaymentMember2(jmtrQCodeMember2);
    }


}
