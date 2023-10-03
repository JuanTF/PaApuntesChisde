package pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="Software" )
public class Software {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jmtrIdSoftware;
    @Column(name = "jmtrName",nullable = false,length = 50)
    private String jmtrName;
    @Column(name = "jmtrCategory",nullable = false,length = 50)
    private String jmtrCategory;
    @Column(name = "jmtrDateLaunch",nullable = false)
    private Date jmtrDateLaunch;

    @ManyToOne
    @JoinColumn(name = "jmtrIdEnterprice")
    private Enterprice jmtrEnterprice;

    public Software(){

    }
    public Software(Long jmtrIdSoftware, String jmtrName, String jmtrCategory, Date jmtrDateLaunch, Enterprice jmtrEnterprice) {
        this.jmtrIdSoftware = jmtrIdSoftware;
        this.jmtrName = jmtrName;
        this.jmtrCategory = jmtrCategory;
        this.jmtrDateLaunch = jmtrDateLaunch;
        this.jmtrEnterprice = jmtrEnterprice;
    }

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

