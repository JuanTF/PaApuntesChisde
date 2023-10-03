package pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles", uniqueConstraints = { @UniqueConstraint(columnNames = { "jmtrIdUser", "jmtrRol" }) })
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jmtrId;

    private String jmtrRol;

    @ManyToOne
    @JoinColumn(name="jmtrIdUser", nullable=false)
    private Users jmtrUser;
    //GET - SET

    public Long getJmtrId() {
        return jmtrId;
    }

    public void setJmtrId(Long jmtrId) {
        this.jmtrId = jmtrId;
    }

    public String getJmtrRol() {
        return jmtrRol;
    }

    public void setJmtrRol(String jmtrRol) {
        this.jmtrRol = jmtrRol;
    }

    public Users getJmtrUser() {
        return jmtrUser;
    }

    public void setJmtrUser(Users jmtrUser) {
        this.jmtrUser = jmtrUser;
    }
}
