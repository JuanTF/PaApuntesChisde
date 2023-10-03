package pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="Enterprice" )
public class Enterprice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jmtrIdEnterprice;
    @Column(name = "jmtrName",nullable = false,length = 50)
    private String jmtrName;
    @Column(name = "jmtrDateRegistration",nullable = false)
    private Date jmtrDateRegistration;

    public Enterprice(){

    }

    public Enterprice(Long jmtrIdEnterprice, String jmtrName, Date jmtrDateRegistration) {
        this.jmtrIdEnterprice = jmtrIdEnterprice;
        this.jmtrName = jmtrName;
        this.jmtrDateRegistration = jmtrDateRegistration;
    }

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
