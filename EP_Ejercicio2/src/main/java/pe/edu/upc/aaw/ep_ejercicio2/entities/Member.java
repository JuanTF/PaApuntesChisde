package pe.edu.upc.aaw.ep_ejercicio2.entities;

import javax.persistence.*;

@Entity
@Table(name ="Member" )
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jmtrIdMember;
    @Column(name = "jmtrName",nullable = false,length = 60)
    private String jmtrName;
    @Column(name = "jmtrMemeber_Code",nullable = false)
    private Long jmtrMemeber_Code;

    public Member(){

    }

    public Member(Long jmtrIdMember, String jmtrName, Long jmtrMemeber_Code) {
        this.jmtrIdMember = jmtrIdMember;
        this.jmtrName = jmtrName;
        this.jmtrMemeber_Code = jmtrMemeber_Code;
    }

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
