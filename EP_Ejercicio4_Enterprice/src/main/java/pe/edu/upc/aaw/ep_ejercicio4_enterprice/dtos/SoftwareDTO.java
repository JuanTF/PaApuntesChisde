package pe.edu.upc.aaw.ep_ejercicio4_enterprice.dtos;

import pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities.Enterprice;

import java.util.Date;

public class SoftwareDTO {
    private Long jmtrIdSoftware;
    private String jmtrName;
    private String jmtrCategory;
    private Date jmtrDateLaunch;
    private Enterprice jmtrEnterprice;

    public Long getJmtrIdSoftware() {
        return jmtrIdSoftware;
    }

    public void setJmtrIdSoftware(Long jmtrIdSoftware) {
        this.jmtrIdSoftware = jmtrIdSoftware;
    }

    public String getJmtrName() {
        return jmtrName;
    }

    public void setJmtrName(String jmtrName) {
        this.jmtrName = jmtrName;
    }

    public String getJmtrCategory() {
        return jmtrCategory;
    }

    public void setJmtrCategory(String jmtrCategory) {
        this.jmtrCategory = jmtrCategory;
    }

    public Date getJmtrDateLaunch() {
        return jmtrDateLaunch;
    }

    public void setJmtrDateLaunch(Date jmtrDateLaunch) {
        this.jmtrDateLaunch = jmtrDateLaunch;
    }

    public Enterprice getJmtrEnterprice() {
        return jmtrEnterprice;
    }

    public void setJmtrEnterprice(Enterprice jmtrEnterprice) {
        this.jmtrEnterprice = jmtrEnterprice;
    }
}
