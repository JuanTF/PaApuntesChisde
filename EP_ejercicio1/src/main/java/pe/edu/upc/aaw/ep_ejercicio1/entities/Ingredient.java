package pe.edu.upc.aaw.ep_ejercicio1.entities;

import javax.persistence.*;

@Entity
@Table(name ="Ingredient" )
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jmtrIdIngredient;

    @Column(name = "jmtrNameIngredient",nullable = false,length = 40)
    private String jmtrNameIngredient;
    @Column(name = "jmtrQuantityIngredient",nullable = false)
    private int jmtrQuantityIngredient;

    @ManyToOne
    @JoinColumn(name = "jmtrIdDessert")
    private Dessert jmtrDessert;

    public Ingredient(){

    }

    public Ingredient(int jmtrIdIngredient, String jmtrNameIngredient, int jmtrQuantityIngredient, Dessert jmtrDessert) {
        this.jmtrIdIngredient = jmtrIdIngredient;
        this.jmtrNameIngredient = jmtrNameIngredient;
        this.jmtrQuantityIngredient = jmtrQuantityIngredient;
        this.jmtrDessert = jmtrDessert;
    }

    public int getJmtrIdIngredient() {
        return jmtrIdIngredient;
    }

    public void setJmtrIdIngredient(int jmtrIdIngredient) {
        this.jmtrIdIngredient = jmtrIdIngredient;
    }

    public String getJmtrNameIngredient() {
        return jmtrNameIngredient;
    }

    public void setJmtrNameIngredient(String jmtrNameIngredient) {
        this.jmtrNameIngredient = jmtrNameIngredient;
    }

    public int getJmtrQuantityIngredient() {
        return jmtrQuantityIngredient;
    }

    public void setJmtrQuantityIngredient(int jmtrQuantityIngredient) {
        this.jmtrQuantityIngredient = jmtrQuantityIngredient;
    }

    public Dessert getJmtrDessert() {
        return jmtrDessert;
    }

    public void setJmtrDessert(Dessert jmtrDessert) {
        this.jmtrDessert = jmtrDessert;
    }
}
