package pe.edu.upc.aaw.ep_ejercicio4_enterprice.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jmtrIdUser;

    @Column(length = 30, unique = true)
    private String jmtrUsername;
    @Column(length = 200)
    private String jmtrPassword;
    private Boolean jmtrEnabled;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "jmtrIdUser")
    private List<Role> jmtrRoles;

    //GET - SET

    public Long getJmtrIdUser() {
        return jmtrIdUser;
    }

    public void setJmtrIdUser(Long jmtrIdUser) {
        this.jmtrIdUser = jmtrIdUser;
    }

    public String getJmtrUsername() {
        return jmtrUsername;
    }

    public void setJmtrUsername(String jmtrUsername) {
        this.jmtrUsername = jmtrUsername;
    }

    public String getJmtrPassword() {
        return jmtrPassword;
    }

    public void setJmtrPassword(String jmtrPassword) {
        this.jmtrPassword = jmtrPassword;
    }

    public Boolean getJmtrEnabled() {
        return jmtrEnabled;
    }

    public void setJmtrEnabled(Boolean jmtrEnabled) {
        this.jmtrEnabled = jmtrEnabled;
    }

    public List<Role> getJmtrRoles() {
        return jmtrRoles;
    }

    public void setJmtrRoles(List<Role> jmtrRoles) {
        this.jmtrRoles = jmtrRoles;
    }
}
