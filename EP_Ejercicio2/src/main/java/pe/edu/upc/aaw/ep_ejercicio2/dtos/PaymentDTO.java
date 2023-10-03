package pe.edu.upc.aaw.ep_ejercicio2.dtos;

import pe.edu.upc.aaw.ep_ejercicio2.entities.Member;

public class PaymentDTO {
    private Long jmtrIdPayment;
    private String jmtrMonth;
    private String jmtrYear;
    private Double jmtrAmount;
    private boolean jmtrStatus;
    private Member jmtrMember;

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
