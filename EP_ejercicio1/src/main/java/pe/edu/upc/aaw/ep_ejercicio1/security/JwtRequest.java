package pe.edu.upc.aaw.ep_ejercicio1.security;

public class JwtRequest {
    private String jmtrUsername;
    private String jmtrPassword;


    //Constructor - GET - SET
    public JwtRequest(){

    }

    public JwtRequest(String jmtrUsername, String jmtrPassword) {
        this.jmtrUsername = jmtrUsername;
        this.jmtrPassword = jmtrPassword;
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
}
