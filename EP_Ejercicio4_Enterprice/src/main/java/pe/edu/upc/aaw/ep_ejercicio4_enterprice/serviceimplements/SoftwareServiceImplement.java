package pe.edu.upc.aaw.ep_ejercicio4_enterprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities.Software;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.repositories.ISoftwareRepository;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.serviceinterfaces.ISoftwareService;

import java.util.List;

@Service
public class SoftwareServiceImplement implements ISoftwareService {
    @Autowired
    private ISoftwareRepository jmtrSr;

    @Override
    public void insert(Software jmtrSoftware) {
        jmtrSr.save(jmtrSoftware);
    }

    @Override
    public List<Software> findByJmtrEnterprice_JmtrNameOrderByJmtrNameAsc(String jmtrNameEnterprice) {
        return jmtrSr.findByJmtrEnterprice_JmtrNameOrderByJmtrNameAsc(jmtrNameEnterprice);
    }

    @Override
    public List<Software> listSoftwarePerNameEnterprise(String jmtrQNameEnterprise) {
        return jmtrSr.listSoftwarePerNameEnterprise(jmtrQNameEnterprise);
    }

    @Override
    public List<String[]> listSoftwarePerNameEnterprise2(String jmtrQNameEnterprise2) {
        return jmtrSr.listSoftwarePerNameEnterprise2(jmtrQNameEnterprise2);
    }


}
