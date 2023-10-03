package pe.edu.upc.aaw.ep_ejercicio1.entities;

import javax.persistence.*;

@Entity
@Table(name ="Dessert" )
public class Dessert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jmtrIdDessert;
    @Column(name = "jmtrNameDessert",nullable = false,length = 40)
    private String jmtrNameDessert;
    @Column(name = "jmtrPreparationTimeDessert",nullable = false)
    private int jmtrPreparationTimeDessert;
    @Column(name = "jmtrDifficultyDessert",nullable = false,length = 60)
    private String jmtrDifficultyDessert;

    @Column(name = "jmtrCategoryDessert",nullable = false,length = 70)
    private String jmtrCategoryDessert;

    public Dessert(){

    }

    public Dessert(int jmtrIdDessert, String jmtrNameDessert, int jmtrPreparationTimeDessert, String jmtrDifficultyDessert, String jmtrCategoryDessert) {
        this.jmtrIdDessert = jmtrIdDessert;
        this.jmtrNameDessert = jmtrNameDessert;
        this.jmtrPreparationTimeDessert = jmtrPreparationTimeDessert;
        this.jmtrDifficultyDessert = jmtrDifficultyDessert;
        this.jmtrCategoryDessert = jmtrCategoryDessert;
    }

    public String getJmtrCategoryDessert() {
        return jmtrCategoryDessert;
    }

    public void setJmtrCategoryDessert(String jmtrCategoryDessert) {
        this.jmtrCategoryDessert = jmtrCategoryDessert;
    }

    public int getJmtrIdDessert() {
        return jmtrIdDessert;
    }

    public void setJmtrIdDessert(int jmtrIdDessert) {
        this.jmtrIdDessert = jmtrIdDessert;
    }

    public String getJmtrNameDessert() {
        return jmtrNameDessert;
    }

    public void setJmtrNameDessert(String jmtrNameDessert) {
        this.jmtrNameDessert = jmtrNameDessert;
    }

    public int getJmtrPreparationTimeDessert() {
        return jmtrPreparationTimeDessert;
    }

    public void setJmtrPreparationTimeDessert(int jmtrPreparationTimeDessert) {
        this.jmtrPreparationTimeDessert = jmtrPreparationTimeDessert;
    }

    public String getJmtrDifficultyDessert() {
        return jmtrDifficultyDessert;
    }

    public void setJmtrDifficultyDessert(String jmtrDifficultyDessert) {
        this.jmtrDifficultyDessert = jmtrDifficultyDessert;
    }
}
