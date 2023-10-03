package pe.edu.upc.aaw.ep_ejercicio3_universidad.entities;

import javax.persistence.*;

@Entity
@Table(name ="University" )
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jmtrIdUniversity;
    @Column(name = "jmtrName",nullable = false,length = 40)
    private String jmtrName;
    @Column(name = "jmtrAddress",nullable = false,length = 50)
    private String jmtrAddress;
    @Column(name = "jmtrEmail",nullable = false,length = 45)
    private String jmtrEmail;

    public University(){

    }

    public University(Long jmtrIdUniversity, String jmtrName, String jmtrAddress, String jmtrEmail) {
        this.jmtrIdUniversity = jmtrIdUniversity;
        this.jmtrName = jmtrName;
        this.jmtrAddress = jmtrAddress;
        this.jmtrEmail = jmtrEmail;
    }

    public  Long getJmtrIdUniversity() {
        return jmtrIdUniversity;
    }

    public void setJmtrIdUniversity(Long jmtrIdUniversity) {
        this.jmtrIdUniversity = jmtrIdUniversity;
    }

    public String getJmtrName() {
        return jmtrName;
    }

    public void setJmtrName(String jmtrName) {
        this.jmtrName = jmtrName;
    }

    public String getJmtrAddress() {
        return jmtrAddress;
    }

    public void setJmtrAddress(String jmtrAddress) {
        this.jmtrAddress = jmtrAddress;
    }

    public String getJmtrEmail() {
        return jmtrEmail;
    }

    public void setJmtrEmail(String jmtrEmail) {
        this.jmtrEmail = jmtrEmail;
    }
}
