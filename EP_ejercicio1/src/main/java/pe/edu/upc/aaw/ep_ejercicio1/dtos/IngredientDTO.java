package pe.edu.upc.aaw.ep_ejercicio1.dtos;

import pe.edu.upc.aaw.ep_ejercicio1.entities.Dessert;

public class IngredientDTO {
    private int jmtrIdIngredient;
    private String jmtrNameIngredient;
    private int jmtrQuantityIngredient;
    private Dessert jmtrDessert;

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
