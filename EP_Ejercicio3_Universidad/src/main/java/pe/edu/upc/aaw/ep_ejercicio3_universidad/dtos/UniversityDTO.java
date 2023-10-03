package pe.edu.upc.aaw.ep_ejercicio3_universidad.dtos;

public class UniversityDTO {
    private Long jmtrIdUniversity;
    private String jmtrName;
    private String jmtrAddress;
    private String jmtrEmail;

    public Long getJmtrIdUniversity() {
        return jmtrIdUniversity;
    }

    public void setJmtrIdUniversity(Long jmtrIdUniversity) {
        this.jmtrIdUniversity = jmtrIdUniversity;
    }

    public String getJmtrName() {
        return jmtrName;
    }

    public void setJmtrName(String jmtrName) {
        this.jmtrName = jmtrName;
    }

    public String getJmtrAddress() {
        return jmtrAddress;
    }

    public void setJmtrAddress(String jmtrAddress) {
        this.jmtrAddress = jmtrAddress;
    }

    public String getJmtrEmail() {
        return jmtrEmail;
    }

    public void setJmtrEmail(String jmtrEmail) {
        this.jmtrEmail = jmtrEmail;
    }
}
