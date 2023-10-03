package pe.edu.upc.aaw.ep_ejercicio4_enterprice.serviceinterfaces;

import pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities.Enterprice;
import pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities.Software;

import java.util.List;

public interface ISoftwareService {
    public void insert(Software jmtrSoftware);
    List<Software> findByJmtrEnterprice_JmtrNameOrderByJmtrNameAsc (String jmtrNameEnterprice);
    public List<Software>listSoftwarePerNameEnterprise(String jmtrQNameEnterprise);
    public List<String[]>listSoftwarePerNameEnterprise2(String jmtrQNameEnterprise2);
}
