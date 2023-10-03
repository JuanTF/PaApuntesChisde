package pe.edu.upc.aaw.ep_ejercicio3_universidad.entities;

import javax.persistence.*;

@Entity
@Table(name ="Student" )
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jmtrIdStudent;

    @Column(name = "jmtrCode",nullable = false,length = 40, unique = true)
    private String jmtrCode;
    @Column(name = "jmtrName",nullable = false,length = 45)
    private String jmtrName;
    @Column(name = "jmtrWeightedAverage",nullable = false)
    private double jmtrWeightedAverage;

    @ManyToOne
    @JoinColumn(name = "jmtrIdUniversity")
    private University jmtrUniversity;

    public Student(){

    }

    public Student(Long jmtrIdStudent, String jmtrCode, String jmtrName, double jmtrWeightedAverage, University jmtrUniversity) {
        this.jmtrIdStudent = jmtrIdStudent;
        this.jmtrCode = jmtrCode;
        this.jmtrName = jmtrName;
        this.jmtrWeightedAverage = jmtrWeightedAverage;
        this.jmtrUniversity = jmtrUniversity;
    }

    public Long getJmtrIdStudent() {
        return jmtrIdStudent;
    }

    public void setJmtrIdStudent(Long jmtrIdStudent) {
        this.jmtrIdStudent = jmtrIdStudent;
    }

    public String getJmtrCode() {
        return jmtrCode;
    }

    public void setJmtrCode(String jmtrCode) {
        this.jmtrCode = jmtrCode;
    }

    public String getJmtrName() {
        return jmtrName;
    }

    public void setJmtrName(String jmtrName) {
        this.jmtrName = jmtrName;
    }

    public double getJmtrWeightedAverage() {
        return jmtrWeightedAverage;
    }

    public void setJmtrWeightedAverage(double jmtrWeightedAverage) {
        this.jmtrWeightedAverage = jmtrWeightedAverage;
    }

    public University getJmtrUniversity() {
        return jmtrUniversity;
    }

    public void setJmtrUniversity(University jmtrUniversity) {
        this.jmtrUniversity = jmtrUniversity;
    }
}
