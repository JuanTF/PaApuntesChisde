package pe.edu.upc.aaw.ep_ejercicio3_universidad.security;

public class JwtResponse {
    private final String jmtrtoken;

    //Constructor - GET
    public JwtResponse(String jmtrtoken) {
        this.jmtrtoken = jmtrtoken;
    }

    public String getJmtrtoken() {
        return jmtrtoken;
    }
}