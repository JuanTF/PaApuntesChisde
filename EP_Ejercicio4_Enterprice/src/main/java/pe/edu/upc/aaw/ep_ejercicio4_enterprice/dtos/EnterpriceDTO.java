package pe.edu.upc.aaw.ep_ejercicio4_enterprice.dtos;

import java.util.Date;

public class EnterpriceDTO {
    private Long jmtrIdEnterprice;
    private String jmtrName;
    private Date jmtrDateRegistration;

    public Long getJmtrIdEnterprice() {
        return jmtrIdEnterprice;
    }

    public void setJmtrIdEnterprice(Long jmtrIdEnterprice) {
        this.jmtrIdEnterprice = jmtrIdEnterprice;
    }

    public String getJmtrName() {
        return jmtrName;
    }

    public void setJmtrName(String jmtrName) {
        this.jmtrName = jmtrName;
    }

    public Date getJmtrDateRegistration() {
        return jmtrDateRegistration;
    }

    public void setJmtrDateRegistration(Date jmtrDateRegistration) {
        this.jmtrDateRegistration = jmtrDateRegistration;
    }
}
