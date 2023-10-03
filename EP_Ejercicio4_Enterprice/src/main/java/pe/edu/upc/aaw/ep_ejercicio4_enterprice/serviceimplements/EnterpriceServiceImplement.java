package pe.edu.upc.aaw.ep_ejercicio4_enterprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities.Enterprice;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.repositories.IEnterpriceRepository;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.serviceinterfaces.IEnterpriceService;

@Service
public class EnterpriceServiceImplement implements IEnterpriceService {
    @Autowired
    private IEnterpriceRepository jmtrEr;

    @Override
    public void insert(Enterprice jmtrEnterprice) {
        jmtrEr.save(jmtrEnterprice);
    }
}
