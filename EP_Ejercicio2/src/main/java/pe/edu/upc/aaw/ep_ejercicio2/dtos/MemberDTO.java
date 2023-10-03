package pe.edu.upc.aaw.ep_ejercicio2.dtos;

import javax.persistence.Column;

public class MemberDTO {
    private Long jmtrIdMember;
    private String jmtrName;
    private Long jmtrMemeber_Code;

    public Long getJmtrIdMember() {
        return jmtrIdMember;
    }

    public void setJmtrIdMember(Long jmtrIdMember) {
        this.jmtrIdMember = jmtrIdMember;
    }

    public String getJmtrName() {
        return jmtrName;
    }

    public void setJmtrName(String jmtrName) {
        this.jmtrName = jmtrName;
    }

    public Long getJmtrMemeber_Code() {
        return jmtrMemeber_Code;
    }

    public void setJmtrMemeber_Code(Long jmtrMemeber_Code) {
        this.jmtrMemeber_Code = jmtrMemeber_Code;
    }
}
