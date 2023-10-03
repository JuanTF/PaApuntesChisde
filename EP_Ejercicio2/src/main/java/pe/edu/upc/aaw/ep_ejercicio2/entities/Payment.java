package pe.edu.upc.aaw.ep_ejercicio2.entities;

import javax.persistence.*;

@Entity
@Table(name ="Payment" )
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jmtrIdPayment;
    @Column(name = "jmtrMonth",nullable = false,length = 60)
    private String jmtrMonth;
    @Column(name = "jmtrYear",nullable = false,length = 60)
    private String jmtrYear;
    @Column(name = "jmtrAmount",nullable = false)
    private Double jmtrAmount;
    @Column(name = "jmtrStatus",nullable = false)
    private boolean jmtrStatus;

    @ManyToOne
    @JoinColumn(name = "jmtrIdMember")
    private Member jmtrMember;

    public Payment(){

    }

    public Payment(Long jmtrIdPayment, String jmtrMonth, String jmtrYear, Double jmtrAmount, boolean jmtrStatus, Member jmtrMember) {
        this.jmtrIdPayment = jmtrIdPayment;
        this.jmtrMonth = jmtrMonth;
        this.jmtrYear = jmtrYear;
        this.jmtrAmount = jmtrAmount;
        this.jmtrStatus = jmtrStatus;
        this.jmtrMember = jmtrMember;
    }

    public Long getJmtrIdPayment() {
        return jmtrIdPayment;
    }

    public void setJmtrIdPayment(Long jmtrIdPayment) {
        this.jmtrIdPayment = jmtrIdPayment;
    }

    public String getJmtrMonth() {
        return jmtrMonth;
    }

    public void setJmtrMonth(String jmtrMonth) {
        this.jmtrMonth = jmtrMonth;
    }

    public String getJmtrYear() {
        return jmtrYear;
    }

    public void setJmtrYear(String jmtrYear) {
        this.jmtrYear = jmtrYear;
    }

    public Double getJmtrAmount() {
        return jmtrAmount;
    }

    public void setJmtrAmount(Double jmtrAmount) {
        this.jmtrAmount = jmtrAmount;
    }

    public boolean isJmtrStatus() {
        return jmtrStatus;
    }

    public void setJmtrStatus(boolean jmtrStatus) {
        this.jmtrStatus = jmtrStatus;
    }

    public Member getJmtrMember() {
        return jmtrMember;
    }

    public void setJmtrMember(Member jmtrMember) {
        this.jmtrMember = jmtrMember;
    }
}
