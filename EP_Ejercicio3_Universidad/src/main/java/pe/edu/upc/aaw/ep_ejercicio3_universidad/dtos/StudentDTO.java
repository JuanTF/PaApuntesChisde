package pe.edu.upc.aaw.ep_ejercicio3_universidad.dtos;

import pe.edu.upc.aaw.ep_ejercicio3_universidad.entities.University;

public class StudentDTO {
    private Long jmtrIdStudent;
    private String jmtrCode;
    private String jmtrName;
    private double jmtrWeightedAverage;
    private University jmtrUniversity;

    public Long getJmtrIdStudent() {
        return jmtrIdStudent;
    }

    public void setJmtrIdStudent(Long jmtrIdStudent) { //cambio el long
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
